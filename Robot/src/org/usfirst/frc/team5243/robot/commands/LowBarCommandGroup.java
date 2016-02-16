package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowBarCommandGroup extends CommandGroup {
    
    public  LowBarCommandGroup() {
        addSequential(new DriveStraight(8)); // drives maximum speed for 8 seconds
    }
}
