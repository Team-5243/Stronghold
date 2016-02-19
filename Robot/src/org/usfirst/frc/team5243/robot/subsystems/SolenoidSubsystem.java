package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SolenoidSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Solenoid sol = new Solenoid(RobotMap.SolenoidModuleNumber,RobotMap.SolenoidChannel);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void turnOn(){
    	sol.set(true);
    }
    public void turnOff(){
    	sol.set(false);
    }
    public boolean getState(){
    	return sol.get();
    }
}

