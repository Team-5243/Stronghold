package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
/*
 * Stage One
 * 
 * Stage Two
 * 
 * Stage Three
 * 
 * Stage Four
 */

public class RampartsCommand extends Command {
	private boolean first = true;
	private boolean stageOne = true;
	private boolean stageTwo = true;
	private boolean stageThree = true;
	private boolean stageFour = true;

	public RampartsCommand() {

	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (first) {
			first = false;
			Robot.oi.getSensorSS().getGyro().reset();
			Robot.oi.getMotorSS().setRunning(true);
		}
		if (stageOne) {
			stageOne();
		} else if (stageTwo) {
			stageTwo();
		} else if (stageThree) {
			stageThree();
		} else if (stageFour) {
			stageFour();
		}
	}

	private void stageOne() {
		Robot.oi.getMotorSS().getDrive().drive(1, Robot.oi.getSensorSS().getAngle() * .01);
		if (Math.abs(Robot.oi.getSensorSS().getAngle()) > 10) {
			stageOne = false;
		}
	}

	private void stageTwo() {
		if ((Math.abs(Robot.oi.getSensorSS().getAngle()) < 30)) {
			Robot.oi.getMotorSS().getDrive().drive(1, (Robot.oi.getSensorSS().getAngle() * .01) - 180);
		} else {
			stageTwo = false;
		}
	}

	private void stageThree() {
		if ((Math.abs(Robot.oi.getSensorSS().getAngle()) < 45)) {
			Robot.oi.getMotorSS().getDrive().drive(1, Robot.oi.getSensorSS().getAngle()*.5 + 180);
		} else {
			stageThree = false;
		}
	}

	private void stageFour() {
		if (!Robot.oi.getSensorSS().isTiltingY() && !Robot.oi.getSensorSS().isTiltingYneg()) {
			stageFour = false;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return !stageOne && !stageTwo && !stageThree && !stageFour;
	}

	// Called once after isFinished returns true
	protected void end() {	
		Robot.oi.getMotorSS().setRunning(false);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.oi.getMotorSS().setRunning(false);
	}
}

// FORMER WRONG COMMAND
/*
 * if(Robot.oi.getSensorSS().gtY() < 1000000000/*PLACEHOLDER &&
 * Robot.oi.getSensorSS().getY() > 0){ //drive up to ramparts DriveStraight
 * exeggcute = new DriveStraight(); exeggcute.execute(); } //turn right onto
 * ramparts Robot.oi.getMotorSS().getFrontRight().set(0);
 * Robot.oi.getMotorSS().getBackRight().set(0); //placeholder, need to test time
 * needed to turn right try { Thread.sleep(0); } catch (InterruptedException e)
 * { // TODO Auto-generated catch block e.printStackTrace(); } //wait for right
 * side to catch up Robot.oi.getMotorSS().getFrontRight().set(1);
 * Robot.oi.getMotorSS().getBackRight().set(1);
 * Robot.oi.getMotorSS().getFrontLeft().set(0);
 * Robot.oi.getMotorSS().getBackLeft().set(0); ///placeholder, need to test time
 * needed to straighten out try { Thread.sleep(0); } catch (InterruptedException
 * e) { // TODO Auto-generated catch block e.printStackTrace(); } //drive off
 * ramparts DriveStraight theKnightUsed = new DriveStraight(1,1); //
 * speed,seconds theKnightUsed.execute(); //placeholder, need to test time
 * needed to drive off ramparts finished = true;
 */
