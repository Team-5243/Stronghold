package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

/**
 *
 */
public class SensorSubsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.



	static Accelerometer accel;
	Ultrasonic ultra;
	AnalogGyro gyro;
	private static int count = 0;

	public SensorSubsystem() {
		InitAccel();
		InitUltra();
		InitGyro();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void TestAccel() {
		if (count++ % 10 == 0) {
			System.out.println("Accelerometer X: " + accel.getX());
			System.out.println("Accelerometer Y: " + accel.getY());
			System.out.println("Accelerometer Z: " + accel.getZ());
		}
	}

	public double getX() {
		return accel.getX();
	}

	public double getY() {
		return accel.getY();
	}

	public double getZ() {
		return accel.getZ();
	}

	private void InitAccel() {
		accel = new BuiltInAccelerometer();

	}

	public void TestUltra() {
		System.out.println("Range: " + ultra.getRangeInches());
	}

	private void InitUltra() {
		ultra = new Ultrasonic(RobotMap.ultrasonicinputport, RobotMap.ultrasonicoutputport);
		ultra.setAutomaticMode(true);
	}

	public void TestGyro() {
		System.out.print("Gyro angle: " + gyro.getAngle());
		System.out.println("Gyro rate: " + gyro.getRate());
	}

	public double getAngle() {
		return gyro.getAngle();
	}

	public double getRate() {
		return gyro.getRate();
	}

	public static boolean isTilting(){
	// using getY for test robot, not sure for real robot
	   int count=0;
	   for (int i=0; i<3; i++){
		   if(accel.getY() > 0.117){
			   count++;
		   }
	   }
	   if (count>=2) return true;
	   return false;
	}

	/**
	 * Currently uses port 2
	 */
	private void InitGyro() {
		gyro = new AnalogGyro(RobotMap.GyroscopePort);
<<<<<<< HEAD
		gyro = new AnalogGyro(RobotMap.GyroscopePortToo);
	}
}
=======

	}
	public AnalogGyro getGyro(){
		return gyro;
	}
}
>>>>>>> 4d339c1bbfa5857e4cdb701a814f7a98e7cf19af
