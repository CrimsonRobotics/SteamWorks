package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.commands.ClimberCommand;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	private WPI_TalonSRX climber;
	private final double INPUT_MULTIPLIER = 1;

	public Climber(int CANId){
		climber = new WPI_TalonSRX(CANId);
	}
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ClimberCommand());
	}
	public void climb(Joystick controller){
		if (controller.getY() <= 0 && Robot.ClimbLockout){
			climber.set(Math.abs(INPUT_MULTIPLIER*controller.getY()));
		}
		else {
			climber.set(0);
		}
	}
}
