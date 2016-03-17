package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class NewAuto extends CommandGroup {
    //Austin, please check this, it's what I was talking about at competition
	//I've taken warnings out of most of the other files on this computer
	//Should we remove some files that we maybe aren't using for neatness sake?
	//(unused autonomous modes/center tower, etc.)
	//-Evan
    public  NewAuto() {
    	addSequential(new DriveStraightAccel(.7, true));//gets over the low bar
    	addSequential(new DriveStraight(12, .5));  //drives right up to plexiglas wall
    	addSequential(new Turn(90)); //turn to face left side of tower, Right turn positive, Left negative
    	addSequential(new DriveStraight(2.0, 0.5)); //drive straight up to tower
    	addSequential(new LowShoot()); //doggy door into goal at point blank range
    }
}
