package org.usfirst.frc.team2526.robot.subsystems;


import com.crimsonrobotics.lib.PID;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
	private CANTalon elevatorBottom;
	private CANTalon elevatorMiddle;
	private PID gainsElevator;
	
	public Elevator(int ebID,int emID, PID gains){
		elevatorBottom = new CANTalon(ebID);
		elevatorMiddle = new CANTalon(emID);
		
		gainsElevator = gains;
		
		elevatorBottom.configEncoderCodesPerRev(360);
		elevatorMiddle.configEncoderCodesPerRev(360);
		
		elevatorBottom.setPosition(0);
		elevatorMiddle.setPosition(0);
		
		elevatorBottom.setSafetyEnabled(false);
		elevatorMiddle.setSafetyEnabled(false);
		
		elevatorBottom.reverseSensor(false);
		elevatorMiddle.reverseSensor(false);
		
		pidInit();
	}
	
	private void pidInit(){
		
		elevatorBottom.setPID(gainsElevator.p, 
							  gainsElevator.i, 
							  gainsElevator.d,
							  gainsElevator.f, 
							  gainsElevator.iZone,
							  gainsElevator.rampRate,
							  gainsElevator.profile);
		
		elevatorMiddle.setPID(gainsElevator.p,
				              gainsElevator.i, 
				              gainsElevator.d,
				              gainsElevator.f,
				              gainsElevator.iZone,
				              gainsElevator.rampRate,
				              gainsElevator.profile);
		elevatorBottom.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		elevatorMiddle.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		elevatorBottom.changeControlMode(CANTalon.TalonControlMode.Speed);
		elevatorMiddle.changeControlMode(CANTalon.TalonControlMode.Speed);
		elevatorBottom.enable();
		elevatorMiddle.enable();
	}
	
	@Override
	protected void initDefaultCommand() { 
		
		
		// TODO Auto-generated method stub
		
	}
	public void runElevator(int rpm){
		elevatorBottom.set(rpm);
		elevatorMiddle.set(rpm);
	}
	public void stopElevator(){
		elevatorBottom.set(0);
		elevatorMiddle.set(0);
	}
}


