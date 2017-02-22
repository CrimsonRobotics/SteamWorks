package org.usfirst.frc.team2526.robot.subsystems;

import com.crimsonrobotics.lib.PID;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallIntake extends Subsystem {
	private CANTalon motor;
	 
	public BallIntake(int motorID){
		motor = new CANTalon(motorID);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	public void enable(){
		motor.set(.5);
	}
	public void disable(){
		motor.set(0);
	}
}
