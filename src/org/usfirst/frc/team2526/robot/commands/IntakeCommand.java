package org.usfirst.frc.team2526.robot.commands;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeCommand extends Command {
	boolean bool;
	public IntakeCommand(boolean bool){
		this.bool = bool;
		requires(Robot.intake);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
	protected void execute(){
		if(bool) Robot.intake.enable();
		else Robot.intake.disable();
	}
	protected void end() {
		//Robot.intake.disable();
	}
	protected void interrupted() {
		//Robot.intake.disable();
	}
}
