package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RampartsCommandGroup extends CommandGroup {
    public boolean trew = true;
    public  RampartsCommandGroup() {
        DriveStraight muckraker = new DriveStraight((double)2);
        //muckraker.driveTilting(trew);
        
        
    }
    
}
