package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightWhileHeld extends Command {




	private Double speed = 1.0; // separate constructors for time and speed
	private double k;
	public DriveStraightWhileHeld(double speed) {
        requires(Robot.oi.getMotorSS());
        requires(Robot.oi.getSensorSS());
		this.speed = speed;
		k = .05;
	}
	public void setSpeed(double speed){
		this.speed = speed;
	}
	public double getSpeed(){
		return speed;
	}
	protected void initialize() {
		Robot.oi.getSensorSS().getGyro().reset();
	}
	/**
	 * will make the robot drive straight for the number of seconds in the constructor, or, if you did not set
	 * that, it will drive for 0 seconds;
	 */
	@Override
	public void start(){
		Robot.oi.getMotorSS().setRunning(true);
<<<<<<< HEAD
		Robot.oi.getMotorSS().getDrive().drive(speed, Robot.oi.getSensorSS().getGyro().getAngle()*.03);
		System.out.print("in Start");
=======
		Robot.oi.getMotorSS().getDrive().drive(speed, Robot.oi.getSensorSS().getGyro().getAngle()*.01);
		System.out.println("in Start2");
		if(first){
		Robot.oi.getSensorSS().getGyro().reset();
		first = false;
		}
>>>>>>> 7de52de00171182031a6da410667e4cfc66e851d
	}
	/**
	 * will make the robot drive straight for the number of seconds in the constructor, or, if you did not set
	 * that, it will drive for 0 seconds;
	 */
	protected void execute() {
		
	}

	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.oi.getMotorSS().setRunning(false);
	}
	
	protected void interrupted() {
		Robot.oi.getMotorSS().setRunning(false);
	}
}
