package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.commands.TeleopDrive;
import com.crimsonrobotics.lib.PID;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {
	private CANTalon fL; //Front Left Motor
	private CANTalon bL; //Back Left Motor
	private CANTalon fR; //Front Right Motor
	private CANTalon bR; //Back Right Motor
	private RobotDrive drive; //RobotDrive instance to control motors during teleop
	private PID gainsLeft; //PID Gains for left side.
	private PID gainsRight; //PID Gains for right side.
	
	public DriveTrain(int fLID, int bLID, int fRID, int bRID){
		fL = new CANTalon(fLID);
		bL = new CANTalon(bLID);
		fR = new CANTalon(fRID);
		bR = new CANTalon(bRID);
		setFollowerOf(fL, bL);//fL leads bL follows
		setFollowerOf(fR, bR);//fR leads bR follows
		drive = new RobotDrive(this.fL, this.fR);
	}
	public DriveTrain(int fLID, int bLID, int fRID, int bRID, PID gainsLeft, PID gainsRight){
		this(fLID, bLID, fRID, bRID);
		this.gainsLeft = gainsLeft;
		this.gainsRight = gainsRight;
		pidInit();
	}
	private void pidInit(){
		fL.setPID(gainsLeft.p, gainsLeft.i, gainsLeft.d, gainsLeft.f, gainsLeft.iZone, gainsLeft.rampRate, gainsLeft.profile);
		fR.setPID(gainsRight.p, gainsRight.i, gainsRight.d, gainsRight.f, gainsRight.iZone, gainsRight.rampRate, gainsRight.profile);
		fL.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		fL.configEncoderCodesPerRev(360);
		fR.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		fR.configEncoderCodesPerRev(360);
		fR.reverseSensor(true);
		fL.reverseOutput(true);
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
	 * @param Speed in rotations per minute (rpm) for the left side.
	 * @param Speed in rotations per minute (rpm) for the right side.
	 */
	public void speedDrive(double speedLeft, double speedRight){
		changeLeaderControlMode(CANTalon.TalonControlMode.Speed);
		fL.enable();
		fR.enable();
		fR.set(speedRight);
		fL.set(speedLeft);
	}
	/*
	 * @param Percent voltage for the left side of the drive train -1 to 1 scale.
	 * @param Percent voltage for the right side of the drive train -1 to 1 scale.
	 */
	public void percentVBusDrive(double voltageLeft, double voltageRight){
		changeLeaderControlMode(CANTalon.TalonControlMode.PercentVbus);
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
	/*
	 * @param Control mode of the leading talons.
	 */
	private void changeLeaderControlMode(CANTalon.TalonControlMode mode){
		fL.changeControlMode(mode);
		fR.changeControlMode(mode);
	}
	public void printSpeedToDebug(){
		DriverStation.getInstance().reportError("Speed Left:" + fL.getSpeed() + "Error Left:" + fL.getError(), false);
		DriverStation.getInstance().reportError("Speed Right:" + fR.getSpeed() + "Error Right:" + fR.getError(), false);
	}
}
