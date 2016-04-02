package org.usfirst.frc.team5243.robot;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public final class RobotMap {
	public final static int MotorFrontLeft = 0;
	public final static int MotorFrontRight = 1;
	public final static int MotorBackLeft = 2;
	public final static int MotorBackRight = 3;
	public final static int shootServo = 6;
	public final static int cameraServo = 7; // might change
	public final static NetworkTable std = NetworkTable.getTable("SmartDashboard"); // smart dashboard table - sdt ->> std
	
	// CAN Port
	public final static int flyWheelLeft = 2;
	public final static int flyWheelRight = 3;
	public final static int MotorDoggyDoor = 1;
	public final static int ArmMotor = 0;
	// DIO Ports
	public static final int SolenoidModuleNumber = 3;
	public final static int LimitSwitch1 = 0;
	public final static int LimitSwitch2 = 1;
	// Pushing up sensor subsystem and shooting. small changes.
	//Analog
	public final static int ultrasonicinputport = 1;
	
	//Encoder channels
	public static final int encoderAChannel = 8; // currently placeholder
	public static final int encoderBChannel = 9; // currently placeholder	
	
	public static double defensePosition(){
		return NetworkTable.getTable("SmartDashboard").getNumber("DefensePosition",1);
	}
}