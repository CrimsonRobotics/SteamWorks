package org.usfirst.frc.team2526.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  public static final int CLIMBER_MOTOR = 0;
	public static final int driveTrainFrontLeft = 9;
	public static final int driveTrainFrontRight = 2;
	public static final int driveTrainBackLeft = 1;
	public static final int driveTrainBackRight = 8;
  public static final int elevatorBottom = 9;
	public static final int elevatorMiddle = 8;
	public static final int intakeRight = 7;
  public static final int FLYWHEEL_TALON = 11;
	public static final PID GAINS_FLYWHEEL = new PID(1,0,0);
  public static int DS_L_ONE; //Double Solenoid Left
	public static int DS_L_TWO; //Double Solenoid Left
	public static int DS_R_ONE; //Double Solenoid Right
	public static int DS_R_TWO; //Double Solenoid Right
	public static int SS_P; //Single Solenoid Platear
	public static int D_G_S; //Drop Gear Sensor
}