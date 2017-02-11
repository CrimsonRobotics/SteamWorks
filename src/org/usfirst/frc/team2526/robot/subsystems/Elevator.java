package org.usfirst.frc.team2526.robot.subsystems;

import com.crimsonrobotics.lib.PID;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
	private CANTalon elevatorBottom;
	private CANTalon elevatorTop;
	private PID gainsElevator;
	
	public Elevator(int ebID,int emID, PID gains){
		elevatorBottom = new CANTalon(ebID);
		elevatorTop = new CANTalon(emID);
		gainsElevator = gains;	
		elevatorBottom.configEncoderCodesPerRev(360);
		elevatorTop.configEncoderCodesPerRev(360);
		elevatorBottom.setPosition(0);
		elevatorTop.setPosition(0);
		elevatorBottom.setSafetyEnabled(false);
		elevatorTop.setSafetyEnabled(false);
		elevatorBottom.reverseSensor(false);
		elevatorTop.reverseSensor(false);
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
		elevatorTop.setPID(gainsElevator.p,
				              gainsElevator.i, 
				              gainsElevator.d,
				              gainsElevator.f,
				              gainsElevator.iZone,
				              gainsElevator.rampRate,
				              gainsElevator.profile);
		elevatorBottom.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		elevatorTop.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		elevatorBottom.changeControlMode(CANTalon.TalonControlMode.Speed);
		elevatorTop.changeControlMode(CANTalon.TalonControlMode.Speed);
		elevatorBottom.enable();
		elevatorTop.enable();
	}
	@Override
	protected void initDefaultCommand() { 
		// TODO Auto-generated method stub
	}
	public void runElevator(int rpm){
		elevatorBottom.set(rpm);
		elevatorTop.set(rpm);
	}
	public void stopElevator(){
		elevatorBottom.set(0);
		elevatorTop.set(0);
	}
}