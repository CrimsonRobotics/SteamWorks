package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.commands.RunTurretJoystick;
import org.usfirst.frc.team2526.robot.commands.TeleopDrive;

import com.crimsonrobotics.lib.PID;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class Turret extends Subsystem {
	private CANTalon turretTalon;	
	private PID gainsTurret;
	private DigitalInput leftSwitch;
	private DigitalInput rightSwitch;
	
	public Turret(int fwID, PID gains, int leftSwitchID, int rightSwitchID) {
		turretTalon = new CANTalon(fwID);
		gainsTurret = gains;
		turretTalon.setSafetyEnabled(false);
		turretTalon.reverseSensor(false);
		leftSwitch = new DigitalInput(leftSwitchID);
		rightSwitch = new DigitalInput(rightSwitchID);
		pidInit();
	}
	private void pidInit(){
		turretTalon.setPID(gainsTurret.p, gainsTurret.i, gainsTurret.d, gainsTurret.f, gainsTurret.iZone, gainsTurret.rampRate, gainsTurret.profile);
		turretTalon.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Absolute);
	}
	public void initDefaultCommand() {
		setDefaultCommand(new RunTurretJoystick());
	}
	//According to Alex H. the turret will have ~350 degrees of movement
	public void runTurret(int position){
		turretTalon.changeControlMode(CANTalon.TalonControlMode.Position);
		turretTalon.enable();
		turretTalon.set(position);
	}
	public void turnTurretJoystick(Joystick stick) {
		turretTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		if(!Robot.ClimbLockout && !leftSwitch.get() && stick.getZ() > 0) {
			turretTalon.set(stick.getZ()*RobotMap.INPUT_MULTIPLIER);
		} else if(!Robot.ClimbLockout && !rightSwitch.get() && stick.getZ() < 0) {
			turretTalon.set(stick.getZ()*RobotMap.INPUT_MULTIPLIER);
		} else { 
			turretTalon.set(0);
		}
	}
	public void turnWithCamera() {
		turretTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	 	double angleset = Robot.camera.getCameraAngle();
	 	System.out.println("One" + angleset);
	 	SmartDashboard.putNumber("Angle First", angleset);
	    while(angleset>1 || angleset<-1) {
	    	angleset = Robot.camera.getCameraAngle();
	 		if(angleset != 10000.0) {
	 		System.out.println("Two" + angleset);
	 	if(angleset>1)
	 		turretTalon.set(.07);
	 	//	myDrive.drive(.5, .5);
	 	else if(angleset<-1)
	 		turretTalon.set(-.07);
	 		//myDrive.drive(.5, -.5);
	 	else if(angleset >= -1 && angleset <= 1)
	 		turretTalon.set(0);
	 		// myDrive.drive(0, 0);
	 	   }
	 	   }
	    }
	public void stopTalon() {
		turretTalon.set(0);
	}
}