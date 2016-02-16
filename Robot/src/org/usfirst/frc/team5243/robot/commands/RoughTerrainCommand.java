package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.SensorSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RoughTerrainCommand extends Command {
	private boolean run = false;
	
    public RoughTerrainCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(Robot.oi.getSensorSS().isTilting()){
    		DriveStraight criminal = new DriveStraight(1,1);
    		criminal.execute();
    	}
    	run = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return run;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
   
}
