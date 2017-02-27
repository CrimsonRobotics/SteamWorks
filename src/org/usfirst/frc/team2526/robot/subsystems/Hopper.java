package org.usfirst.frc.team2526.robot.subsystems;
	
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Subsystem;
	
public class Hopper extends Subsystem {
	private CANTalon top;
	private CANTalon bottom;
	
	public Hopper(int topID, int bottomID){
		top = new CANTalon(topID);
		bottom = new CANTalon(bottomID);
		setupConfig();
	}
	private void setupConfig(){
		Preferences prefs = Preferences.getInstance();
		top.setInverted(prefs.getBoolean("HopperTopMotorInverted", false));
		bottom.setInverted(prefs.getBoolean("HopperBottomMotorInverted", false));
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	public void enableHopper(){
		top.set(-.5);
		bottom.set(.5);
	}
	public void disableHopper(){
		top.set(0);
		bottom.set(0);
	}
}