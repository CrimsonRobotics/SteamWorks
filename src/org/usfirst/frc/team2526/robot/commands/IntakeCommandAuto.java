package org.usfirst.frc.team2526.robot.commands;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeCommandAuto extends Command {
	public IntakeCommandAuto(double time){
		super(time);
		requires(Robot.intake);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}
	protected void execute(){
		Robot.intake.enable();
	}
	protected void end() {
		Robot.intake.disable();
	}
	protected void interrupted() {
		Robot.intake.disable();
	}
}
