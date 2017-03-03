package org.usfirst.frc.team2526.robot;

import com.crimsonrobotics.lib.PID;

public class RobotMap {
	/*
	 * Climber CAN ID
	 */
	public static final int CLIMBER_MOTOR = 1;
	/*
	 * Drivetrain CAN IDs and PID gains.
	 * Gains (1.2, 0.001, 6, 1.1, 20, 0, 0)
	 */
	public static final int DRIVETRAIN_FRONTLEFT = 3;
	public static final int DRIVETRAIN_FRONTRIGHT = 13;
	public static final int DRIVETRAIN_BACKLEFT = 4;
	public static final int DRIVETRAIN_BACKRIGHT = 11;
	public static final PID DRIVETRAIN_GAINS_LEFT = new PID(0, 0, 0, 1.1, 0, 0, 0);
	public static final PID DRIVETRAIN_GAINS_RIGHT = new PID(0, 0, 0, 1.1, 0, 0, 0);
	/*
	 * Shifter ID and channel.
	 */
	public static final int SHIFTER = 0;//PCM CAN ID //MUST CHANGE NAME
	public static final int CHANNEL = 0;//nead real value
	/*
	 * Elevator CAN IDs and PID gains
	 */
	public static final int ELEVATOR_BOTTOM = 2;
	public static final int ELEVATOR_TOP = 5;
	public static final PID ELEVATOR_GAINS_BOTTOM = new PID(0,0,0,1);
	public static final PID ELEVATOR_GAINS_TOP = new PID(0,0,0,1);
	public static final int ELEVATOR_SPEED = 50; //Vbus
	/*
	 * Intake CAN IDs
	 */
	public static final int INTAKE = 6;
	/*
	 * Flywheel CAN IDs and PID gains
	 */
	public static final int FLYWHEEL_TALON = 8;
	public static final int FLYWHEEL_TALON_FOLLOWER = 9;
	public static final PID GAINS_FLYWHEEL = new PID(0.29,0.0001,10,0.035,0,0,1);//.29,.0001,10,0.035,0,0
	public static final int FLYWHEEL_BASE_SPEED = 3000; //RPM
	public static final double INPUT_MULTIPLIER = 0.75; //WIP
	/*
	 * Gear placer Solenoids, PCM, and switch
	 */
	
	public static final int DS_L_ONE = 1; //Double Solenoid Left
	public static final int DS_L_TWO = 2; //Double Solenoid Left ONE DS
//	public static final int DS_R_ONE = 3; //Double Solenoid Right
//	public static final int DS_R_TWO = 4; //Double Solenoid Right
	public static final int SS_P = 3; //Single Solenoid Plate
	public static final int D_G_S = 5; //Drop Gear Sensor

	/*
	 * Turret Talons and PID gains.
	 */
	public static final int TURRET_TALON = 7;
	public static final PID GAINS_TURRET = new PID(0,0,0);
	/*
	 * Motion profile curve base directory and names
	 */
	public static final String BASE_DIR = "/tmp/";
	public static final String AUTONOMOUS_MODE_ONE = "AutonomousOne";
	public static final String CURVE_LEFT = "Left";
	public static final String CURVE_CENTER = "Center";
	public static final String CURVE_RIGHT = "Right";
	
	public static final int HOPPER_TOP_TALON = 100;
	public static final int HOPPER_BOTTOM_TALON = 101;

}