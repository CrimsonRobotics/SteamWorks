package org.usfirst.frc.team2526.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2526.robot.Robot;

public class RunFlywheel extends Command {

	private int rpm;
	
	public RunFlywheel(int rpm) {
		// Use requires() here to declare subsystem dependencies
		this.rpm = rpm;
		requires(Robot.flywheel);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		Robot.flywheel.runFlywheel(rpm);
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.flywheel.stopFlywheel();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}