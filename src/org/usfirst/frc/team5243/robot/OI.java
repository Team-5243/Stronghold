package org.usfirst.frc.team5243.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5243.robot.commands.*;
import org.usfirst.frc.team5243.robot.subsystems.*;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	

	private final CameraSubsystem CameraSub;
	private final MotorSubsystem MotorSub;
	private final SensorSubsystem SensorSub;
	private final RetrievalSubsystem RetrievalSub;

	private final LiftSubsystem LiftSub;
	
	private Joystick leftStick;
	private Joystick rightStick;
	private Button alignUltraButton;

	private Button retrievalButton;
	private Button driveStraightWhile;
	private Button driveStraightWhen;
	private Button climbButton;
	private Button lowBarButton;
	private Button moatButton;
	private Button rampartsButton;
	private Button rockWallButton;
	private Button roughTerrainButton;
	private Button turnLeft;
	private Button turnRight;
	private Button turn45;
	private Button gyroReset;
	private Button lowShootButton;
	private Button raiseArm;
	private DriveStraightWhileHeld driveStraightCommand;
    public OI(){
    	System.out.println("OI constructor Start");
    	driveStraightCommand = new DriveStraightWhileHeld(.6);
    	CameraSub = new CameraSubsystem();
    	MotorSub  = new MotorSubsystem();
    	SensorSub = new SensorSubsystem();
    	RetrievalSub = new RetrievalSubsystem();
    	LiftSub = new LiftSubsystem();
 		leftStick = new Joystick(0);
 		rightStick = new Joystick(1);
 		
    }
    public void init(){
 		turnLeft = new JoystickButton(leftStick,1); 	
 		driveStraightWhile = new JoystickButton(leftStick,2 );//Will be Removed 
 		retrievalButton = new JoystickButton(leftStick, 3);
 		gyroReset = new JoystickButton(leftStick, 4);
 		turn45 = new JoystickButton(leftStick,5); //Will be remove
 		moatButton = new JoystickButton(leftStick, 8);
 		rampartsButton = new JoystickButton(leftStick, 9);
 		alignUltraButton = new JoystickButton(leftStick, 11);
 		
		turnRight = new JoystickButton(rightStick,1);
 		driveStraightWhen = new JoystickButton(rightStick,2);
 		lowShootButton = new JoystickButton(rightStick, 3);
 		lowBarButton = new JoystickButton(rightStick, 4); 		
 		climbButton = new JoystickButton(rightStick, 5);
 		rockWallButton = new JoystickButton(rightStick, 8);
 		roughTerrainButton = new JoystickButton(rightStick,9);
 		raiseArm = new JoystickButton(rightStick, 11);
 		
 		alignUltraButton.whenPressed(new AlignLowGoalUltraCommand());
 		driveStraightWhile.whileHeld(driveStraightCommand);
 		driveStraightWhen.whenPressed(new DriveStraight(1,.5));
 		gyroReset.whenPressed(new Command(){
			@Override
			protected void initialize() {}
			@Override
			protected void execute() {getSensorSS().getGyro().reset();}
			@Override
			protected boolean isFinished() {return true;}
			@Override
			protected void end() {getSensorSS().getGyro().reset();}
			@Override
			protected void interrupted() {
			}	
 		});
//		climbButton.whenPressed(new ClimbCommand());
 		turn45.whenPressed(new Turn(45));
 		turnLeft.whileHeld(new TurnWhileHeld(true,.5));
 		turnRight.whileHeld(new TurnWhileHeld(false,.5));
 		retrievalButton.whenPressed(new RetrievalCommand());
 		lowShootButton.whenPressed(new LowShoot());
 		rampartsButton.whenPressed(new RampartsCommand());
 		climbButton.whenPressed(new ClimbCommand());
 		raiseArm.whenPressed(new LiftCommand(.1));
 		lowBarButton.whenPressed(new LowBarAutonomous());
 		moatButton.whenPressed(new MoatCommand());
 		rockWallButton.whenPressed(new RockWallAutonomous());
 		roughTerrainButton.whenPressed(new RoughTerrainAutonomous());
 		
		driveStraightWhile.whenReleased(new EnableDrive());
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
}

