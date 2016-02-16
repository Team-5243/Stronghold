package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RockwallCommandGroup extends CommandGroup {
    
    public  RockwallCommandGroup() {
        addSequential(new DriveStraight((double)5)); // 5 = seconds
    }
}
