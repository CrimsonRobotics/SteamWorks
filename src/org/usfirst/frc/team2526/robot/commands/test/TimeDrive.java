package org.usfirst.frc.team2526.robot.commands.test;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TimeDrive extends Command {
	private double VbusL, VbusR;
    public TimeDrive(double time, double VbusL, double VbusR) {
    	super(time);
    	this.VbusL = VbusL;
    	this.VbusR = VbusR;

 

        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.teleopDriveInit();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	Robot.driveTrain.percentVBusDrive(VbusL, VbusR);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.percentVBusDrive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveTrain.percentVBusDrive(0,0);
    }
}
