package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RoughTerrainCommandGroup extends CommandGroup {
    
    public  RoughTerrainCommandGroup() {
        addSequential(new DriveStraight(5,1)); // speed,seconds
        addSequential(new RoughTerrainCommand());
        addSequential(new Shoot());
    }
}
