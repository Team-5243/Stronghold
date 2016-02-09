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

    /**
     * made for 4 motors
     */
    public MotorSubsystem(){
    	frontLeft = new Talon(RobotMap.MotorFrontLeft);
    	frontRight = new Talon(RobotMap.MotorFrontRight);
    	backRight = new Talon(RobotMap.MotorBackRight);
    	backLeft = new Talon(RobotMap.MotorBackLeft);
    }
    /**
     * Does nothing at this point
     */
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
	public double getSpeed(){
		return frontLeft.getSpeed();
	}
	
	
}

