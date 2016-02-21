package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RoughTerrainAutonomous extends CommandGroup {
    
    public  RoughTerrainAutonomous() {
        addSequential(new DriveStraight(5,1)); // speed,seconds
        addSequential(new RoughTerrainCommand());
        addSequential(new CenterTower());
        addParallel(new SpinUpCommand());
        addSequential(new Shoot());
    }
}
