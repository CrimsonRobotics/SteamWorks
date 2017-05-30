package org.usfirst.frc.team2526.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2526.robot.Robot;

public class Shift extends Command {
	
	public Shift(){
		requires(Robot.shifter);
	}
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.shifter.shiftHigh();
	}
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
	}
	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}
	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.shifter.shiftLow();
	}
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.shifter.shiftLow();
	}
}
