package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftCommand extends Command {
	private boolean up;

	public LiftCommand(boolean s) {
		// requires(Robot.oi.getLiftSS());
		up = s;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (up) {
			Robot.oi.getLiftSS().raiseArm();
		} else {
			Robot.oi.getLiftSS().lowerArm();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
		if (up) {
			Robot.oi.getLiftSS().raiseArm();
		}
		else{
			Robot.oi.getLiftSS().lowerArm();
		}
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
