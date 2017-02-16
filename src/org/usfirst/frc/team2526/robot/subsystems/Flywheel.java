package org.usfirst.frc.team2526.robot.subsystems;

import com.crimsonrobotics.lib.PID;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Flywheel extends Subsystem {
	private CANTalon fwTalon;
	private CANTalon fwTalonFollower;
	private PID gainsFW;
	
	public Flywheel(int fwID, int fwFollowerID, PID gains) {
		fwTalon = new CANTalon(fwID);
		fwTalonFollower = new CANTalon(fwFollowerID);
		fwTalonFollower.changeControlMode(CANTalon.TalonControlMode.Follower);
		fwTalonFollower.set(fwTalon.getDeviceID());
		gainsFW = gains;
		fwTalon.configEncoderCodesPerRev(360);
		fwTalon.setPosition(0);
		fwTalon.setSafetyEnabled(false);
		fwTalon.reverseSensor(false);
		pidInit();
	}
	private void pidInit(){
		fwTalon.setPID(gainsFW.p, gainsFW.i, gainsFW.d, gainsFW.f, gainsFW.iZone, gainsFW.rampRate, gainsFW.profile);
		fwTalon.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		fwTalon.changeControlMode(CANTalon.TalonControlMode.Speed);
		fwTalon.enable();
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	public void runFlywheel(int rpm){
		fwTalon.set(rpm);
	}
	
	public void stopFlywheel(){
		fwTalon.set(0);
	}
}
