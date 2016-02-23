package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowBarCommandGroup extends CommandGroup {
    
    public  LowBarCommandGroup() {
        
    	addSequential(new DriveStraight(5,1));
    	addSequential(new LowBarCommand());
    	
    	//addSequential(new CenterTower());
//    	addParallel(new SpinUpCommand());
//    	addSequential(new Shoot());
    }
    
}
