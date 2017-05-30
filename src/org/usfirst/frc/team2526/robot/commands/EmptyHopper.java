package org.usfirst.frc.team2526.robot.commands;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class EmptyHopper extends Command {
	public EmptyHopper(){
		requires(Robot.hopper);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	protected void execute() {
		Robot.hopper.emptyHopper();	
	}
	protected void interrupted() {
		Robot.hopper.disableHopper();
	}
}
