package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbCommand extends Command {
	private boolean done = false;

	
    public ClimbCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!Robot.oi.getSensorSS().isTiltingZ()){
    		Robot.oi.getLiftSS().getLeft().set(.5);
    		Robot.oi.getLiftSS().getRight().set(.5);
    	
    		if(Robot.oi.getSensorSS().isTiltingZneg()){//if robot is tilting to the left make right motor pause so left can catch up
    			Robot.oi.getLiftSS().getLeft().set(.5);
    			Robot.oi.getLiftSS().getLeft().set(0);
    		}
    		if(Robot.oi.getSensorSS().isTiltingZ()){//if robot is tilting to the right make let motor pause so right can catch up
    			Robot.oi.getLiftSS().getLeft().set(.5);	
    			Robot.oi.getLiftSS().getLeft().set(0);
    		} 		
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;//Make a stop motor command
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
