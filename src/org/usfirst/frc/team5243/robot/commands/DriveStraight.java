package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {




	private int distance=0; // This is never actually read!
	private double seconds = 2; // one is Double and the other is double, so that there can be 
	private Double speed = 1.0; // separate constructors for time and speed
	private double k = .05;
	private long starttime;
	private boolean isFinished = false; // This is never read!
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
		this.speed = speed;
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
		return System.currentTimeMillis() - starttime > seconds*1000;
	}
	@Override
	protected void execute(){
		if(first){
			starttime=System.currentTimeMillis();
			first = false;
		}
		Robot.oi.getMotorSS().setRunning(true);
		Robot.oi.getMotorSS().getDrive().drive(speed, -Robot.oi.getSensorSS().getGyro().getAngle() * k);
		System.out.print("in Start");
	}
	
	// Called once after isFinished returns true
	@Override
	protected void end() {
		System.out.println("Ending DriveStraight");
		first = true;
		Robot.oi.getMotorSS().setRunning(false);
	}
	public void changeConstant(double conman){
		k = conman;
	}
	protected void interrupted() {
		Robot.oi.getMotorSS().setRunning(false);
	}
}
