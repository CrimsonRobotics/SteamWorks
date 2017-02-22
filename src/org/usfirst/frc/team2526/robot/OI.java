package org.usfirst.frc.team2526.robot;

import org.usfirst.frc.team2526.robot.commands.GameSelectorBalls;
import org.usfirst.frc.team2526.robot.commands.GameSelectorGear;
import org.usfirst.frc.team2526.robot.commands.GearIntakeDrop;
import org.usfirst.frc.team2526.robot.commands.IntakeCommand;
import org.usfirst.frc.team2526.robot.commands.RunElevator;
import org.usfirst.frc.team2526.robot.commands.RunFlywheel;

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
	//private Button GearDrop = new JoystickButton(coDriver, 1);
	private Button SwitchToBall = new JoystickButton(coDriver, 2);
	private Button SwitchToGear = new JoystickButton(coDriver, 3);
	private Button intake = new JoystickButton(driverRight, 1);
	private Button elevator = new JoystickButton(driverLeft, 2);
	private Button flywheel = new JoystickButton(coDriver, 1);
	
	public OI(){
		//GearDrop.whileHeld(new GearIntakeDrop());
		SwitchToBall.whenPressed(new GameSelectorBalls());
		SwitchToGear.whenPressed(new GameSelectorGear());
		intake.whileHeld(new IntakeCommand());
		elevator.whileHeld(new RunElevator(RobotMap.ELEVATOR_SPEED));
		flywheel.whileHeld(new RunFlywheel(RobotMap.FLYWHEEL_BASE_SPEED));
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
