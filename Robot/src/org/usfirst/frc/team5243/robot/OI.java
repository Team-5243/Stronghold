package org.usfirst.frc.team5243.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team5243.robot.commands.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.Shoot;
import org.usfirst.frc.team5243.robot.subsystems.*;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
<<<<<<< HEAD
	private final CameraSubsystem CameraSub;
=======

	private final CameraSubsystem CameraSub;

//	private final CameraSubsystem CameraSub = new CameraSubsystem();

>>>>>>> a9822ccdc5bed917e0966a4ad8e7cbc3bbee8e8d
	private final MotorSubsystem MotorSub;
	private final SensorSubsystem SensorSub;
	private final RetrievalSubsystem RetrievalSub;
	private final ShootingSubsystem ShootingSub;
	
	

	private Joystick leftStick;
	private Joystick rightStick;
<<<<<<< HEAD
	private Button shootButton;
	private Button retrievalButton;
	private Button driveStraightButton;
=======

	private Button shootButton;
	private Button retrievalButton;
	private Button driveStraightButton;

//	private Button shootButton;
//	private Button retrievalButton;
>>>>>>> a9822ccdc5bed917e0966a4ad8e7cbc3bbee8e8d
	
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    public OI(){
    	System.out.println("OI constructor Start");
    	CameraSub = new CameraSubsystem();
    	MotorSub  = new MotorSubsystem();
    	SensorSub = new SensorSubsystem();
    	RetrievalSub = new RetrievalSubsystem();
    	ShootingSub = new ShootingSubsystem();
 		leftStick = new Joystick(0);
 		rightStick = new Joystick(1);
<<<<<<< HEAD
 		shootButton = new JoystickButton(leftStick, 1);
 		driveStraightButton = new JoystickButton(rightStick, 1);
=======

 		shootButton = new JoystickButton(leftStick, 1);
 		driveStraightButton = new JoystickButton(rightStick, 1);

// 		shootButton = new JoystickButton(leftStick, 1);

>>>>>>> a9822ccdc5bed917e0966a4ad8e7cbc3bbee8e8d
 	//	shootButton.whileActive(new Shoot()); sSOME ERROR IN SHOOT 
 		System.out.println("OI constructor End");
 		retrievalButton = new JoystickButton(rightStick, 1);
 		//retrievalButton.whileActive(new Shoot());
 	}
    public void initializeDriveStraight(RobotDrive thyDrive){
 		driveStraightButton.whileActive(new DriveStraight(thyDrive));
    }
    
 	
	public CameraSubsystem getCamera(){
		return CameraSub;
	}
	public MotorSubsystem getMotorSS(){
		return MotorSub;
	}
	public SensorSubsystem getSensorSS(){
		return SensorSub;
	}
	public Joystick getLeftStick(){
		return leftStick;
	}
	public Joystick getRightStick(){
		return rightStick;
	}


	public ShootingSubsystem getShootingSS() {
		return ShootingSub;
	}
	public RetrievalSubsystem getRetrievalSS(){
		return RetrievalSub;
	}
}

