package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AlignHighGoal extends Command {
	private boolean first = true;
    public AlignHighGoal() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(first){
    		Robot.oi.getMotorSS().setRunning(true);
    		first = false;
    	}
    	if(Robot.oi.getCamera().getOurOrdersBasedOnXValue() < 0){
    		Robot.oi.getMotorSS().turnLeft(.5);
    	}else{
    		Robot.oi.getMotorSS().turnRight(.5);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.oi.getCamera().getOurOrdersBasedOnXValue() < .05*Robot.oi.getCamera().getX() ||Robot.oi.getCamera().getOurOrdersBasedOnXValue() > -.05*Robot.oi.getCamera().getX();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.oi.getMotorSS().setRunning(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
