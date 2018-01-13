package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.commands.TeleopDrive;
import com.crimsonrobotics.lib.PID;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {
	private WPI_TalonSRX fL; //Front Left Motor
	private WPI_TalonSRX bL; //Back Left Motor
	private WPI_TalonSRX fR; //Front Right Motor
	private WPI_TalonSRX bR; //Back Right Motor
	private RobotDrive drive; //RobotDrive instance to control motors during teleop
	private PID gainsLeft; //PID Gains for left side.
	private PID gainsRight; //PID Gains for right side.
	public CANTalon.TalonControlMode currentMode;
	
	//If this drivetrain is not using PID invoke this constructor
	public DriveTrain(int fLID, int bLID, int fRID, int bRID){
		fL = new WPI_TalonSRX(fLID);
		bL = new WPI_TalonSRX(bLID);
		fR = new WPI_TalonSRX(fRID);
		bR = new WPI_TalonSRX(bRID);
		setFollowerOf(fL, bL);//fL leads bL follows
		setFollowerOf(fR, bR);//fR leads bR follows
		drive = new DifferentialDrive(this.fL, this.fR);
	}
	protected void initDefaultCommand() {
		setDefaultCommand(new TeleopDrive());
	}
	//If this drivetrain is using PID use this constructor
	public DriveTrain(int fLID, int bLID, int fRID, int bRID, PID gainsLeft, PID gainsRight){
		this(fLID, bLID, fRID, bRID);
		this.gainsLeft = gainsLeft;
		this.gainsRight = gainsRight;
		pidInit();
		teleopDriveInit();
	}
	//called if drivetrain is setup for PID
	private void pidInit(){
		fL.setPID(gainsLeft.p, gainsLeft.i, gainsLeft.d, gainsLeft.f, gainsLeft.iZone, gainsLeft.rampRate, gainsLeft.profile);
		fR.setPID(gainsRight.p, gainsRight.i, gainsRight.d, gainsRight.f, gainsRight.iZone, gainsRight.rampRate, gainsRight.profile);
		fL.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		fL.configEncoderCodesPerRev(256);
		fR.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		fR.configEncoderCodesPerRev(256);
		fL.reverseSensor(false);
		fR.reverseSensor(true);
		//disable safety
		fL.setSafetyEnabled(false);
		fR.setSafetyEnabled(false);
		bL.setSafetyEnabled(false);
		bR.setSafetyEnabled(false);
	}
	//call this in the init stage of your autnomous command for speed
	public void pidSpeedInit(){
		changeLeaderControlMode(CANTalon.TalonControlMode.Speed);
		adjustRampRate(0);
		bL.setInverted(false);
		fR.setInverted(false);
		bR.setInverted(false);
		fL.setInverted(false);
		fR.reverseOutput(false);
		fL.reverseOutput(true);
	}
	//call this in the init stage of teleop drive command
	public void teleopDriveInit() {
		bL.setInverted(true);
		fR.setInverted(true);
		bR.setInverted(true);
		fL.setInverted(true);
		changeLeaderControlMode(CANTalon.TalonControlMode.PercentVbus);
		adjustRampRate(1); //If robot is in second gear ramprate is 1 V/s else 12 V/s.
	}
	/*
	 * @param Left joystick of the driver which control the turning.
	 * @param Right joystick of the driver which controls forward and backwards motion.
	 */
	public void teleopCraneDrive(Joystick left, Joystick right){
		if (right.getX() > 0) 
		drive.arcadeDrive(-left.getY(), Math.pow(right.getX(),2));
		else  {
			drive.arcadeDrive(-left.getY(), -Math.pow(right.getX(),2));
		}	
	}
	/*
	 * @param Speed in rotations per minute (rpm) for the left side.
	 * @param Speed in rotations per minute (rpm) for the right side.
	 */
	public void speedDrive(double speedLeft, double speedRight){
		fR.enable();
		fR.set(speedRight);
		fL.enable();
		fL.set(speedLeft);
	}
	public void percentVBusDrive(double percentVoltageLeft, double percentVoltageRight){
		fR.set(percentVoltageRight);
		fL.set(percentVoltageLeft);
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
		this.currentMode = mode;
		fL.changeControlMode(mode);
		fR.changeControlMode(mode);
	}
	private void adjustRampRate(double rate){
		fL.setVoltageRampRate(rate);
		fR.setVoltageRampRate(rate);
		bL.setVoltageRampRate(rate);
		bR.setVoltageRampRate(rate);
	}
	public void printSpeedToDebug(){
		SmartDashboard.putNumber("Left Speed", fL.getSpeed());
		SmartDashboard.putNumber("Speed Right", fR.getSpeed());
	}
	public void printAngleToDebug(){
		SmartDashboard.putNumber("Angle", Robot.gyro.getAngle());
	}

public void outputMotorEncoderData(CANTalon motor, String motorName) {
		
		String motorString = motorName + " (" + motor.getDeviceID() + ") ";
		//SmartDashboard.putString("Motor: ", motorName);
		SmartDashboard.putNumber(motorString + " getEncVelocity: " , motor.getEncVelocity());
		SmartDashboard.putNumber(motorString + " getEncPosition: ", motor.getEncPosition());
		SmartDashboard.putNumber(motorString + " getPosition: ", motor.getPosition());
		SmartDashboard.putNumber(motorString + " getClosedLoopError: ", motor.getClosedLoopError());
		SmartDashboard.putNumber(motorString + " getError: ", motor.getError());
		SmartDashboard.putNumber(motorString + " getSetpoint: ", motor.getSetpoint());
		SmartDashboard.putNumber(motorString + " getSpeed: ", motor.getSpeed());
		SmartDashboard.putBoolean(motorString + " isSafetyEnabled: " , motor.isSafetyEnabled());
		SmartDashboard.putString(motorString + " P:I:D: ", motor.getP() + ":" + motor.getI() +  ":" + motor.getD());
		SmartDashboard.putNumber(motorString + " getF: ", motor.getF());
		SmartDashboard.putNumber(motorString + " getIZone: ", motor.getIZone());
		SmartDashboard.putNumber(motorString + " getCloseLoopRampRate: ", motor.getCloseLoopRampRate());
		SmartDashboard.putNumber(motorString + " GetIaccum: ", motor.GetIaccum());
		SmartDashboard.putString(motorString + " getInverted: ", "" + motor.getInverted());
		//faults = checkCANTalonFaults(motor);
		//SmartDashboard.putString(motorString + " talonFaults: ", faults);
		
	}
	
}
