package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon leftTalon;
	private CANTalon rightTalon;
	private CANTalon arm;
	private Compressor compressorArm;
	private Solenoid solenoidArm;
	public LiftSubsystem(){
		arm = new CANTalon(RobotMap.ArmMotor);
		leftTalon = new CANTalon(RobotMap.leftClimbMotor);
		rightTalon = new CANTalon(RobotMap.rightClimbMotor);
		solenoidArm = new Solenoid(RobotMap.SolenoidModuleNumber);
		compressorArm = new Compressor();
	}
    public void initDefaultCommand() {
    	
    }
    public CANTalon getLeft(){
    	return leftTalon;
    }
    public CANTalon getRight(){
    	return rightTalon;
    }
    public void setLeft(int speed){
    	leftTalon.set(speed);
    }
    public void raiseArm(){
    	compressorArm.setClosedLoopControl(true);
    	solenoidArm.set(true);
    }
    public void extendArm(double speed){
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
//    	shoot.set(true);
    }
	public void stopLift() {
		leftTalon.set(0);
		rightTalon.set(0);
	}
	public void setBrake(boolean d){
		leftTalon.enableBrakeMode(d);
		rightTalon.enableBrakeMode(d);
	}
}