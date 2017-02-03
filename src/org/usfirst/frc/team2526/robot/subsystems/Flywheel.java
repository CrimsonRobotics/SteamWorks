package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.commands.RunFlywheel;

import com.crimsonrobotics.lib.PID;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Flywheel extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	private int rpm = 3000;
	
	private CANTalon fwTalon;
		
	private PID gainsFW;
	
	Joystick controller = new Joystick(1);
	Button button = new JoystickButton(controller, 1);// button 1 is trigger
	
	public Flywheel(int fwID) {
		fwTalon = new CANTalon(fwID);
		
		fwTalon.reset();
		
		
		
		fwTalon.configEncoderCodesPerRev(360);
		
		fwTalon.setPosition(0);
		fwTalon.setSafetyEnabled(false);
		fwTalon.reverseSensor(false);
		
		pidInit();
	}
	
	private void pidInit(){
		fwTalon.setPID(gainsFW.p, gainsFW.i, gainsFW.d, gainsFW.f, gainsFW.iZone, gainsFW.rampRate, gainsFW.profile);
		fwTalon.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		fwTalon.changeControlMode(CANTalon.TalonControlMode.Speed);
		
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	
	//button.whileHeld(new RunFlywheel(Flywheel FW));
	
	public void runFlywheel(int rpm){
		
		fwTalon.enable();
		fwTalon.set(rpm);
		
	}
	
	public void stopFlywheel(){
		fwTalon.enable();
		fwTalon.set(0);
	}
	
	
	
}
