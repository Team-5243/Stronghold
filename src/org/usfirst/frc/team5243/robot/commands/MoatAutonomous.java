package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoatAutonomous extends CommandGroup {
    
    public  MoatAutonomous() {
        /*addSequential(new DriveStraight(3/*placeholder, 1));
>>>>>>> Align low goal and drivestraight and drivestraightwhileheld and turnwhileheld and turn
    	addSequential(new MoatCommand());
    	addSequential(new CenterTower());
    	addParallel(new SpinUpCommand());

    	addSequential(new Shoot());
<<<<<<< 52eff39453bf031405c119f52558b8db3b3c2536
    }

    	
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
=======
        */

    	//addSequential(new Wait(2));
    	addSequential(new DriveStraightWhileAutonomous(2, .8));//gets over the moat
    	addSequential(new Wait(2));
    	//addSequential(new Wait(2));
    	addSequential(new DriveStraightWhileAutonomous(1.5, .3));// SHOULD BE DRIVESTRAIGHTUNTILDISTANCE, 42 BEING THE DISTANCE
    	addSequential(new Turn(45));
    	addSequential(new DriveStraightWhileAutonomous(2, .2));//Want to base this on accelerometer
    	addSequential(new Turn(-45));
    	addSequential(new AlignLowGoalUltraCommand());
    	addSequential(new Turn(Robot.oi.getSensorSS().getDegreeTurn()));
    }
}


