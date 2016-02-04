package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.GyroBase;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

/**
 *
 */
public class SensorSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Accelerometer accel;
	Ultrasonic ultra;
	GyroBase gyro;
	public SensorSubsystem(){
		InitAccel();
		InitUltra();
		InitGyro();
	}
    public void initDefaultCommand(){
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void TestAccel(){
    	System.out.println("Accelerometer X: " +accel.getX());
    	System.out.println("Accelerometer Y: " +accel.getY());
    	System.out.println("Accelerometer Z: " +accel.getZ());
    }
    private void InitAccel(){
    	accel = new BuiltInAccelerometer();
    	
    }
    public void TestUltra(){
    	System.out.println("Range: " + ultra.getRangeInches());
    }
    private void InitUltra(){
    	ultra = new Ultrasonic(RobotMap.ultrasonicinputport,RobotMap.ultrasonicoutputport);
    	ultra.setAutomaticMode(true);
    }
    public void TestGyro(){
    	System.out.print("Gyro angle: " + gyro.getAngle());
    	System.out.println("Gyro rate: " + gyro.getRate());
    }
    /**
     * Currently uses port 2
     */
    private void InitGyro(){
    	//gyro = new GyroBase(RobotMap.Gyroscope450);
    }
}

