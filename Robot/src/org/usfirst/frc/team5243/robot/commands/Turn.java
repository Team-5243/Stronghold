package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn extends Command {
	private double target;
	private double initial;
	private double speed=.4;
	private double k = .05;

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

	}

	public void start() {
		Robot.oi.getMotorSS().setRunning(true);
		Robot.oi.getMotorSS().turnLeft(speed);
		System.out.print("in Start");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		initial = Robot.oi.getSensorSS().getAngle();
		if (initial - target < 0) {
			Robot.oi.getMotorSS().turnLeft(speed);
			System.out.println("turning left");
		} else {
			Robot.oi.getMotorSS().turnRight(speed);
			System.out.println("turning right");
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		System.out.println(Math.abs(initial - target));
		return Math.abs(initial - target) < 5;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
