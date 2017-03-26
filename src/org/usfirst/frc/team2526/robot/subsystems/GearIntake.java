package org.usfirst.frc.team2526.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearIntake extends Subsystem {
	private DoubleSolenoid left, right;
	
	private Solenoid plate;
	private DigitalInput dropGearSensor;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public GearIntake(int DS_L_ONE, int DS_L_TWO, int SS_P, int D_G_S) {
		left = new DoubleSolenoid(DS_L_ONE, DS_L_TWO); //Gear release
		//right = new DoubleSolenoid(DS_R_ONE, DS_R_TWO); //Gear release
		plate = new Solenoid(SS_P); //Gear vs Ball intake
		dropGearSensor = new DigitalInput(D_G_S);//sensor that when triggered, will drop gear
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void dropGear() {
    	left.set(DoubleSolenoid.Value.kReverse); //WIP
    	//right.set(DoubleSolenoid.Value.kForward); //WIP
    }
    public void closeGearIntake() {
    	left.set(DoubleSolenoid.Value.kForward); //WIP
    	//right.set(DoubleSolenoid.Value.kReverse); //WIP
    }
    public void switchtoGear() {
    	plate.set(false);
    }
    public void switchtoBall() {
    	plate.set(true);
    }
    
}

