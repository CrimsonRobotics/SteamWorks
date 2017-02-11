package org.usfirst.frc.team2526.robot.subsystems;

import com.crimsonrobotics.lib.PID;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;



public class Turret extends Subsystem {
	private CANTalon turretTalon;	
	private PID gainsTurret;
	
	public Turret(int fwID, PID gains) {
		turretTalon = new CANTalon(fwID);
		gainsTurret = gains;
		turretTalon.setSafetyEnabled(false);
		turretTalon.reverseSensor(false);
		pidInit();
	}
	private void pidInit(){
		turretTalon.setPID(gainsTurret.p, gainsTurret.i, gainsTurret.d, gainsTurret.f, gainsTurret.iZone, gainsTurret.rampRate, gainsTurret.profile);
		turretTalon.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Absolute);
		turretTalon.changeControlMode(CANTalon.TalonControlMode.Position);
		turretTalon.enable();
	}
	public void initDefaultCommand() {
	}
	//According to Alex H. the turret will have ~350 Degrees of movement
	public void runTurret(int position){
		turretTalon.set(position);
	}
}