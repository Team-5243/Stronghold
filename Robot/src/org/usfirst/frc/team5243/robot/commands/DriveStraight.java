package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {




	@SuppressWarnings("unused")
	private int distance=0;
	private double seconds = 2; // one is Double and the other is double, so that there can be 
	private Double speed = 1.0; // separate constructors for time and speed
	private double k = .05;
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
        requires(Robot.oi.getMotorSS());
        requires(Robot.oi.getSensorSS());
		this.seconds = seconds;
		if(speed > 1){
			speed = 1;
		}
		this.speed = speed*1000;
	}
	/**
	 * 
	 */
	public DriveStraight(int distance, double speed){
		this.seconds = 9001;
		this.distance = distance;
		this.speed = speed;
	}
	/**
	 * will drive at maximum speed for 0 seconds
	 * (seconds, speed)
	 */
	public DriveStraight(){
		requires(Robot.oi.getMotorSS());
        requires(Robot.oi.getSensorSS());
        //requires(Robot.oi.getMotorSS());
	}
	
	/**
	 * will drive straight at the given speed for 0 seconds
	 * @param speed
	 */
	public DriveStraight(Double speed){
		requires(Robot.oi.getMotorSS());
        requires(Robot.oi.getSensorSS());
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
	}
	public void setSpeed(double speed){
		this.speed = speed;
	}
	public double getSpeed(){
		return speed;
	}
	public double getSeconds(){
		return seconds;
	}
	public void setSeconds(double seconds){
		this.seconds=seconds;
	}
	protected void initialize() {
		System.currentTimeMillis();
	}

	/**
	 * will make the robot drive straight for the number of seconds in the constructor, or, if y	ou did not set
	 * that, it will drive for 0 seconds;
<<<<<<< 52eff39453bf031405c119f52558b8db3b3c2536
	 */

	public void start(){
		Robot.oi.getMotorSS().setRunning(true);
		if(!isFinished){
			Robot.oi.getSensorSS().getGyro().reset();
		}
		Robot.oi.getMotorSS().getDrive().drive(speed, -Robot.oi.getSensorSS().getGyro().getAngle() * k);
		isFinished = true;
		System.out.print("in Start");
	}
	/**
	 * will make the robot drive straight for the number of seconds in the constructor, or, if you did not set
	 * that, it will drive for 0 seconds;
	 */

	protected boolean isFinished() {
		return System.currentTimeMillis() - starttime < 0;
	}
	protected void execute() {
		if(first){
			Robot.oi.getMotorSS().setRunning(true);
			starttime = System.currentTimeMillis();
		}
		Robot.oi.getMotorSS().getDrive().drive(speed, -Robot.oi.getSensorSS().getGyro().getAngle());
		System.out.println("in execute" + System.currentTimeMillis());
	}
	
	// Called once after isFinished returns true
	protected void end() {
		System.out.println("Ending DriveStraight");
		Robot.oi.getMotorSS().setRunning(false);
	}
	public void changeConstant(double conman){
		k = conman;
	}
	protected void interrupted() {
	}
}
