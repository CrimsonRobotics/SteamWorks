package org.usfirst.frc.team2526.robot.subsystems;

import com.crimsonrobotics.lib.PID;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Flywheel extends Subsystem {
	private CANTalon fwTalon;
	private CANTalon fwTalonFollower;
	private PID gainsFW;
	
	public Flywheel(int fwID, int fwFollowerID, PID gains) {
		fwTalon = new CANTalon(fwID);
		fwTalonFollower = new CANTalon(fwFollowerID);
		fwTalonFollower.changeControlMode(CANTalon.TalonControlMode.Follower);
		fwTalonFollower.set(fwTalon.getDeviceID());
		fwTalon.reverseOutput(true);
		gainsFW = gains;
		fwTalon.setSafetyEnabled(false);
		fwTalon.reverseSensor(true);
		pidInit();
	}
	private void pidInit(){
		fwTalon.setPID(gainsFW.p, gainsFW.i, gainsFW.d, gainsFW.f, gainsFW.iZone, gainsFW.rampRate, gainsFW.profile);
		fwTalon.setFeedbackDevice(CANTalon.FeedbackDevice.PulseWidth);
		fwTalon.changeControlMode(CANTalon.TalonControlMode.Speed);
		fwTalon.enable();
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	public void runFlywheel(int rpm){
		fwTalon.set(rpm);
		SmartDashboard.putNumber("Desired Flywheel P", gainsFW.p);
		SmartDashboard.putNumber("Desired Flywheel I", gainsFW.i);
		SmartDashboard.putNumber("Desired Flywheel d", gainsFW.d);
		SmartDashboard.putNumber("Flywheel P", fwTalon.getP());
		SmartDashboard.putNumber("Flywheel I", fwTalon.getI());
		SmartDashboard.putNumber("Flywheel D", fwTalon.getD());
		SmartDashboard.putNumber("Speed Flywheel RPM", fwTalon.getSpeed());
	}
	public void stopFlywheel(){
		fwTalon.set(0);
	}
}
