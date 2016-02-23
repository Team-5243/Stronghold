package org.usfirst.frc.team5243.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5243.robot.commands.AlignLowGoalUltraCommand;
import org.usfirst.frc.team5243.robot.commands.CenterTower;
import org.usfirst.frc.team5243.robot.commands.ClimbCommand;
import org.usfirst.frc.team5243.robot.commands.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.LowBarCommand;
import org.usfirst.frc.team5243.robot.commands.MoatCommand;
import org.usfirst.frc.team5243.robot.commands.RetrievalCommand;
import org.usfirst.frc.team5243.robot.commands.RockWallCommand;
import org.usfirst.frc.team5243.robot.commands.RoughTerrainCommand;
import org.usfirst.frc.team5243.robot.commands.DriveStraightWhileHeld;
import org.usfirst.frc.team5243.robot.commands.MoatCommand;
import org.usfirst.frc.team5243.robot.commands.Shoot;
import org.usfirst.frc.team5243.robot.commands.SpinUpCommand;
import org.usfirst.frc.team5243.robot.commands.Turn;
import org.usfirst.frc.team5243.robot.commands.TurnWhileHeld;
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
	private final ShootingSubsystem ShootingSub;
	private final LiftSubsystem LiftSub;
	
	private Joystick leftStick;
	private Joystick rightStick;
	private Button alignUltraButton;
	private Button AlignButton;
	//private Button SpinUpButton;
	//private Button shootButton;
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
	private Button driveStraightUltra;
	private DriveStraightWhileHeld w;
	
    public OI(){
    	CameraSub = new CameraSubsystem();
    	MotorSub  = new MotorSubsystem();
    	SensorSub = new SensorSubsystem();
    	RetrievalSub = new RetrievalSubsystem();
    	ShootingSub = new ShootingSubsystem();
    	LiftSub = new LiftSubsystem();
 		leftStick = new Joystick(0);
 		rightStick = new Joystick(1);
 		w = new DriveStraightWhileHeld(.7);
 		
    }
    public void init(){
    	//AlignButton = new JoystickButton(leftStick, 7);
 		//SpinUpButton = new JoystickButton(leftStick, 6);
 		//shootButton = new JoystickButton(leftStick, 1);
 		
 		
 		
 		turn45 = new JoystickButton(leftStick,5);
 		turnLeft = new JoystickButton(rightStick,4);
 		turnRight = new JoystickButton(rightStick,3);
 		
 		
 		gyroReset = new JoystickButton(leftStick, 2);
 		alignUltraButton = new JoystickButton(rightStick, 2);
 		driveStraightWhile = new JoystickButton(rightStick, 1);
 		driveStraightWhen = new JoystickButton(leftStick,3);
 		driveStraightUltra = new JoystickButton(leftStick, 1);
// 		climbButton = new JoystickButton(rightStick, 3);
 		//lowBarButton = new JoystickButton(rightStick, 6);
 		//moatButton = new JoystickButton(rightStick, 5);
 		//rockWallButton = new JoystickButton(rightStick, 7);
 		//roughTerrainButton = new JoystickButton(rightStick,8);
 		
 		/*					button name
 		 * CenterTower		AlignButton
 		 * ClimbCommand		climbButton
 		 * DriveStraight	driveStraightButton
 		 * LowBar			lowBarButton
 		 * Moat				moatButton
 		 * Ramparts			rampartsButton
 		 * RockWall			rockWallButton
 		 * Rough Terrain	roughTerrainButton
 		 * Shoot			shootButton
 		 * 
 		 */
 		
// 		shootButton.whenPressed(new Shoot());
// 		SpinUpButton.whenPressed(new SpinUpCommand());
// 		AlignButton.whenPressed(new CenterTower());
 		// begin today buttons*/
 		alignUltraButton.whenPressed(new AlignLowGoalUltraCommand());
 		driveStraightWhile.whileHeld(w);
 		//driveStraightWhen.whenPressed(new DriveStraight(2.0,1));
 		driveStraightUltra.whenPressed(new DriveStraight(42, .6));
 		//LiftButton.whenPressed(new ClimbCommand());
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
				// TODO Auto-generated method stub
				
			}
 			
 		});
//		climbButton.whenPressed(new ClimbCommand());
 		turn45.whenPressed(new Turn(45));
 		turnLeft.whileHeld(new TurnWhileHeld(true,.5));
 		turnRight.whileHeld(new TurnWhileHeld(false,.5));
 		
 		//lowBarButton.whenPressed(new LowBarAutonomous());
 		//moatButton.whenPressed(new MoatCommand());
 		//rockWallButton.whenPressed(new RockWallAutonomous());
 		//roughTerrainButton.whenPressed(new RoughTerrainAutonomous());
 		//cameraReset.whenPressed(new ResetCamera());
 		
 		
 		// end 2/19 buttons

//		shootButton.whenPressed(new Shoot());
//		SpinUpButton.whenPressed(new SpinUpCommand());
//		AlignButton.whenPressed(new CenterTower());
		// begin today buttons
		driveStraightWhile.whenReleased(new Command(){
			public void start(){
				getMotorSS().setRunning(false);
				w.first = true;
			}
			@Override
			protected void initialize() {
			}
			protected void execute() {	
				getMotorSS().setRunning(false);
			}
			@Override
			protected boolean isFinished() {
				// TODO Auto-generated method stub
				return false;
			}
			@Override
			protected void end() {	
				getMotorSS().setRunning(false);
			}

			@Override
			protected void interrupted() {
				// TODO Auto-generated method stub
				
			}
			
		});
//		shootButton.whenPressed(new Shoot());
//		SpinUpButton.whenPressed(new SpinUpCommand());
//		AlignButton.whenPressed(new CenterTower());
		//retrievalButton = new JoystickButton(rightStick, 1);
 		//retrievalButton.whileActive(new Shoot());		
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
	public ShootingSubsystem getShootingSS() {
		return ShootingSub;
	}
	public RetrievalSubsystem getRetrievalSS(){
		return RetrievalSub;
	}
	public LiftSubsystem getLiftSS(){
		return LiftSub;
	}
}

