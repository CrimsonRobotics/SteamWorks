package org.usfirst.frc.team2526.robot;

import edu.wpi.first.wpilibj.Joystick;

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
