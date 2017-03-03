package org.usfirst.frc.team2526.robot.subsystems;
	
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
	
public class Hopper extends Subsystem {
	private CANTalon top;
	private CANTalon bottom;
	
	public Hopper(int topID, int bottomID){
		top = new CANTalon(topID);
		bottom = new CANTalon(bottomID);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	/*
	 * This is used when filling the hopper from the ball intake.
	 */
	public void loadHopper(){
		top.set(.5);
		bottom.set(.5);
	}
	/*
	 * This is used when emptying the hopper with the ele
	 * 
	 * vator to shoot
	 * the balls.
	 */
	public void emptyHopper(){
		top.set(-.5);
		bottom.set(.5);
	}
	/*
	 * This is used to disable the hopper when it isn't supposed to do anything.
	 */
	public void disableHopper(){
		top.set(0);
		bottom.set(0);
	}
}