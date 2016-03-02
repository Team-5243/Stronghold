package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowBarAutonomous extends CommandGroup {
    
    public  LowBarAutonomous() {
    	addSequential(new LowBarCommand());
    	addSequential(new DriveStraight(72, .3));// SHOULD BE DRIVESTRAIGHTUNTILDISTANCE, 42 BEING THE DISTANCE
    	addSequential(new Turn(-45));
    	addSequential(new DriveStraight(1.5, .2));//Want to base this on accelerometer
    	addSequential(new Turn(45));
    	addSequential(new AlignLowGoalUltraCommand());
    	addSequential(new Turn(Robot.oi.getSensorSS().getDegreeTurn()));
    }
}
