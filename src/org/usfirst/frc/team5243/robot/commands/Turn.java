
package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn extends Command {
	private double initial;
	private double speed=.25;
	private double current;
	private double toTurn;
	private boolean first = true;
	public Turn(double degrees) {
		requires(Robot.oi.getMotorSS());
		requires(Robot.oi.getSensorSS());
		toTurn = degrees;
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if(first){
			initial = Robot.oi.getSensorSS().getAngle();
			current = initial;
			first = false;
		}
		Robot.oi.getMotorSS().setRunning(true);
		current = Robot.oi.getSensorSS().getAngle();
		if (toTurn < 0) {
			Robot.oi.getMotorSS().turnLeft(speed);
			System.out.println("TurnLeft: " + toTurn);
		} else {
			Robot.oi.getMotorSS().turnRight(speed);
			System.out.println("Turn Right: " + toTurn);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		System.out.println(Math.abs(initial - current));
		return Math.abs(initial - current) > Math.abs(toTurn);
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.oi.getMotorSS().setRunning(false);
		first = true;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
