package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnWhileHeld extends Command {
	private double speed=.4;
	private boolean left;
	public TurnWhileHeld(boolean turnleft, double givenspeed) {
		left = turnleft;
		speed = givenspeed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		
	}

	public void start() {
		Robot.oi.getMotorSS().setRunning(true);
		if(left){
			Robot.oi.getMotorSS().turnLeft(speed);
		}else{
			Robot.oi.getMotorSS().turnRight(speed);
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
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
