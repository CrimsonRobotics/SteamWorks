package org.usfirst.frc.team2526.robot.commands;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearIntakeDrop extends Command { //TEST COMMAND
	double delay;
    public GearIntakeDrop(double delay) {
        // Use requires() here to declare subsystem dependencies
    	this.delay = delay;
        requires(Robot.gearintake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gearintake.dropGear();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Timer.delay(delay);
    	Robot.gearintake.closeGearIntake();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Timer.delay(delay);
    	Robot.gearintake.closeGearIntake();
    }
}
