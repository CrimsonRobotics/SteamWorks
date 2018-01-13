package org.usfirst.frc.team2526.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallIntake extends Subsystem {
	private WPI_TalonSRX motor;
//	private static boolean toggled = false;
	public BallIntake(int motorID){
		motor = new WPI_TalonSRX(motorID);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	public void enable() {
		motor.set(.5);
	}
	public void disable() {
		motor.set(0);
	}
//	public void toggle() {
//		motor.set(toggled ? 0.75 : 0);
//		toggled = !toggled;
//	}
//	public void disable() {
//		motor.set(0);
//	}
}
