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
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 1715304b16a7d72d0e3bfba901ee2a28fcca645c
	static Accelerometer accel;
	Ultrasonic ultra;
	AnalogGyro gyro;
	AnalogGyro gyroToo;
	private static int count = 0;

	public SensorSubsystem() {
		 InitAccel();
		// InitUltra();
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
		System.out.println("Second gyro port");
		System.out.print("Gyro angle: " + gyroToo.getAngle());
		System.out.println("Gyro rate: " + gyroToo.getRate());
	}

	public String getAngle() {
		return gyro.getAngle() + "gyroToo: " + gyroToo.getAngle();
	}

	public String getRate() {
		return gyro.getRate() + "gyroToo: " + gyroToo.getRate();
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
		gyro = new AnalogGyro(RobotMap.GyroscopePortToo);
	}
<<<<<<< HEAD
}
=======
}
=======
>>>>>>> a2c135a42b8de58acbc37aeecc73cb5204e0d684
	Accelerometer accel;
	Ultrasonic ultra;
	AnalogGyro gyro;

	public SensorSubsystem() {
		InitAccel();
		InitUltra();
		InitGyro();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
<<<<<<< HEAD

	public void TestAccel() {
		System.out.println("Accelerometer X: " + getX());
		System.out.println("Accelerometer Y: " + getY());
		System.out.println("Accelerometer Z: " + getZ());
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
=======

	public void TestAccel() {
		System.out.println("Accelerometer X: " + accel.getX());
		System.out.println("Accelerometer Y: " + accel.getY());
		System.out.println("Accelerometer Z: " + accel.getZ());
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

>>>>>>> a2c135a42b8de58acbc37aeecc73cb5204e0d684
	}

	public void TestUltra() {
		System.out.println("Range: " + ultra.getRangeInches());
	}

	private void InitUltra() {
		ultra = new Ultrasonic(RobotMap.ultrasonicinputport, RobotMap.ultrasonicoutputport);
		ultra.setAutomaticMode(true);
	}

	public void TestGyro() {
<<<<<<< HEAD
		System.out.print("Gyro angle: " + getAngle());
		System.out.println("Gyro rate: " + getRate());
=======
		System.out.print("Gyro angle: " + gyro.getAngle());
		System.out.println("Gyro rate: " + gyro.getRate());
>>>>>>> a2c135a42b8de58acbc37aeecc73cb5204e0d684
	}

	public double getAngle() {
		return gyro.getAngle();
	}

	public double getRate() {
		return gyro.getRate();
	}

	private void InitGyro() {
		gyro = new AnalogGyro(RobotMap.GyroscopePort);
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> 90b8af786f9708bb627bf99550c89f93e039fde5
>>>>>>> a2c135a42b8de58acbc37aeecc73cb5204e0d684
>>>>>>> 1715304b16a7d72d0e3bfba901ee2a28fcca645c
