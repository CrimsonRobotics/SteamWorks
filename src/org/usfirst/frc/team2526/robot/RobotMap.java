package org.usfirst.frc.team2526.robot;

import com.crimsonrobotics.lib.PID;

public class RobotMap {
	/*
	 * Climber CAN ID
	 */
	public static final int CLIMBER_MOTOR = 11;
	/*
	 * Drivetrain CAN IDs and PID gains.
	 * Gains (1.2, 0.001, 6, 1.1, 20, 0, 0)
	 */
	public static final int DRIVETRAIN_FRONTLEFT = 8;
	public static final int DRIVETRAIN_FRONTRIGHT = 9;
	public static final int DRIVETRAIN_BACKLEFT = 2;
	public static final int DRIVETRAIN_BACKRIGHT = 1;
	public static final PID DRIVETRAIN_GAINS_LEFT = new PID(0, 0, 0, 1.1, 0, 0, 0);
	public static final PID DRIVETRAIN_GAINS_RIGHT = new PID(0, 0, 0, 1.1, 0, 0, 0);
	/*
	 * Elevator CAN IDs and PID gains
	 */
	public static final int ELEVATOR_BOTTOM = 9;
	public static final int ELEVATOR_TOP = 8;
	public static final PID ELEVATOR_PID_GAINS = new PID(1,0,0);
	/*
	 * Intake CAN IDs
	 */
	public static final int intakeRight = 7;
	/*
	 * Flywheel CAN IDs and PID gains
	 */
	public static final int FLYWHEEL_TALON = 11;
	public static final int FLYWHEEL_TALON_FOLLOWER = 130;
	public static final PID GAINS_FLYWHEEL = new PID(1,0,0);
	/*
	 * Gear placer Solenoids, PCM, and switch
	 */
	
	public static final int DS_L_ONE = 1; //Double Solenoid Left
	public static final int DS_L_TWO = 2; //Double Solenoid Left
	public static final int DS_R_ONE = 3; //Double Solenoid Right
	public static final int DS_R_TWO = 4; //Double Solenoid Right
	public static final int SS_P = 0; //Single Solenoid Plate
	public static final int D_G_S = 5; //Drop Gear Sensor

	/*
	 * Turret Talons and PID gains.
	 */
	public static final int TURRET_TALON = 11;
	public static final PID GAINS_TURRET = new PID(1,0,0);
}