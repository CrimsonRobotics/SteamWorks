package org.usfirst.frc.team2526.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Hopper extends Subsystem {
	CANTalon top;
	CANTalon middle;
	CANTalon bottom;
	
	public Hopper(int topID, int middleID, int bottomID){
		top = new CANTalon(topID);
		middle = new CANTalon(middleID);
		bottom = new CANTalon(bottomID);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}
