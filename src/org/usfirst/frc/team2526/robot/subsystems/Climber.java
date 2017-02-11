package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.commands.ClimberCommand;
import org.usfirst.frc.team2526.robot.commands.TeleopDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	private CANTalon climber;
	private final double INPUT_MULTIPLIER = 1;

	public Climber(int CANId){
		climber = new CANTalon(CANId);
	}
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ClimberCommand());
	}
	public void climb(Joystick controller){
		//Up on the joystick relative to the driver is negative.
		if (controller.getY() <= 0 ){
			climber.set(Math.abs(INPUT_MULTIPLIER*controller.getY()));
		}
	}
}
