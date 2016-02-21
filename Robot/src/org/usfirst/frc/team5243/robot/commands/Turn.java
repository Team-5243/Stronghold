
package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn extends Command {
	private double toTurn;
	private double initial;
    public Turn(double degrees) {
        requires(Robot.oi.getMotorSS());
        requires(Robot.oi.getSensorSS());
        toTurn = degrees;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        initial = Robot.oi.getSensorSS().getAngle();
        if(toTurn < 0){
        	Robot.oi.getMotorSS().setLeft(-1);
        	Robot.oi.getMotorSS().setRight(1);
        }else{
        	Robot.oi.getMotorSS().setLeft(1);
        	Robot.oi.getMotorSS().setRight(-1);
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.oi.getSensorSS().getAngle()-initial < toTurn;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
