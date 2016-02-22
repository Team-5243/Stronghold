package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RampartsAutonomous extends CommandGroup {
    
    public  RampartsAutonomous() {
    	addSequential(new DriveStraight(5/*placeholder*/, 1));
    	addSequential(new RampartsCommand());
    	addSequential(new CenterTower());
    	addParallel(new SpinUpCommand());
    	addSequential(new Shoot());
    }
}
