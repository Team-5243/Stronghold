package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AlignLowGoalUltraCommand extends Command {
	private double greatestDegrees;
	private double greatestRange;
	private boolean isFinished = false;
	private boolean isFirstTime = true;
	double initialAngle = 0;
	double current = 0;

	public AlignLowGoalUltraCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		if (isFirstTime) {
			initialAngle = Robot.oi.getSensorSS().getAngle();
			isFirstTime = false;
		}
		Robot.oi.getMotorSS().setRunning(true);
		current = Robot.oi.getSensorSS().getAngle();
		Robot.oi.getMotorSS().turnRight(.2);
		System.out.println("turning left");
		double distanceCurrent = Robot.oi.getSensorSS().ultraOutput();
		if (distanceCurrent > greatestRange&&distanceCurrent<180) {
			greatestRange = Robot.oi.getSensorSS().ultraOutput();
			greatestDegrees = Robot.oi.getSensorSS().getAngle();
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Math.abs(initialAngle - current) > 90;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.oi.getSensorSS().setDegreeTurn(-(Robot.oi.getSensorSS().getAngle() - greatestDegrees));
		System.out.println(Robot.oi.getSensorSS().getDegreeTurn());
		isFirstTime = true;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
