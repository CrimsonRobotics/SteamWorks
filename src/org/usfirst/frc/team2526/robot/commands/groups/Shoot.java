package org.usfirst.frc.team2526.robot.commands.groups;

import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.commands.EmptyHopper;
import org.usfirst.frc.team2526.robot.commands.RunElevator;
import org.usfirst.frc.team2526.robot.commands.RunFlywheel;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Shoot extends CommandGroup {
	public Shoot(){
		addParallel(new EmptyHopper());
		addParallel(new RunElevator(RobotMap.ELEVATOR_SPEED));
		addParallel(new RunFlywheel(RobotMap.FLYWHEEL_BASE_SPEED));
	}
}
