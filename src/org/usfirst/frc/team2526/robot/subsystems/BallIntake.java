package org.usfirst.frc.team2526.robot.subsystems;

import com.crimsonrobotics.lib.PID;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallIntake extends Subsystem {
	private CANTalon topMotor;
	private CANTalon bottomMotor;
	private PID gainsTop;
	private PID gainsBottom;
	 
	public BallIntake(int topMotorID, int bottomMotorID, PID gainsTop, PID gainsBottom){
		topMotor = new CANTalon(topMotorID);
		bottomMotor = new CANTalon(bottomMotorID);
		this.gainsTop = gainsTop;
		this.gainsBottom = gainsBottom;
		pidSetup(topMotor, gainsTop);
		pidSetup(bottomMotor, gainsBottom);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	private void pidSetup(CANTalon talon, PID gains){
		talon.changeControlMode(CANTalon.TalonControlMode.Speed);
		talon.setPID(gains.p, gains.i, gains.d, gains.f, gains.iZone, gains.rampRate, gains.profile);
		talon.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
	}
	/*
	 * @param speed in rotations per minute of the top motor.
	 * @param speed in rotations per minute of the bottom motor.
	 */
	public void setSpeed(int speedTop, int speedBottom){
		//enable PID control
		topMotor.enable();
		bottomMotor.enable();
		//set speed
		topMotor.set(speedTop);
		bottomMotor.set(speedBottom);
	}
	public void stopIntake(){
		//Set speed to 0 RPM
		topMotor.set(0);
		bottomMotor.set(0);
		//disable PID
		topMotor.disable();
		bottomMotor.disable();
	}
}
