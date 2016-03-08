package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightAccel extends Command {
	private double speed;
	private boolean first;
	private boolean negative;
    public DriveStraightAccel(double s, boolean neg) {
    	speed = s;
    	first = true;
    	negative = neg;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		if(first){
			Robot.oi.getSensorSS().getGyro().reset();
			first = false;
		}
		Robot.oi.getMotorSS().setRunning(true);
		Robot.oi.getMotorSS().getDrive().drive(-speed, -Robot.oi.getSensorSS().getGyro().getAngle() * .03);
		System.out.print("in 3Start");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(!negative)
    		return Robot.oi.getSensorSS().isTiltingY();
    	else
    		return Robot.oi.getSensorSS().isTiltingYneg();
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
