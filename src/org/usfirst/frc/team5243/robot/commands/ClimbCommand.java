package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbCommand extends Command {
	public ClimbCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}
	// Called just before this Command runs the first time
	protected void initialize() {
	}
	// Called repeatedly when this Command is scheduled to run
	public void start() {
		Robot.oi.getLiftSS().setBrake(false);
		if (Robot.oi.getSensorSS().isTiltingZneg()) {
			Robot.oi.getLiftSS().getLeft().set(.5);
			Robot.oi.getLiftSS().getLeft().set(0);
		}
		else if (Robot.oi.getSensorSS().isTiltingZ()) {
			Robot.oi.getLiftSS().getLeft().set(.5);
			Robot.oi.getLiftSS().getLeft().set(0);
		}
		else{
			Robot.oi.getLiftSS().getLeft().set(.5);
			Robot.oi.getLiftSS().getRight().set(.5);
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
