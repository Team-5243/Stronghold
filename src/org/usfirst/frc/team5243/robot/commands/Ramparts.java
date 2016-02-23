package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Ramparts extends Command {
	private boolean tiltedY = false;
	private boolean tiltedYNeg = false;
	private boolean first = true;

	public Ramparts() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (first) {
			Robot.oi.getMotorSS().setRunning(true);
			first = false;
		}
		if (Robot.oi.getSensorSS().isTiltingY()) {
			tiltedY = true;
		}
		if (Robot.oi.getSensorSS().isTiltingYneg()) {
			tiltedYNeg = true;
		}
		Robot.oi.getMotorSS().getDrive().drive(1, -Robot.oi.getSensorSS().getGyro().getAngle() * .05);

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return tiltedY && tiltedYNeg;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.oi.getMotorSS().getDrive().drive(1, 0);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Robot.oi.getMotorSS().setRunning(false);
		first = true;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {

	}
	/*
	 * Evan's former failue while(Robot.oi.getSensorSS().getY() < 1000000000 &&
	 * Robot.oi.getSensorSS().getY() > 0){ //drive up to ramparts DriveStraight
	 * drivestraight = new DriveStraight(); drivestraight.execute(); } //turn
	 * right onto ramparts Robot.oi.getMotorSS().getFrontRight().set(0);
	 * Robot.oi.getMotorSS().getBackRight().set(0); //placeholder, need to test
	 * time needed to turn right try { Thread.sleep(0); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } //wait for right side to catch up
	 * Robot.oi.getMotorSS().getFrontRight().set(1);
	 * Robot.oi.getMotorSS().getBackRight().set(1);
	 * Robot.oi.getMotorSS().getFrontLeft().set(0);
	 * Robot.oi.getMotorSS().getBackLeft().set(0); ///placeholder, need to test
	 * time needed to straighten out try { Thread.sleep(0); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } //drive off ramparts DriveStraight theKnightUsed =
	 * new DriveStraight(1,1); // speed,seconds theKnightUsed.execute();
	 * //placeholder, need to test time needed to drive off ramparts finished =
	 * true;
	 */
}
