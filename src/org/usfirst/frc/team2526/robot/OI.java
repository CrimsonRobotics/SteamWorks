package org.usfirst.frc.team2526.robot;

import edu.wpi.first.wpilibj.Joystick;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick driverLeft = new Joystick(0);
	private Joystick driverRight = new Joystick(1);
	private Joystick coDriver = new Joystick(2);
	
	public Joystick getDriverLeft(){
		return driverLeft;
	}
	public Joystick getDriverRight(){
		return driverRight;
	}
	public Joystick getCoDriver(){
		return coDriver;
	}
}
