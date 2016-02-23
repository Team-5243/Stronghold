package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {




	private int distance;
	private double seconds; // one is Double and the other is double, so that there can be 
	private Double speed; // separate constructors for time and speed
	private final double k = .03;
	private long starttime;
	private boolean isFinished = false;
	private boolean first = true;
	/**
	 * 
	 * 
	 * @param seconds
	 * @param speed
	 */
	public DriveStraight(double seconds,double speed) {
		System.out.println("Started seconds constructor");
        requires(Robot.oi.getMotorSS());
        requires(Robot.oi.getSensorSS());
		this.seconds = seconds;
		if(speed > 1){
			speed = 1;
		}
		this.speed = speed;
		distance = 0;
	}
	/**
	 * 
	 */
	public DriveStraight(int dist, double speed){
		System.out.println("Called distance constructor");
		seconds = 0;
		distance = dist;
		this.speed = speed;
	}
	/**
	 * will drive straight at the maximum speed for 
	 * @param seconds
	 */
	public DriveStraight(double seconds){
		requires(Robot.oi.getMotorSS());
        requires(Robot.oi.getSensorSS());
        this.seconds = seconds;
        speed = 0.5;
        distance = 0;
	}
	
	protected void initialize() {
	}

	/**
	 * will make the robot drive straight for the number of seconds in the constructor, or, if y	ou did not set
	 * that, it will drive for 0 seconds;
<<<<<<< 52eff39453bf031405c119f52558b8db3b3c2536
	 */

	
	/**
	 * will make the robot drive straight for the number of seconds in the constructor, or, if you did not set
	 * that, it will drive for 0 seconds;
	 */
	@Override
	protected boolean isFinished() {
		if(distance == 0)
			return System.currentTimeMillis() - starttime > seconds*1000;
		else{
			System.out.println(distance);
			System.out.println(Robot.oi.getSensorSS().ultraOutput());
			return Robot.oi.getSensorSS().ultraOutputAverage() < distance;
		}
	}
	@Override
	protected void execute(){
		if(first){
			starttime=System.currentTimeMillis();
			Robot.oi.getSensorSS().getGyro().reset();
			first = false;
		}
		Robot.oi.getMotorSS().setRunning(true);
		Robot.oi.getMotorSS().getDrive().drive(speed, Robot.oi.getSensorSS().getGyro().getAngle() * k);
		System.out.print("in Start");
		
	}
	
	// Called once after isFinished returns true
	@Override
	protected void end() {
		System.out.println("Ending DriveStraight");
		first = true;
		Robot.oi.getMotorSS().setRunning(false);
	}
	protected void interrupted() {
		Robot.oi.getMotorSS().setRunning(false);
	}
}
