package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Talon leftTalon;
	private Talon rightTalon;
	private Talon arm;
	private Solenoid shoot;
	public LiftSubsystem(){
		//arm = new Talon(RobotMap.Arm);
		leftTalon = new Talon(RobotMap.leftClimbMotor);
		rightTalon = new Talon(RobotMap.rightClimbMotor);
		shoot = new Solenoid(RobotMap.SolenoidModuleNumber,RobotMap.SolenoidChannel);
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
    public void raiseArm(int speed){
    	arm.set(speed);
    }
    public void setRight(int speed){
    	rightTalon.set(speed);
    }
    public void lift(int speed){
    	leftTalon.set(speed);
    	rightTalon.set(speed);
    }
    public void shootOut(){
    	shoot.set(true);
    }
}