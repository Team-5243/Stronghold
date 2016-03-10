package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RoughTerrainAutonomous extends CommandGroup {
        

    public  RoughTerrainAutonomous() {
    	addSequential(new DriveStraightAccel(.5, true));//gets over the lowBAR
    	addSequential(new Wait(1));
    	//addSequential(new Wait(2));
    	addSequential(new DriveStraight(72, .3));// SHOULD BE DRIVESTRAIGHTUNTILDISTANCE, 42 BEING THE DISTANCE
    	addSequential(new Turn(-45));
    	addSequential(new DriveStraightAccel(.2, false));//Want to base this on accelerometer?
    	addSequential(new Turn(45));
    	addSequential(new AlignLowGoalUltraCommand());
    	addSequential(new LowShoot());
    }
}
