package com.crimsonrobotics.lib;

import com.ctre.CANTalon;

/*
 * This is a wrapper for Cross The Road Electronic's Talon SRX API.
 */
public class CrimsonTalonSRX extends CANTalon{
	/*
	 * @param CAN ID for Talon SRX
	 */
	public CrimsonTalonSRX(int ID){
		super(ID);
	}
	/*
	 * @param Motor to set as a slave of this motor.
	 */
	public void setFollowerOf(CANTalon follower){
		follower.changeControlMode(CANTalon.TalonControlMode.Follower);
		follower.set(super.getDeviceID());
	}
	/*
	 * @param Feedback device for closed loop control.
	 * @param PID gains for closed loop control
	 * 
	 * This is the method that you should call if you are using the CTRE Magnetic encoders as you do not
	 * need to define ticks per revolution.
	 */
	public void setupPID(CANTalon.FeedbackDevice device, PID gains){
		super.setFeedbackDevice(device);
		setPIDGains(gains);
	}
	/*
	 * @param Feedback device for closed loop control.
	 * @param ticks per revolution of encoder.
	 * @param PID gains for closed loop control
	 * 
	 * This will be the method that you will need to use if you are not using the CTRE Magnetic encoders,
	 * such as a quad encoder.
	 */
	public void setupPID(CANTalon.FeedbackDevice device, int ticksPerRev, PID gains){
		setupPID(device, gains);
		super.configEncoderCodesPerRev(ticksPerRev);
	}
	/*
	 * @param PID gains to be set on Talon for closed loop control.
	 * 
	 * This is a method for changing the current PID values on the Talon.
	 * This is intended to be used within the CrimsonTalonSRX class but is publicly available
	 * in the case that it would be useful.
	 */
	public void setPIDGains(PID gains){
		super.setPID(gains.p,
					gains.i, 
					gains.d, 
					gains.f, 
					gains.iZone, 
					gains.rampRate, 
					gains.profile);
	}
	/*
	 * @param speed in rotations per minutes (RPM).
	 * 
	 * This method changes the control mode of the Talon and sets the speed. It also enables closed loop control.
	 */
	public void setSpeed(int speed){
		super.changeControlMode(CANTalon.TalonControlMode.Speed);
		super.set(speed);
		super.enable();
	}
	/*
	 * This method changes the control of the Talon to PercentVbus so it can be used with RobotDrive.
	 */
	public void changePercentVbus(){
		super.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}
}
