package org.usfirst.frc.team5243.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5243.robot.commands.*;
import org.usfirst.frc.team5243.robot.subsystems.*;
import org.usfirst.frc.team5243.triggers.LimitSwitchButton;
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
	
	private LimitSwitchButton retrievalLimits;
	private Button retrievalButton;

	private Button driveStraightWhile;
	private Button retractArm;
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
	private Button lowerArm;
	private Button extendArmButton;
	private Button testTurnButton;
	private DriveStraightWhileHeld driveStraightCommand;
	private ClimbCommand climb;
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
    	setClimb(new ClimbCommand());
    	retrievalLimits = new LimitSwitchButton();
    	
 		turnLeft = new JoystickButton(leftStick,1); 	
 		//driveStraightWhile = new JoystickButton(leftStick,3 );//Will be Removed 
 		retrievalButton = new JoystickButton(leftStick, 2);
 		lowShootButton = new JoystickButton(leftStick, 3);
 		raiseArm = new JoystickButton(leftStick, 6);
 		extendArmButton = new JoystickButton(leftStick, 7); 	
 		retractArm = new JoystickButton(leftStick,8);
 		//moatButton = new JoystickButton(leftStick, 8);
 		//rampartsButton = new JoystickButton(leftStick, 9);
 		alignUltraButton = new JoystickButton(leftStick, 9);
 		driveStraightWhen = new JoystickButton(leftStick,10);
 		turn45 = new JoystickButton(leftStick,11);
 		//testTurnButton= new JoystickButton(leftStick, 8);//Will Be removed
 		
		turnRight = new JoystickButton(rightStick,1);
		driveStraightWhile = new JoystickButton(rightStick, 3);
 		//lowBarButton = new JoystickButton(rightStick, 4); 		
 		gyroReset = new JoystickButton(rightStick, 6);
 		lowerArm = new JoystickButton(rightStick, 7);
 		//rockWallButton = new JoystickButton(rightStick, 8);
 		//roughTerrainButton = new JoystickButton(rightStick,9);
 		climbButton = new JoystickButton(rightStick, 11);
 		retrievalLimits.whenPressed(new TurnOffCommand());
 		/*testTurnButton.whileHeld(new Command(){
 			public void start(){
 				getLiftSS().getLeft().set(.5);
 				getLiftSS().getRight().set(.5);
 			}
			@Override
			protected void initialize() {
				// TODO Auto-generated method stub
				
			}

			@Override
			protected void execute() {
				// TODO Auto-generated method stub
				
			}

			@Override
			protected boolean isFinished() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			protected void end() {
				// TODO Auto-generated method stub
				
			}

			@Override
			protected void interrupted() {
				// TODO Auto-generated method stub
				
			}
 			
 		});*/
 		//testTurnButton.whenReleased(new TurnOffCommand());
 		alignUltraButton.whenPressed(new AlignLowGoalUltraCommand());
 		driveStraightWhile.whileHeld(driveStraightCommand);
 		//driveStraightWhen.whenPressed(new DriveStraight(1,.5));
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
		climbButton.whenPressed(new ClimbCommand());
 		//turn45.whenPressed(new Turn(45));
 		turnLeft.whileHeld(new TurnWhileHeld(true,.25));
 		turnRight.whileHeld(new TurnWhileHeld(false,.25));
 		retrievalButton.whileHeld(new RetrievalCommand(-.8));
 		lowShootButton.whileHeld(new RetrievalCommand(.8));
 		//rampartsButton.whenPressed(new RampartsCommand());
 		climbButton.whenPressed(getClimb());
 		raiseArm.whenPressed(new LiftCommand(true));
 		lowerArm.whenPressed(new LiftCommand(false));
 		//lowBarButton.whenPressed(new LowBarAutonomous());
 		//moatButton.whenPressed(new MoatCommand());
 		//rockWallButton.whenPressed(new RockWallAutonomous());
 		//roughTerrainButton.whenPressed(new RoughTerrainAutonomous());
 		extendArmButton.whileHeld(new ExtendArm(.5));
 		retractArm.whileHeld(new ExtendArm(-.5));
 		extendArmButton.whenReleased(new TurnOffCommand());
 		retractArm.whenReleased(new TurnOffCommand());
 		climbButton.whenReleased(new TurnOffCommand()); 
 		retrievalButton.whenReleased(new TurnOffCommand());
 		lowShootButton.whenReleased(new TurnOffCommand());
 		extendArmButton.whenReleased(new TurnOffCommand());
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
	public ClimbCommand getClimb() {
		return climb;
	}
	public void setClimb(ClimbCommand climb) {
		this.climb = climb;
	}
}

