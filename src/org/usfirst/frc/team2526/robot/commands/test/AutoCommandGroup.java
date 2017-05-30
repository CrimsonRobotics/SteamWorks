package org.usfirst.frc.team2526.robot.commands.test;

import org.usfirst.frc.team2526.robot.commands.groups.GearDropAndHoldAuto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommandGroup extends CommandGroup {


	public AutoCommandGroup() {
    	setInterruptible(true);
    	addSequential(new TimeDrive(3, .25,-0.25));
    	addSequential(new GearDropAndHoldAuto(1.2));
    	addSequential(new TimeDrive(3, -0.25, 0.25));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
