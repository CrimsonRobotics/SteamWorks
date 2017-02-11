package org.usfirst.frc.team2526.robot;

import org.usfirst.frc.team2526.robot.subsystems.GearIntake;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2526.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2526.robot.commands.test.SpeedDriveCommand;
import org.usfirst.frc.team2526.robot.subsystems.Climber;
import org.usfirst.frc.team2526.robot.subsystems.Flywheel;
import org.usfirst.frc.team2526.robot.subsystems.Turret;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	//Controls
	public static OI oi = new OI();
	//DriveTrain Subsystem
	public static final DriveTrain driveTrain = new DriveTrain(RobotMap.DRIVETRAIN_FRONTLEFT, 
			RobotMap.DRIVETRAIN_BACKLEFT, RobotMap.DRIVETRAIN_FRONTRIGHT, RobotMap.DRIVETRAIN_BACKRIGHT, 
			RobotMap.DRIVETRAIN_GAINS_LEFT, RobotMap.DRIVETRAIN_GAINS_RIGHT);
	//Climber Subsystem
	public static final Climber climber = new Climber(RobotMap.CLIMBER_MOTOR);
	//Flywheel Subsystem
	public static final Flywheel flywheel = new Flywheel(RobotMap.FLYWHEEL_TALON, RobotMap.GAINS_FLYWHEEL);
	//Turret Subsystem
	public static final Turret turret = new Turret(RobotMap.TURRET_TALON, RobotMap.GAINS_TURRET);
	//Gearplacer Subsystem
	public static GearIntake gearintake = new GearIntake(RobotMap.DS_L_ONE, RobotMap.DS_L_TWO, RobotMap.DS_R_ONE, RobotMap.DS_R_TWO, RobotMap.SS_P, RobotMap.D_G_S);
	//AutonomousCommand
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	
	@Override
	public void robotInit() {
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
