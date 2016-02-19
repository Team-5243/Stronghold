package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoatAutonomous extends CommandGroup {
    
    public  MoatAutonomous() {
        addSequential(new DriveStraight(5/*placeholder*/, 1));
    	addSequential(new MoatCommand());
    	addSequential(new CenterTower());
    	addParallel(new SpinUpCommand());
    	addSequential(new Shoot());
   }
}
