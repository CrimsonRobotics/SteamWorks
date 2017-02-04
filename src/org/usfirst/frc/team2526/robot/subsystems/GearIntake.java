package org.usfirst.frc.team2526.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearIntake extends Subsystem {
	private DoubleSolenoid left, right;
	private Solenoid plate;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public GearIntake(int DS_L_One, int DS_L_Two, int DS_R_One, int DS_R_Two, int SS_P) {
		left = new DoubleSolenoid(DS_L_One, DS_L_Two); //Gear release
		right = new DoubleSolenoid(DS_R_One, DS_R_Two); //Gear release
		plate= new Solenoid(SS_P); //Gear vs Ball ntake
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void dropGear() {
    	left.set(DoubleSolenoid.Value.kForward);
    	right.set(DoubleSolenoid.Value.kForward);
    	}
    public void switchtoGear() {
    	plate.set(true);
    }
    public void switchtoBall() {
    	plate.set(false);
    }
}

