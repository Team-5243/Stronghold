package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CameraSpin extends Command {
	int degrees;
	boolean finished = false;
	
    public CameraSpin(int degree) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	degrees = degree;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		//double degreeTemp = Robot.oi.getCamera().getCameraAngle();
    	Robot.oi.getCamera().spinCamera(degrees);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (degrees == Robot.oi.getCamera().getCameraAngle());
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
