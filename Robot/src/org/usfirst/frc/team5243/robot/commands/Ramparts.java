package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Ramparts extends Command {
	private boolean finished = false;
    public Ramparts() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.oi.getMotorSS());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(Robot.oi.getSensorSS().getY() < 1000000000 && Robot.oi.getSensorSS().getY() > 0){
    		//drive up to ramparts
    		Robot.oi.getMotorSS().getBackLeft().set(1);
    		Robot.oi.getMotorSS().getBackRight().set(1);
    		Robot.oi.getMotorSS().getFrontLeft().set(1);
    		Robot.oi.getMotorSS().getFrontRight().set(1);
    	}
    	//turn right onto ramparts
    	Robot.oi.getMotorSS().getFrontRight().set(0);
    	Robot.oi.getMotorSS().getBackRight().set(0);
    	//placeholder, need to test time needed to turn right
    	try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//wait for right side to catch up
    	Robot.oi.getMotorSS().getFrontRight().set(1);
    	Robot.oi.getMotorSS().getBackRight().set(1);
    	Robot.oi.getMotorSS().getFrontLeft().set(0);
    	Robot.oi.getMotorSS().getBackLeft().set(0);
    	///placeholder, need to test time needed to straighten out
    	try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//drive off ramparts
    	Robot.oi.getMotorSS().getFrontRight().set(1);
    	Robot.oi.getMotorSS().getBackRight().set(1);
    	Robot.oi.getMotorSS().getFrontLeft().set(1);
    	Robot.oi.getMotorSS().getBackLeft().set(1);
    	//placeholder, need to test time needed to drive off ramparts
    	try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
