package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Retrieval extends Subsystem {
    Jaguar door;
    //Encoder lecoder;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Retrieval(){
		door = new Jaguar(RobotMap.MotorDoggyDoor);
		//lecoder = new Encoder(RobotMap.EncoderPort,RobotMap.EncoderPortToo);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    /**
     * Not currently working
     * When it is, it will turn the motor 180 degrees
     */
    public void oneTurn(){
    //	lecoder.reset();
    //	lecoder.startLiveWindowMode(); //not certain this is what is needed to start the count
    	
    }
    
    /**
     * Starts the motor turning
     */
    public void turn(){
    	door.set(1);
    }
    /**
     * Stops the motor turning
     */
    public void stop(){
    	door.stopMotor();
    }
    
}

