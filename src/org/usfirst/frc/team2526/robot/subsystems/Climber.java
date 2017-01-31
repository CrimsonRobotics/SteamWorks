package org.usfirst.frc.team2526.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {


	@Override
	protected void initDefaultCommand() {
		Joystick climb;
		CANTalon climber;
		
		climb = new Joystick(3);
		climber = new CANTalon(4);

		climber.set(climb.getY());
		
		if (climb.getY() < 0){
			
			climber.set(0);
			
		}
		
	}

}
