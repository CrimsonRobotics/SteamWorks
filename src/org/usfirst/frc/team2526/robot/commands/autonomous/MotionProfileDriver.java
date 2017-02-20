package org.usfirst.frc.team2526.robot.commands.autonomous;

import java.io.File;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;

public class MotionProfileDriver extends Command {
	private Trajectory trajectoryLeft; //Left wheel speed
	private Trajectory trajectoryRight; //Right wheel speed
	private Trajectory trajectoryCenter; //Used for determining heading
	private int iterator = 0; //Used for iteration and determining when to end command.
	private boolean finished = false;
	private double CORRECTION_FACTOR = 12;
	private double inchesPerMeter = 39.37;
	private double wheelInches = 0;
	
	public MotionProfileDriver(String pathLeft, String pathRight, String pathCenter, double wheelInches){
		requires(Robot.driveTrain);
		File curveFileLeft = new File(pathLeft);
		File curveFileRight = new File(pathRight);
		File curveFileCenter = new File(pathCenter);
		trajectoryLeft = Pathfinder.readFromCSV(curveFileLeft);
		trajectoryRight = Pathfinder.readFromCSV(curveFileRight);
		trajectoryCenter = Pathfinder.readFromCSV(curveFileCenter);
		this.wheelInches = wheelInches;
	}
	public MotionProfileDriver(Trajectory trajectoryLeft, Trajectory trajectoryCenter, Trajectory trajectorRight){
		this.trajectoryLeft = trajectoryLeft;
		this.trajectoryCenter = trajectoryCenter;
		this.trajectoryRight = trajectoryRight;
	}
	// Called just before this Command runs the first time
	@Override
	protected void initialize(){
		Robot.gyro.calibrate();
	}
	@Override
	protected boolean isFinished(){
		// TODO Auto-generated method stub
		return finished;
	}
	@Override
	protected void execute() {
		double angle = Robot.gyro.getAngle()%360.0;	
		iterator += 1;
		if(iterator < trajectoryLeft.segments.length){
			double headingDegrees = trajectoryCenter.segments[iterator].heading * 180/Math.PI;
			double headingError = headingDegrees - angle;
			double headingCorrection = headingError* CORRECTION_FACTOR;
			double leftSpeed = calculateRPM(trajectoryLeft.segments[iterator].velocity) + headingCorrection;
			double rightSpeed = calculateRPM(trajectoryRight.segments[iterator].velocity) - headingCorrection;
			Robot.driveTrain.speedDrive(leftSpeed, rightSpeed);
		}else{
			finished = true;
		}
	}
	private double calculateRPM(double velocity){
		double inchesPerSecond = velocity * inchesPerMeter;
		double inchesPerRevolution = wheelInches * Math.PI;
		double rpm = (inchesPerSecond * 60) / inchesPerRevolution;
		return rpm;
	}
}
