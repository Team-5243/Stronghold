package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RoughTerrainCommandGroup extends CommandGroup {
    
    public  RoughTerrainCommandGroup() {
        addSequential(new DriveStraight(6,1)); // speed,seconds
        
    }
}
