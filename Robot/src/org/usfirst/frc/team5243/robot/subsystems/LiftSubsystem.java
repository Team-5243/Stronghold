package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Talon leftTalon;
	private Talon rightTalon;
	public LiftSubsystem(){
		leftTalon = new Talon(RobotMap.leftClimbMotor);
		rightTalon = new Talon(RobotMap.rightClimbMotor);
	}
    public void initDefaultCommand() {
    	
    }
    public Talon getLeft(){
    	return leftTalon;
    }
    public Talon getRight(){
    	return rightTalon;
    }
    public void setLeft(int speed){
    	leftTalon.set(speed);
    }
    public void setRight(int speed){
    	rightTalon.set(speed);
    }
    public void lift(int speed){
    	leftTalon.set(speed);
    	rightTalon.set(speed);
    }
}