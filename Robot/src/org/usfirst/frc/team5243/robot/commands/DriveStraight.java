package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {




	private double seconds = 2; // one is Double and the other is double, so that there can be 
	private Double speed = 1.0; // separate constructors for time and speed
	private double k = .05;
	private long starttime = 0;
	private boolean isFinished = false;
	/**
	 * gets gyro from the sensorsubsystem, gets robotdrive from the motor subsystem
	 * 
	 * @param seconds
	 * @param speed
	 */
	public DriveStraight(double seconds,double speed) {
        requires(Robot.oi.getMotorSS());
        requires(Robot.oi.getSensorSS());
		this.seconds = seconds;
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
        starttime = System.currentTimeMillis();
	}
	/**
	 * will drive straight at the given speed for 0 seconds
	 * @param speed
	 */
	public DriveStraight(Double speed){
		requires(Robot.oi.getMotorSS());
        requires(Robot.oi.getSensorSS());
		this.speed = speed;
		starttime = System.currentTimeMillis();
	}
	/**
	 * will drive straight at the maximum speed for 
	 * @param seconds
	 */
	public DriveStraight(double seconds){
		requires(Robot.oi.getMotorSS());
        requires(Robot.oi.getSensorSS());
        this.seconds = seconds;
        starttime = System.currentTimeMillis();
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
		Robot.oi.getSensorSS().getGyro().reset();
	}
	/**
	 * will make the robot drive straight for the number of seconds in the constructor, or, if you did not set
	 * that, it will drive for 0 seconds;
	 * @param isFinished 
	 */
	@Override
	public void start(){
		Robot.oi.getMotorSS().setRunning(true);
		if(!isFinished){
			//Robot.oi.getSensorSS().getGyro().reset();
		}
		Robot.oi.getMotorSS().getDrive().drive(speed, -Robot.oi.getSensorSS().getGyro().getAngle() * k);
		isFinished = true;
		System.out.print("in Start");
	}
	/**
	 * will make the robot drive straight for the number of seconds in the constructor, or, if you did not set
	 * that, it will drive for 0 seconds;
	 */
	protected void execute() {
		Robot.oi.getMotorSS().getDrive().drive(speed, -Robot.oi.getSensorSS().getGyro().getAngle() * k);
	}

	protected boolean isFinished() {
		return System.currentTimeMillis() - starttime > seconds*1000;
	}

	// Called once after isFinished returns true
	protected void end() {
		isFinished =false;
		Robot.oi.getMotorSS().setRunning(false);
	}
	
	protected void interrupted() {
	}
}
