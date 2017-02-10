package org.usfirst.frc.team2526.robot;

import com.crimsonrobotics.lib.PID;

public class RobotMap {
	/*
	 * Climber CAN ID
	 */
	public static final int CLIMBER_MOTOR = 0;
	/*
	 * Drivetrain CAN IDs
	 */
	public static final int DRIVETRAIN_FRONTLEFT = 9;
	public static final int DRIVETRAIN_FRONTRIGHT = 2;
	public static final int DRIVETRAIN_BACKLEFT = 1;
	public static final int DRIVETRAIN_BACKRIGHT = 8;
	/*
	 * Elevator CAN IDs
	 */
	public static final int elevatorBottom = 9;
	public static final int elevatorMiddle = 8;
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
	public static int SS_P; //Single Solenoid Platear
	public static int D_G_S; //Drop Gear Sensor
}