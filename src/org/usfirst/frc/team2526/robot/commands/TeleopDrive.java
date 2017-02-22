package org.usfirst.frc.team2526.robot.commands;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TeleopDrive extends Command {
	public TeleopDrive() {
		requires(Robot.driveTrain);
	}
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.driveTrain.teleopCraneDrive(Robot.oi.getDriverLeft(), Robot.oi.getDriverRight());
	}
	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}
}
