package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RetrievalSubsystem extends Subsystem {
    private Jaguar door;
	//private Encoder doorEncoder;
	public RetrievalSubsystem(){
		door = new Jaguar(RobotMap.MotorDoggyDoor);
		//doorEncoder = new Encoder(0,1,false,Encoder.EncodingType.k4X);
	}
	
	/**
	 * starts the turning of the doggy door
	 */
	public void turn(){
		door.set(1);
		/*if(doorEncoder.get() >= .5){
			stop();
		}	*/
	}
	public void stop(){
		door.stopMotor();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public double getSpeed() {
    	return door.get();
    }
}

