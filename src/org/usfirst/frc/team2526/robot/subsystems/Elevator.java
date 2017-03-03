package org.usfirst.frc.team2526.robot.subsystems;

import com.crimsonrobotics.lib.PID;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Elevator extends Subsystem {
	private CANTalon elevatorBottom;
	private CANTalon elevatorTop;
	private PID gainsElevatorTop;
	private PID gainsElevatorBottom;
	
	public Elevator(int ebID,int emID, PID gainsTop, PID gainsBottom){
		elevatorBottom = new CANTalon(ebID);
		elevatorTop = new CANTalon(emID);
		gainsElevatorTop = gainsTop;
		gainsElevatorBottom = gainsBottom;
		pidInit();
	}
	private void pidInit(){
		elevatorBottom.setPID(gainsElevatorBottom.p, 
							  gainsElevatorBottom.i, 
							  gainsElevatorBottom.d,
							  gainsElevatorBottom.f, 
							  gainsElevatorBottom.iZone,
							  gainsElevatorBottom.rampRate,
							  gainsElevatorBottom.profile);
		elevatorTop.setPID(gainsElevatorTop.p,
							gainsElevatorTop.i, 
				            gainsElevatorTop.d,
				            gainsElevatorTop.f,
				            gainsElevatorTop.iZone,
				            gainsElevatorTop.rampRate,
				            gainsElevatorTop.profile);
		elevatorBottom.setFeedbackDevice(CANTalon.FeedbackDevice.PulseWidth);
		elevatorTop.setFeedbackDevice(CANTalon.FeedbackDevice.PulseWidth);
	}
	@Override
	protected void initDefaultCommand() { 
		// TODO Auto-generated method stub
	}
	public void runElevator(int rpm){
//		elevatorBottom.changeControlMode(CANTalon.TalonControlMode.Speed);
//		elevatorTop.changeControlMode(CANTalon.TalonControlMode.Speed);
		elevatorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		elevatorTop.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		elevatorBottom.enable();
		elevatorBottom.set(rpm);
		elevatorTop.enable();
		elevatorTop.set(rpm);
	}
	public void stopElevator(){
		elevatorBottom.set(0);
		elevatorTop.set(0);
	}
	public void logSpeed(){
		SmartDashboard.putNumber("Speed Elevator Top", elevatorTop.getSpeed());
		SmartDashboard.putNumber("Speed Elevator Bottom", elevatorBottom.getSpeed());
	}
}