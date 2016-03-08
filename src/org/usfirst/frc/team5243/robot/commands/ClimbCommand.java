package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbCommand extends Command {
	private double startTime;
	public boolean first;
	public ClimbCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		first =true;
	}
	// Called just before this Command runs the first time
	protected void initialize() {
	}
	// Called repeatedly when this Command is scheduled to run
	public void start() {
		if(first){
			startTime = System.currentTimeMillis()/1000.0;
			first = false;
		}
		Robot.oi.getLiftSS().setBrake(false);
		double currentTime = System.currentTimeMillis()/1000.0;
		double speed = -.001*Math.pow(2, -(currentTime-startTime));
		if (Robot.oi.getSensorSS().isTiltingYneg()) {
			Robot.oi.getLiftSS().getLeft().set(speed*(Math.abs(1-Robot.oi.getSensorSS().getY())));
			Robot.oi.getLiftSS().getRight().set(speed);
		}
		else if (Robot.oi.getSensorSS().isTiltingY()) {
			Robot.oi.getLiftSS().getLeft().set(speed);
			Robot.oi.getLiftSS().getRight().set(speed*(Math.abs(1-Robot.oi.getSensorSS().getY())));
		}
		else{
			Robot.oi.getLiftSS().getLeft().set(speed);
			Robot.oi.getLiftSS().getRight().set(speed);
		}
	}


	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.oi.getLiftSS().stopLift();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}
}
