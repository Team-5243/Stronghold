package org.usfirst.frc.team5243.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team5243.robot.commands.*;
import org.usfirst.frc.team5243.robot.subsystems.*;
import org.usfirst.frc.team5243.triggers.LimitSwitchButton;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	

	private final CameraSubsystem CameraSub;
	private final LiftSubsystem LiftSub;
	private final MotorSubsystem MotorSub;
	private final RetrievalSubsystem RetrievalSub;
	private final SensorSubsystem SensorSub;
	private final ShootingSubsystem ShootingSub;
	
	private Joystick leftStick;
	private Joystick rightStick;
	
	private LimitSwitchButton retrievalLimits;
	private Button alignUltraButton;
	private Button climbButton;
	private Button driveStraightWhile;
	private Button extendArmButton;
	private Button flyWheelRetrieveButton;
	private Button flyWheelShootButton;
	private Button flyWheelShootHalfButton;
	private Button lowerArm;
	private Button lowShootButton;
	private Button raiseArm;
	private Button retractArm;
	private Button retrievalButton;
	private Button turnLeft;
	private Button turnRight;
	
	
	private ClimbCommand climb;
	private DriveStraightWhileHeld driveStraightCommand;
    
	
	public OI(){
    	System.out.println("OI constructor Start");
    	driveStraightCommand = new DriveStraightWhileHeld(.6);
    	CameraSub = new CameraSubsystem();
    	LiftSub = new LiftSubsystem();
    	MotorSub  = new MotorSubsystem();
    	RetrievalSub = new RetrievalSubsystem();
    	SensorSub = new SensorSubsystem();
    	ShootingSub = new ShootingSubsystem();
    	
 		leftStick = new Joystick(0);
 		rightStick = new Joystick(1);
 		
    }
    public void init(){
    	setClimb(new ClimbCommand());
    	retrievalLimits = new LimitSwitchButton();
    	//free buttons: Left: 4, 5, 10, 11, 12 Right: 2, 4, 5, 6, 8, 9, 10, 12
    	flyWheelRetrieveButton = new JoystickButton(rightStick, 4);
 		flyWheelShootButton = new JoystickButton(rightStick, 5);
    	flyWheelShootHalfButton = new JoystickButton(leftStick, 10);
    	
    	
 		turnLeft = new JoystickButton(leftStick,1); 	
 		retrievalButton = new JoystickButton(leftStick, 3);
 		lowShootButton = new JoystickButton(leftStick, 2);
 		raiseArm = new JoystickButton(leftStick, 6);
 		extendArmButton = new JoystickButton(leftStick, 7); 	
 		retractArm = new JoystickButton(leftStick,8);
 		alignUltraButton = new JoystickButton(leftStick, 9);
 		
		turnRight = new JoystickButton(rightStick,1);
		driveStraightWhile = new JoystickButton(rightStick, 3);		
 		lowerArm = new JoystickButton(rightStick, 7);
 		climbButton = new JoystickButton(rightStick, 11);
 		
 		
 		
 		driveStraightWhile.whileHeld(driveStraightCommand);
 		turnLeft.whileHeld(new TurnWhileHeld(true,.25));
 		turnRight.whileHeld(new TurnWhileHeld(false,.25));
 		retrievalButton.whileHeld(new RetrievalCommand(-.35));
 		flyWheelRetrieveButton.whileHeld(new BringInBall());
 		lowShootButton.whileHeld(new RetrievalCommand(.45));
 		extendArmButton.whileHeld(new ExtendArm(.5));
 		retractArm.whileHeld(new ExtendArm(-.5));
 		
 		retrievalLimits.whenPressed(new TurnOffCommand());
 		alignUltraButton.whenPressed(new AlignLowGoalUltraCommand());
 		climbButton.whenPressed(new ClimbCommand());
 		climbButton.whenPressed(getClimb());
 		flyWheelShootHalfButton.whenPressed(new ShootCommand(-.5));
 		flyWheelShootButton.whenPressed(new ShootCommand(-1));
 		raiseArm.whenPressed(new LiftCommand(true));
 		lowerArm.whenPressed(new LiftCommand(false));
 		
 		
 		extendArmButton.whenReleased(new TurnOffCommand());
 		retractArm.whenReleased(new TurnOffCommand());
 		climbButton.whenReleased(new TurnOffCommand()); 
 		retrievalButton.whenReleased(new TurnOffCommand());
 		lowShootButton.whenReleased(new TurnOffCommand());
 		extendArmButton.whenReleased(new TurnOffCommand());
		driveStraightWhile.whenReleased(new EnableDrive());
		flyWheelRetrieveButton.whenReleased(new TurnOffCommand());
		turnLeft.whenReleased(new EnableDrive());
		turnRight.whenReleased(new EnableDrive());
	
 		System.out.println("OI constructor End");
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

	public RetrievalSubsystem getRetrievalSS(){
		return RetrievalSub;
	}
	public LiftSubsystem getLiftSS(){
		return LiftSub;
	}
	public ClimbCommand getClimb() {
		return climb;
	}
	public void setClimb(ClimbCommand climb) {
		this.climb = climb;
	}
	public ShootingSubsystem getShootingSS() {
		// TODO Auto-generated method stub
		return ShootingSub;
	}
}

