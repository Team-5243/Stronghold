package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;
import org.usfirst.frc.team5243.robot.commands.Wait;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShootingSubsystem extends Subsystem {
	private CANTalon leftSide;
	private CANTalon rightSide;
	private Servo shootServo;
	
	private double speed;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public ShootingSubsystem() {
		leftSide = new CANTalon(RobotMap.flyWheelLeft);
		rightSide = new CANTalon(RobotMap.flyWheelRight);
		shootServo = new Servo(RobotMap.shootServo);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	

	public void spinUp(double speed) {
			leftSide.set(speed);
			rightSide.set(-speed);
			System.out.println("Fully started!");
			this.speed = speed;
	}

	public void spinDown() {
			leftSide.set(0.0);
			rightSide.set(0.0);
			System.out.println("Powered down");
			speed = 0;
	}
	public void spinServo(){
		shootServo.setAngle(90);
	}
	public void resetServo(){
		shootServo.setAngle(0);
	}
	public double getSpeed() {
		return speed;
	}
	public double getServoAngle() {
		// TODO Auto-generated method stub
		return shootServo.getAngle();
	}
	
	/*public Encoder getEncoder() {
		return door;
	}*/ 
	
	
}