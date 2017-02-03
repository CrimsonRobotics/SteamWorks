package org.usfirst.frc.team2526.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.subsystems.Flywheel;

public class RunFlywheel extends Command {
	
	private int rpm = 3000;
	Flywheel FW;
	
	public RunFlywheel(int rpm, Flywheel FW) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.flywheel);
		this.FW = FW;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		FW.runFlywheel(rpm);
		
		SmartDashboard.putNumber("rotationsPerMinute: " , rpm);
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		FW.stopFlywheel();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}