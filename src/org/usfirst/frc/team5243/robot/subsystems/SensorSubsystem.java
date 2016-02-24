package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

/**
 *
 */
public class SensorSubsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.


	private Accelerometer accel;
	private AnalogInput ultra;
	private ADXRS450_Gyro gyro;
	private double degreeTurn;

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
	public double ultraOutput(){
		return ultra.getVoltage()/.0097;
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
		System.out.println("Range: " + ultra.getVoltage());
	}

	private void InitUltra() {
		ultra = new AnalogInput(RobotMap.ultrasonicinputport); //max angle of 20 degrees
	}

	public void TestGyro() {
		System.out.println("Gyro angle: " + gyro.getAngle());
		System.out.println("Gyro rate: " + gyro.getRate());
	}

	public double getAngle() {
		return gyro.getAngle();
	}

	public double getRate() {
		return gyro.getRate();
	}

	public boolean isTiltingZ() {
		// using getY for test robot, not sure for real robot
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (accel.getZ() > 0.117) {
				count++;
			}
		}
		if (count >= 2)
			return true;
		return false;
	}

	public boolean isTiltingY() {
		// using getY for test robot, not sure for real robot
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (accel.getY() > 0.117) {
				count++;
			}
		}
		if (count >= 2)
			return true;
		return false;
	}

	// Tilt is usually above .15, flat at .0xxx, negative positive based on side
	// lifted
	public boolean isTiltingX() {
		// using getY for test robot, not sure for real robot
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (accel.getX() > 0.117) {
				count++;
			}
		}
		if (count >= 2)
			return true;
		return false;
	}

	public boolean isTiltingXneg() {
		// using getY for test robot, not sure for real robot
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (accel.getX() > -0.117) {
				count++;
			}
		}
		if (count >= 2)
			return true;
		return false;
	}

	public boolean isTiltingYneg() {
		// using getY for test robot, not sure for real robot
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (accel.getY() > -0.117) {
				count++;
			}
		}
		if (count >= 2)
			return true;
		return false;
	}

	public boolean isTiltingZneg() {
		// using getY for test robot, not sure for real robot
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (accel.getZ() > -0.117) {
				count++;
			}
		}
		if (count >= 2)
			return true;
		return false;
	}

	private void InitGyro() {
		gyro = new ADXRS450_Gyro();
	}

	public ADXRS450_Gyro getGyro() {
		return gyro;
	}

	public double getDegreeTurn() {
		return degreeTurn;
	}

	public void setDegreeTurn(double degreeTurn) {
		this.degreeTurn = degreeTurn;
	}


}
