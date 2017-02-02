package org.usfirst.frc.team2526.robot.subsystems;

import java.util.logging.Level;
import java.util.logging.Logger;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Camera extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	static NetworkTable table;
	static Double angle;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void getCameraAngle() {
    	table = NetworkTable.getTable("datatable");
    	while(true) {
    	try{
            Thread.sleep(250);
        } catch (InterruptedException ex)
            {
    Logger.getLogger(Camera.class.getName()).log(Level.SEVERE, null, ex);
            }
    	angle = table.getNumber("Angle", -10000.0);
    	SmartDashboard.putNumber("Angle", angle);
    }
    	}
    public static Double getAngle() {
    	return angle;
    }
}

