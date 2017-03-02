package org.usfirst.frc.team2526.robot.commands;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LoadHopper extends Command {
	public LoadHopper(){
		requires(Robot.hopper);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	protected void execute() {
		Robot.hopper.loadHopper();
	}
	protected void interrupted() {
		Robot.hopper.disableHopper();
	}
}
