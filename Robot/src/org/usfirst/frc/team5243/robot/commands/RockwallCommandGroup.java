package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RockwallCommandGroup extends CommandGroup {
    
    public  RockwallCommandGroup() {
    	addSequential(new DriveStraight(2,1)); // seconds,speed
        while(Robot.oi.getSensorSS().isTiltingY() || Robot.oi.getSensorSS().isTiltingYneg()){
    		addSequential(new DriveStraight(.5,1));
    	}
        addSequential(new CenterTower());
    	addParallel(new SpinUpCommand());
        addSequential(new Shoot());
    }
}
