package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MotorSubsystem extends Subsystem {
	
	private Jaguar frontLeft;
	private Jaguar backLeft;
	private Jaguar frontRight;
	private Jaguar backRight;
	private Jaguar doggyDoor;
    /**
     * made for 4 motors
     */
    public MotorSubsystem(){
    	frontLeft = new Jaguar(RobotMap.MotorFrontLeft);
    	frontRight = new Jaguar(RobotMap.MotorFrontRight);
    	backRight = new Jaguar(RobotMap.MotorBackRight);
    	backLeft = new Jaguar(RobotMap.MotorBackLeft);
    	doggyDoor = new Jaguar(RobotMap.MotorDoggyDoor);
    }
    /**
     * Does nothing at this point
     */
	@Override
	protected void initDefaultCommand() {
		
	}
	public Jaguar getBackRight() {
		return backRight;
	}
	public Jaguar getBackLeft() {
		return backLeft;
	}
	public Jaguar getFrontRight() {
		return frontRight;
	}
	public Jaguar getFrontLeft() {
		return frontLeft;
	}
	
}

