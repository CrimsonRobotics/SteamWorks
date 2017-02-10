package org.usfirst.frc.team2526.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
	CANTalon elevatorBottom;
	CANTalon elevatorMiddle;
	CANTalon intakeRight;
	
	public Elevator(int elevatorBottomID, int elevatorMiddleID, int intakeRightID){
		elevatorBottom = new CANTalon(elevatorBottomID);
		elevatorMiddle = new CANTalon(elevatorMiddleID);
		intakeRight = new CANTalon(intakeRightID);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}
