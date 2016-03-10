package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MotorSubsystem extends Subsystem {

	private Victor frontLeft;
	private Victor backLeft;
	private Victor frontRight;
	private Victor backRight;
	private boolean isRunning;
	private boolean driveStraightFirst;
	private RobotDrive myDrive;

	/**
	 * made for 4 motors
	 */
	public MotorSubsystem() {
		frontLeft = new Victor(RobotMap.MotorFrontLeft);
		frontRight = new Victor(RobotMap.MotorFrontRight);
		backRight = new Victor(RobotMap.MotorBackRight);
		backLeft = new Victor(RobotMap.MotorBackLeft);
		isRunning = false;
		driveStraightFirst = true;
		frontLeft.setInverted(true);
		frontRight.setInverted(true);
		backLeft.setInverted(true);
		backRight.setInverted(true);
		myDrive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
		myDrive.setSafetyEnabled(false);
	}

	/**
	 * Does nothing at this point
	 */
	public boolean isCommandRunning() {
		return isRunning;
	}

	public void setRunning(boolean s) {
		isRunning = s;
	}

	@Override
	protected void initDefaultCommand() {

	}

	public Victor getBackRight() {
		return backRight;
	}

	public Victor getBackLeft() {
		return backLeft;
	}

	public Victor getFrontRight() {
		return frontRight;
	}

	public Victor getFrontLeft() {
		return frontLeft;
	}

	public void setAll(double x) {
		frontLeft.set(x);
		frontRight.set(x);
		backLeft.set(x);
		backRight.set(x);
	}

	public void setLeft(double speedthedroog) {
		frontLeft.set(speedthedroog);
		backLeft.set(speedthedroog);
	}

	public void setRight(double speedthenumber) {
		frontRight.set(speedthenumber);
		backRight.set(speedthenumber);
	}

	public double getSpeed() {
		return frontLeft.getSpeed();
	}

	public RobotDrive getDrive() {
		return myDrive;
	}

	public void turnLeft(double speed) {
		setLeft(speed);
		setRight(speed);
		System.out.println("Left: " + speed);
	}

	public void turnRight(double speed) {
		setLeft(-speed);
		setRight(-speed);
		System.out.println("Right: " + speed);
	}

	/**
	 * is drive straight first;
	 * 
	 * @param d
	 */
	public void setDriveStraight(boolean d) {
		driveStraightFirst = d;
	}

	public boolean isDriveStraight() {
		return driveStraightFirst;
	}

}
