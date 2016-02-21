package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MotorSubsystem extends Subsystem {
	
	private Talon frontLeft;
	private Talon backLeft;
	private Talon frontRight;
	private Talon backRight;
	private boolean isRunning;
	private RobotDrive myDrive;
    /**
     * made for 4 motors
     */
    public MotorSubsystem(){
    	frontLeft = new Talon(RobotMap.MotorFrontLeft);
    	frontRight = new Talon(RobotMap.MotorFrontRight);
    	backRight = new Talon(RobotMap.MotorBackRight);
    	backLeft = new Talon(RobotMap.MotorBackLeft);
    	isRunning=false;
    	frontLeft.setInverted(true);
    	frontRight.setInverted(true);
    	backLeft.setInverted(true);
    	backRight.setInverted(true);
    	myDrive = new RobotDrive(frontLeft,backLeft,frontRight,backRight);
    	myDrive.setSafetyEnabled(false);
    }
    /**
     * Does nothing at this point
     */
    public boolean isCommandRunning(){
    	return isRunning;
    }
    public void setRunning(boolean s){
    	isRunning =s;
    }
	@Override
	protected void initDefaultCommand() {
		
	}
	public Talon getBackRight() {
		return backRight;
	}
	public Talon getBackLeft() {
		return backLeft;
	}
	public Talon getFrontRight() {
		return frontRight;
	}
	public Talon getFrontLeft() {
		return frontLeft;
	}
	public void setAll(double x){
		frontLeft.set(x);
		frontRight.set(x);
		backLeft.set(x);
		backRight.set(x);
	}
	public void setLeft(double speedthedroog){
		frontLeft.set(speedthedroog);
		backLeft.set(speedthedroog);
	}
	public void setRight(double speedthenumber){
		frontRight.set(speedthenumber);
		backRight.set(speedthenumber);
	}
	public double getSpeed(){
		return frontLeft.getSpeed();
	}
	public RobotDrive getDrive(){
		return myDrive;
	}
	public void turnLeft(double speed){
		setLeft(speed);
		setRight(speed);
	}
	public void turnRight(double speed){
		setLeft(speed);
		setRight(speed);
	}
}

