package org.usfirst.frc.team2526.robot.commands;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class elevator extends Subsystem {
	CANTalon elevatorBottom;
	CANTalon elevatorMiddle;
	CANTalon intakeRight;
	public elevator(){
		elevatorBottom = new CANTalon(RobotMap.elevatorBottom);
		elevatorMiddle = new CANTalon(RobotMap.elevatorMiddle);
		intakeRight = new CANTalon(RobotMap.intakeRight);
		
		
	}
	
	@Override
	protected void initDefaultCommand() {
		
		
		// TODO Auto-generated method stub
		
	}
	public void runMotors(double power){
		elevatorBottom.set(power);
		elevatorMiddle.set(power);
		intakeRight.set(power);
		
		
	}

}
