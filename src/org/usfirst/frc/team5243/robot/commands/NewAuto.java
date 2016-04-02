package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class NewAuto extends CommandGroup {
	
	
	
    public  NewAuto() {
    	double defpos = RobotMap.defensePosition();
    	addSequential(new DriveStraight(5.5,.7)); //over the low bar
    	addSequential(new DriveStraight(12, .7));  //drives right up to plexiglas wall
    	if(defpos == 1 || defpos == 2){
    		addSequential(new Turn(90)); //turn to face left side of tower, Right turn positive, Left negative
    	}
    	else if(defpos == 5 || defpos == 4){
    		addSequential(new Turn(-90));
    	}
    	addSequential(new DriveStraight(6, 0.5)); //drive straight up to tower
    	//addSequential(new LowShoot()); //doggy door into goal at point blank range
    	
    	
    	
    	
    }
}
