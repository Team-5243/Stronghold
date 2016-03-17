package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnOffCommand extends Command {

    public TurnOffCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.oi.getRetrievalSS().stop();
    	Robot.oi.getClimb().first= false;
    	Robot.oi.getLiftSS().stopLift();
    	Robot.oi.getLiftSS().extendArm(0);
    	Robot.oi.getShootingSS().spinDown();
    	Robot.oi.getShootingSS().resetServo();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.oi.getRetrievalSS().stop();
    	Robot.oi.getClimb().first= false;
    	Robot.oi.getLiftSS().stopLift();
    	Robot.oi.getLiftSS().extendArm(0);
    	Robot.oi.getShootingSS().spinDown();
    	Robot.oi.getShootingSS().resetServo();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
