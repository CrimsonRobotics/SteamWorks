package org.usfirst.frc.team2526.robot.commands.test;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TestSpeedDriveCommand extends Command {
	private int speed;
	
	
	/*
	 * @param Speed in rotations per minute (RPM).
	 */
	public TestSpeedDriveCommand(int speed){
		this.speed = speed;
	}
	protected void initialize() {
		Robot.driveTrain.pidSpeedInit();
	}
	protected void execute() {
		Robot.driveTrain.speedDrive(speed, speed);
		Robot.driveTrain.printSpeedToDebug();
		Robot.driveTrain.printAngleToDebug();
	}
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	protected void end() {
		//Robot.driveTrain.speedDrive(0, 0);
	}
}
