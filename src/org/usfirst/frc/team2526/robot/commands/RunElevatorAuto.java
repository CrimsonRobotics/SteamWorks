package org.usfirst.frc.team2526.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.subsystems.Elevator;

/**
 *
 */
public class RunElevatorAuto extends Command {
	//private int rpm;
	Elevator elevator;
	
	
	public RunElevatorAuto(int time) {
		super(time);
		//this.rpm = rpm;
		requires(Robot.elevator);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.elevator.elevatorVbus(RobotMap.ELEVATOR_SPEED_VBUS);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		//Robot.elevator.runElevator(rpm);
		
		Robot.elevator.logSpeed();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.elevator.stopElevator();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.elevator.stopElevator();
	}
}