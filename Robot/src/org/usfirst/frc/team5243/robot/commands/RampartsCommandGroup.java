package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RampartsCommandGroup extends CommandGroup {

    public  RampartsCommandGroup() {
        DriveStraight CUSTOM = new DriveStraight(8,1); // not 100% certain, but basically; this drives straight, however it tries
        CUSTOM.changeConstant(.5); // much harder to correct itself.
        addSequential(CUSTOM);
        
    }
    
}
