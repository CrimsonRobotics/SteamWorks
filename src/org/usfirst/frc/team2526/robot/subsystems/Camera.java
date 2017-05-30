package org.usfirst.frc.team2526.robot.subsystems;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.usfirst.frc.team2526.robot.Robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;

/**
 *
 */
public class Camera extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	static ITable table;
	static Double angle;
	

	 public Camera() {
			
			
		}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
   public void initTable() {
	   table = NetworkTable.getTable("datatable");
   }
    public double getCameraAngle() {
    	
    	
    	try{
            Thread.sleep(250);
        } catch (InterruptedException ex)
            {
    Logger.getLogger(Camera.class.getName()).log(Level.SEVERE, null, ex);
            }
    	angle = table.getNumber("Angle", 10000.0);
    	table.delete("Angle");
    	return angle;
    	}
    /*public static Double getAngle() {
    	return angle;
    }*/
    public static boolean checkAngle() {
    	if(Robot.camera.getCameraAngle() <1 && Robot.camera.getCameraAngle()>-1) {
    		return true;
    	}else 
    		return false;
    }
    
}

