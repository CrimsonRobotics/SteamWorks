package org.usfirst.frc.team2526.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shifter extends Subsystem {
	private Solenoid shifterSolenoid;
	private boolean shifted;
	public Shifter(int channel){
		shifterSolenoid = new Solenoid(channel);
	}

//    public void initDefaultCommand() {
//    }
//    public void shift(){
//    	shifted = !shifted;
//    	shifterSolenoid.set(shifted);
//    }
    public boolean isShifted(){
    	return shifted;
    }
	
	public void shiftHigh() {
		shifterSolenoid.set(false);
		shifted = false;
	}
	public void shiftLow() {
		shifterSolenoid.set(true);
		shifted = true;
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}

