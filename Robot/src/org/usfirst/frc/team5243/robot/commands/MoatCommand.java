package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoatCommand extends CommandGroup {
    
    public  MoatCommand() {
    	addSequential(new DriveStraight((double)5));
    }
}
