package org.usfirst.frc.team2526.robot;

import com.crimsonrobotics.lib.PID;

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
  public static int elevatorBottom = 9;
	public static int elevatorMiddle = 8;
	public static int INTAKE_TOP = 7;
	public static int INTAKE_BOTTOM = 7;
	public static PID INTAKE_GAINS_TOP = new PID(1,0,0);
	public static PID INTAKE_GAINS_BOTTOM = new PID(1,0,0);
}