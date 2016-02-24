package org.usfirst.frc.team5243.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	// PWM Ports
	public final static int flyWheelRight = 0;
	public final static int flyWheelLeft = 1;
	public final static int MotorFrontLeft = 2;
	public final static int MotorFrontRight = 3;
	public final static int MotorBackLeft = 4;
	public final static int MotorBackRight = 5;
	public final static int MotorDoggyDoor = 6;
	public final static int leftClimbMotor = 7;
	public final static int rightClimbMotor = 8;
	public final static int ArmMotor = 9;
	// DIO Ports
	// Pushing up sensor subsystem and shooting. small changes.
	public static final int SolenoidModuleNumber = 3;
	public static final int SolenoidChannel = 0;
	public final static int ultrasonicinputport = 1;
	public final static int EncoderDoggyDoorPortOne = 6;
	public final static int EncoderDoggyDoorPortTwo = 7;
	// Pushing up sensor subsystem and shooting. small changes.

	
}