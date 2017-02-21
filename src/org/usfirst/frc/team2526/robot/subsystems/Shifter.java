package org.usfirst.frc.team2526.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shifter extends Subsystem {
	private Solenoid shifterSolenoid;
	private boolean shifted = false;
	public Shifter(int moduleNumber, int channel){
		shifterSolenoid = new Solenoid(moduleNumber, channel);
	}

    public void initDefaultCommand() {
    }
    public void shift(){
    	shifted = !shifted;
    	shifterSolenoid.set(shifted);
    }
    public boolean isShifted(){
    	return shifted;
    }
}

