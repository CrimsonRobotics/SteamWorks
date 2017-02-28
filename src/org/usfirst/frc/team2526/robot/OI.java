package org.usfirst.frc.team2526.robot;

import org.usfirst.frc.team2526.robot.commands.GameSelectorBalls;
import org.usfirst.frc.team2526.robot.commands.GearIntakeDrop;
import org.usfirst.frc.team2526.robot.commands.IntakeCommand;
import org.usfirst.frc.team2526.robot.commands.RunElevator;
import org.usfirst.frc.team2526.robot.commands.RunFlywheel;
import org.usfirst.frc.team2526.robot.commands.Shift;
import org.usfirst.frc.team2526.robot.commands.StopTurret;
import org.usfirst.frc.team2526.robot.commands.groups.LoadAndBallMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	/*
	 * DRIVER CONTROLS
	 */
	private Joystick driverLeft = new Joystick(0);
	private Joystick driverRight = new Joystick(1);
	private Button highGear = new JoystickButton(driverLeft, 2);
	/*
	 * CO DRIVER CONTROLS
	 */
	private Joystick coDriver = new Joystick(2);
	private Button GearDrop = new JoystickButton(coDriver, 10);
	private Button SwitchToBall = new JoystickButton(coDriver, 1);
	private Button intake = new JoystickButton(driverRight, 1);
	private Button elevator = new JoystickButton(driverLeft, 3); //WIP NUMBER
	private Button flywheel = new JoystickButton(coDriver, 1);
	private Button stopTurret = new JoystickButton(coDriver,12);
	
	public OI(){
		/*
		 * DRIVER COMMANDS
		 */
		highGear.whileHeld(new Shift());
		/*
		 * CO DRIVER COMMANDS
		 */
		GearDrop.whileHeld(new GearIntakeDrop());
		SwitchToBall.whileHeld(new LoadAndBallMode());
		intake.whileHeld(new IntakeCommand());
		stopTurret.whenPressed(new StopTurret());
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
