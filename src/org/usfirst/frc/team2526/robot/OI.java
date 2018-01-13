package org.usfirst.frc.team2526.robot;

import org.usfirst.frc.team2526.robot.commands.ClimbBool;
import org.usfirst.frc.team2526.robot.commands.GameSelectorBalls;
import org.usfirst.frc.team2526.robot.commands.GameSelectorGears;
import org.usfirst.frc.team2526.robot.commands.GearIntakeDrop;
import org.usfirst.frc.team2526.robot.commands.groups.GearDropClose;
import org.usfirst.frc.team2526.robot.commands.IntakeCommand;
import org.usfirst.frc.team2526.robot.commands.ReverseElevator;
import org.usfirst.frc.team2526.robot.commands.RunElevator;
import org.usfirst.frc.team2526.robot.commands.RunFlywheel;
import org.usfirst.frc.team2526.robot.commands.Shift;
import org.usfirst.frc.team2526.robot.commands.StopTurret;
import org.usfirst.frc.team2526.robot.commands.groups.ElevatorAndShoot;
import org.usfirst.frc.team2526.robot.commands.groups.ElevatorUnjamGroup;
import org.usfirst.frc.team2526.robot.commands.groups.GearDropAndHold;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

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
	private Button GearDrop = new JoystickButton(coDriver, 4);
	private Button GearDropClose = new JoystickButton(coDriver, 7);
	private Button BallIntake = new JoystickButton(coDriver, 2);//acts as hopper must toggle
	private Button BallIntakeStop = new JoystickButton(coDriver, 9);
	private Button Shoot = new JoystickButton(coDriver, 1);
	private Button stopTurret = new JoystickButton(coDriver,12);
	private Button ClimbMode = new JoystickButton(coDriver, 6);
	private Button GearMode = new JoystickButton(coDriver, 5); //WIP TEST
	private Button BallMode = new JoystickButton(coDriver, 3); //WIP TEST
	private Button elevator = new JoystickButton(coDriver, 9); //Run Elevator Only
	private Button reverseElevator = new JoystickButton(coDriver, 8);
	
	public OI(){
		/*
		 * DRIVER COMMANDS
		 */
		highGear.whileHeld(new Shift());
		/*
		 * CO DRIVER COMMANDS
		 */
//		GearDrop.whileHeld(new GearIntakeDrop());
		GearDrop.whenPressed(new GearDropAndHold(true));
		GearDropClose.whenPressed(new GearDropAndHold(false));
//		BallIntake.whileHeld(new LoadAndBallMode());
		//BallIntake.to
//		Shoot.whileHeld(new ElevatorAndShoot(RobotMap.ELEVATOR_SPEED, RobotMap.FLYWHEEL_BASE_SPEED));
		//stopTurret.whenPressed(new StopTurret());
		ClimbMode.whileHeld(new ClimbBool());
		GearMode.whenPressed(new GameSelectorGears());
		BallMode.whenPressed(new GameSelectorBalls());
		elevator.whileHeld(new RunElevator(RobotMap.ELEVATOR_SPEED));
		BallIntake.whenPressed(new IntakeCommand(true));
		BallIntakeStop.whenPressed(new IntakeCommand(false));
//		Shoot.whileHeld(new ElevatorAndShoot(RobotMap.ELEVATOR_SPEED, RobotMap.FLYWHEEL_BASE_SPEED));
		Shoot.whileHeld(new ElevatorAndShoot(RobotMap.ELEVATOR_SPEED, RobotMap.FLYWHEEL_BASE_SPEED));
		reverseElevator.whileHeld(new ElevatorUnjamGroup());
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
