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
	public final static int MotorFrontLeft = 0;
	public final static int MotorFrontRight = 1;
	public final static int MotorBackLeft = 2;
	public final static int MotorBackRight = 3;
	// ports for fly wheels are not finalized; just test ports
	public final static int flyWheelLeft = 4;
	public final static int flyWheelRight = 5;

	public final static int MotorDoggyDoor = 6;
	
<<<<<<< HEAD
	// DIO Ports
	public final static int ultrasonicinputport = 4;
	public final static int ultrasonicoutputport = 5;
	public final static int GyroscopePort = 0;
=======
	
	//DIO Ports
	public final static int ultrasonicinputport = 4; 
	public final static int ultrasonicoutputport = 5; 
	public final static int GyroscopePort = 0;
	public final static int GyroscopePortToo = 1;
<<<<<<< HEAD
=======
=======
	public final static int GyroscopePort = 1;
>>>>>>> 90b8af786f9708bb627bf99550c89f93e039fde5
>>>>>>> a2c135a42b8de58acbc37aeecc73cb5204e0d684
>>>>>>> 1715304b16a7d72d0e3bfba901ee2a28fcca645c
	public final static int EncoderDoggyDoorPortOne = 7;
	public final static int EncoderDoggyDoorPortTwo = 8;

	// Pushing up sensor subsystem and shooting. small changes.
}