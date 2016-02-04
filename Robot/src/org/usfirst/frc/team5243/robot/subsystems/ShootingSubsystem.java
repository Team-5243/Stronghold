package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShootingSubsystem extends Subsystem {
    private Jaguar leftSide = new Jaguar(RobotMap.flyWheelLeft);
    private Jaguar rightSide = new Jaguar(RobotMap.flyWheelRight);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void spinUp(){
    	if(leftSide.getSpeed()==1)
    		System.out.println("It's already at max speed");
    	else{
    		leftSide.set(1.0);
    		rightSide.set(1.0);
    		System.out.println("Fully started!");
    	}
    }
    public void spinDown(){
    	if(leftSide.getSpeed() == 0)
    		System.out.println("It's already down");
    	else{
    		leftSide.set(0.0);
    		rightSide.set(0.0);
    		System.out.println("Powered down");
    	}
    }
    public double getSpeed(){
    	return leftSide.getSpeed();
    	
    }
    
}

