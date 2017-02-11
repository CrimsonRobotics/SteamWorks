package org.usfirst.frc.team2526.robot.commands.test;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpeedDriveCommand extends Command {
	private int speedLeft = 0; //Defaults to 0
	private int speedRight = 0; //Defaults to 0
	/*
	 * @param Speed in rotations per minute (RPM).
	 */
	public SpeedDriveCommand(int speedLeft, int speedRight){
		requires(Robot.driveTrain);
		this.speedLeft = speedLeft;
		this.speedRight = speedRight;
	}
	protected void execute() {
		Robot.driveTrain.speedDrive(speedLeft, speedRight);	
		Robot.driveTrain.outputSpeedsToDebug();
	}
	@Override
	protected boolean isFinished() {
		return false;
	}
	protected void end() {
		Robot.driveTrain.speedDrive(0, 0);
	}
}
