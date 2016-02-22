package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RockWallAutonomous extends CommandGroup {
    

    public  RockWallAutonomous() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	addSequential(new DriveStraight(5/*placeholder*/,1));
    	addSequential(new RockWallCommand());
    	addSequential(new CenterTower());
    	addParallel(new SpinUpCommand());
        addSequential(new Shoot());
    }
}
