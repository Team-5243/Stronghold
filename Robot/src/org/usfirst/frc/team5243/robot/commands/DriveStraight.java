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

	private RobotDrive iRobot;
	private ADXRS450_Gyro gyro;
	private double K = .05; // driving w/gyro konstant
	private double seconds = 0; // one is Double and the other is double, so that there can be 
	private Double speed = 1.0; // separate constructors for time and speed
	private boolean isFinished = false;
	/**
	 * gets gyro from the sensorsubsystem, gets robotdrive from the motor subsystem
	 * 
	 * @param seconds
	 * @param speed
	 */
	public DriveStraight(double seconds,double speed) {
        requires(Robot.oi.getMotorSS());
		iRobot = Robot.oi.getMotorSS().getDrive();
		gyro = Robot.oi.getSensorSS().getGyro();
		this.seconds = seconds;
		this.speed = speed;
	}
	/**
	 * will drive at maximum speed for 0 seconds
	 * (seconds, speed)
	 */
	public DriveStraight(){
        requires(Robot.oi.getMotorSS());
        iRobot = Robot.oi.getMotorSS().getDrive();
		gyro = Robot.oi.getSensorSS().getGyro();
		
	}
	/**
	 * will drive straight at the given speed for 0 seconds
	 * @param speed
	 */
	public DriveStraight(Double speed){
		requires(Robot.oi.getMotorSS());
        iRobot = Robot.oi.getMotorSS().getDrive();
		gyro = Robot.oi.getSensorSS().getGyro();
		this.speed = speed;
	}
	/**
	 * will drive straight at the maximum speed for 
	 * @param seconds
	 */
	public DriveStraight(double seconds){
		requires(Robot.oi.getMotorSS());
        iRobot = Robot.oi.getMotorSS().getDrive();
		gyro = Robot.oi.getSensorSS().getGyro();
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
	 * will make the robot drive straight for the number of seconds in the constructor, or, if you did not set
	 * that, it will drive for 0 seconds;
	 */
	public void start(){
		gyro.reset();
		iRobot.drive(speed, -gyro.getAngle() * K);
		Timer.delay(seconds);
		isFinished = true;
		end();
	}
	/**
	 * will make the robot drive straight for the number of seconds in the constructor, or, if you did not set
	 * that, it will drive for 0 seconds;
	 */
	protected void execute() {
		gyro.reset();
		iRobot.drive(speed, -gyro.getAngle() * K);
		Timer.delay(seconds);
		isFinished = true;
	}

	protected boolean isFinished() {
		return isFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
		
	}
	
	protected void interrupted() {
	}
}
