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
	private Encoder lecoder;
	public RetrievalSubsystem(){
		door = new Jaguar(RobotMap.MotorDoggyDoor);
	}
	
	/**
	 * starts the turning of the doggy door
	 */
	public void turn(){
		door.set(1);
	}
	public void stop(){
		door.stopMotor();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

