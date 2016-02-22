
package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn extends Command {
	private double target;
	private double initial;
	private double speed=.2;
	private double current;
	public Turn(double degrees) {
		requires(Robot.oi.getMotorSS());
		requires(Robot.oi.getSensorSS());
		target = degrees;
	}

	public Turn(double speed, double degrees) {
		requires(Robot.oi.getMotorSS());
		requires(Robot.oi.getSensorSS());
		target = degrees;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		initial = Robot.oi.getSensorSS().getAngle();
	}

/*	public void start() {
		Robot.oi.getMotorSS().setRunning(true);
		Robot.oi.getMotorSS().turnLeft(speed);
		System.out.print("in Start");
	}*/

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.oi.getMotorSS().setRunning(true);
		current = Robot.oi.getSensorSS().getAngle();
		if (current - target > 0) {
			Robot.oi.getMotorSS().turnLeft(speed);
			System.out.println("turning left");
		} else {
			Robot.oi.getMotorSS().turnRight(speed);
			System.out.println("turning right");
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		System.out.println(Math.abs(initial - current));
		return Math.abs(initial - current) > target;
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
