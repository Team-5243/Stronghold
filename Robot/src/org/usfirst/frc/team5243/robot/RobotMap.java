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
	public final static int leftClimbMotor = 7;
	public final static int rightClimbMotor = 8;
	// PWM Ports
	public final static int MotorFrontLeft = 0;
	public final static int MotorFrontRight = 2;
	public final static int MotorBackLeft = 1;
	public final static int MotorBackRight = 3;
	// ports for fly wheels are not finalized; just test ports
	public final static int flyWheelLeft = 4;
	public final static int flyWheelRight = 5;
	public final static int MotorDoggyDoor = 6;
	// DIO Ports
	public final static int ultrasonicinputport = 4;
	public final static int ultrasonicoutputport = 5;
	public final static int GyroscopePort = 0;
	public final static int GyroscopePortToo = 1;
	public final static int EncoderDoggyDoorPortOne = 7;
	public final static int EncoderDoggyDoorPortTwo = 8;
	// Pushing up sensor subsystem and shooting. small changes.
}