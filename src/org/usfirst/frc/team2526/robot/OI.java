package org.usfirst.frc.team2526.robot;

import org.usfirst.frc.team2526.robot.commands.GameSelectorBalls;
import org.usfirst.frc.team2526.robot.commands.GameSelectorGear;
import org.usfirst.frc.team2526.robot.commands.GearIntakeDrop;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick driverLeft = new Joystick(0);
	private Joystick driverRight = new Joystick(1);
	private Joystick coDriver = new Joystick(2);
	private Button GearDrop = new JoystickButton(coDriver, 1);
	private Button SwitchToBall = new JoystickButton(coDriver, 2);
	private Button SwitchToGear = new JoystickButton(coDriver, 3);
	
	public OI(){
		GearDrop.whenPressed(new GearIntakeDrop());
		SwitchToBall.whenPressed(new GameSelectorBalls());
		SwitchToGear.whenPressed(new GameSelectorGear());
	}
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
