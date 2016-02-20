package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowBarCommandGroup extends CommandGroup {
    
    public  LowBarCommandGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

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
    	Robot.oi.getSensorSS().getGyro().reset();
    	while(!Robot.oi.getSensorSS().isTiltingX()){
    		Robot.oi.getMotorSS().getDrive().drive(.3, -Robot.oi.getSensorSS().getGyro().getAngle() * .05);
    	}
    	while(Robot.oi.getSensorSS().isTiltingX()){
    		Robot.oi.getMotorSS().getDrive().drive(.1, -Robot.oi.getSensorSS().getGyro().getAngle() * .05);
    	}
    	Robot.oi.getMotorSS().getDrive().drive(.5, -Robot.oi.getSensorSS().getGyro().getAngle() * .05);

    }
}
