package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RoughTerrainAutonomous extends CommandGroup {
    
    public  RoughTerrainAutonomous() {
    	addSequential(new DriveStraight(2,1)); // speed,seconds
    	while(Robot.oi.getSensorSS().isTiltingY() || Robot.oi.getSensorSS().isTiltingYneg() || Robot.oi.getSensorSS().isTiltingX()){
    		addSequential(new DriveStraight(.5,1));
    	}
        addSequential(new CenterTower());
    	addParallel(new SpinUpCommand());
        addSequential(new Shoot());
    }
}
