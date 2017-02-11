package org.usfirst.frc.team2526.robot;

import com.crimsonrobotics.lib.PID;

public class RobotMap {
	/*
	 * Climber CAN ID
	 */
	public static final int CLIMBER_MOTOR = 11;
	/*
	 * Drivetrain CAN IDs and gains
	 */
	public static final int DRIVETRAIN_FRONTLEFT = 9;
	public static final int DRIVETRAIN_FRONTRIGHT = 8;
	public static final int DRIVETRAIN_BACKLEFT = 1;
	public static final int DRIVETRAIN_BACKRIGHT = 2;
	public static final PID DRIVETRAIN_GAINS_LEFT = new PID(1, 0, 0);
	public static final PID DRIVETRAIN_GAINS_RIGHT = new PID(1, 0, 0);
	/*
	 * Elevator CAN IDs
	 */
	public static final int elevatorBottom = 13;
	public static final int elevatorMiddle = 14;
	/*
	 * Intake CAN IDs
	 */
	public static final int intakeRight = 7;
	/*
	 * Flywheel CAN IDs and PID gains
	 */
	public static final int FLYWHEEL_TALON = 11;
	public static final PID GAINS_FLYWHEEL = new PID(1,0,0);
	/*
	 * Gear placer Solenoids, PCM, and switch
	 */
	public static int DS_L_ONE; //Double Solenoid Left
	public static int DS_L_TWO; //Double Solenoid Left
	public static int DS_R_ONE; //Double Solenoid Right
	public static int DS_R_TWO; //Double Solenoid Right
	public static int SS_P; //Single Solenoid Placer
	public static int D_G_S; //Drop Gear Sensor
	/*
	 * Turret Talons and PID gains.
	 */
	public static final int TURRET_TALON = 11;
	public static final PID GAINS_TURRET = new PID(1,0,0);
}