package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.commands.TeleopDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	private CANTalon fL; //Front Left Motor
	private CANTalon bL; //Back Left Motor
	private CANTalon fR; //Front Right Motor
	private CANTalon bR; //Back Right Motor
	private RobotDrive drive; //RobotDrive instance to control motors during teleop
	
	public DriveTrain(int fLID, int bLID, int fRID, int bRID){
		fL = new CANTalon(fLID);
		bL = new CANTalon(bLID);
		fR = new CANTalon(fRID);
		bR = new CANTalon(bRID);
		setFollowerOf(fL, bL);//fL leads bL follows
		setFollowerOf(fR, bR);//fR leads bR follows
		drive = new RobotDrive(this.fL, this.fR);
	}
	protected void initDefaultCommand() {
		setDefaultCommand(new TeleopDrive());
	}
	/*
	 * @param Left joystick of the driver which control the turning.
	 * @param Right joystick of the driver which controls forward and backwards motion.
	 */
	public void teleopCraneDrive(Joystick left, Joystick right){
		drive.arcadeDrive(right.getY(), left.getX());
	}
	/*
	 * @param Percent voltage for the left side of the drive train -1 to 1 scale.
	 * @param Percent voltage for the right side of the drive train -1 to 1 scale.
	 */
	public void percentVBusDrive(double voltageLeft, double voltageRight){
		fL.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		fR.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		fL.set(voltageLeft);
		fR.set(voltageRight);
	}
	/*
	 * @param Leading motor that should be mirrored.
	 * @param Following motor that is to copy leader.
	 */
	private void setFollowerOf(CANTalon leader, CANTalon follower){
		follower.changeControlMode(CANTalon.TalonControlMode.Follower);
		follower.set(leader.getDeviceID());
	}
}
