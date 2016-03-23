package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowBarAutonomous extends CommandGroup {
    
    public  LowBarAutonomous() {
    	addSequential(new DriveStraight(5.5, .7));//gets over the lowBAR,  (LOW BAR (4.5, .6)) (Rock Wall (5.5,.6))
    	addSequential(new DriveStraight(52, .4));// SHOULD BE DRIVESTRAIGHTUNTILDISTANCE, 42 BEING THE DISTANCE
    	addSequential(new Turn(45));
    	addSequential(new DriveStraight(3, .5));//Want to base this on accelerometer?
    	addSequential(new Turn(-45));
    	addSequential(new AlignLowGoalUltraCommand());
    	//addSequential(new LowShoot());
    	//addSequential(new Turn(Robot.oi.getSensorSS().getDegreeTurn()));
    }
}
