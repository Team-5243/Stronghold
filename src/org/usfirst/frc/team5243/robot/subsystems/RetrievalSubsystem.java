package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RetrievalSubsystem extends Subsystem {
    private CANTalon door;
	private DigitalInput limit1;
	private DigitalInput limit2;
	
	private Encoder encoder;
	public RetrievalSubsystem(){
		door = new CANTalon(RobotMap.MotorDoggyDoor);
		limit1 = new DigitalInput(RobotMap.LimitSwitch1);
		limit2 = new DigitalInput(RobotMap.LimitSwitch2);
		
		encoder = new Encoder(RobotMap.encoderAChannel, RobotMap.encoderBChannel);
	}
	public DigitalInput getLimit1(){
		return limit1;
	}
	public DigitalInput getLimit2(){
		return limit2;
	}
	/**
	 * starts the turning of the doggy door
	 */
	public void turn(double d){
		door.set(d);
	}
	public void stop(){
		door.set(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public double getSpeed() {
    	return door.get();
    }
    
    public double getEncoderRate() {
		return encoder.getRate();
	}
	
	public double getEncoderDistance() {
		return encoder.getDistance();
	}
	
	public void resetEncoder() {
		//Reinitializes encoder to reset it
		encoder.reset();
	}
}

