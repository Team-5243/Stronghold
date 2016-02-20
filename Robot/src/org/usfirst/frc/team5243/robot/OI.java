package org.usfirst.frc.team5243.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5243.robot.commands.CenterTower;
import org.usfirst.frc.team5243.robot.commands.ClimbCommand;
import org.usfirst.frc.team5243.robot.commands.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.LowBarCommandGroup;
import org.usfirst.frc.team5243.robot.commands.MoatCommand;
import org.usfirst.frc.team5243.robot.commands.RampartsCommandGroup;
import org.usfirst.frc.team5243.robot.commands.RockwallCommandGroup;
import org.usfirst.frc.team5243.robot.commands.RoughTerrainCommandGroup;
import org.usfirst.frc.team5243.robot.commands.Shoot;
import org.usfirst.frc.team5243.robot.commands.SpinUpCommand;
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
	private Button AlignButton;
	private Button SpinUpButton;
	private Button shootButton;
	private Button retrievalButton;
	private Button driveStraightButton;
	private Button climbButton;
	private Button lowBarButton;
	private Button moatButton;
	private Button rampartsButton;
	private Button rockWallButton;
	private Button roughTerrainButton;

    public OI(){
    	System.out.println("OI constructor Start");
    	CameraSub = new CameraSubsystem();
    	MotorSub  = new MotorSubsystem();
    	SensorSub = new SensorSubsystem();
    	RetrievalSub = new RetrievalSubsystem();
    	ShootingSub = new ShootingSubsystem();
    	LiftSub = new LiftSubsystem();
    	
 		leftStick = new Joystick(0);
 		rightStick = new Joystick(1);
 		
    }
    public void init(){
    	AlignButton = new JoystickButton(leftStick, 7);
 		SpinUpButton = new JoystickButton(leftStick, 6);
 		shootButton = new JoystickButton(leftStick, 1);
 		
 		driveStraightButton = new JoystickButton(rightStick, 2);
 		climbButton = new JoystickButton(rightStick, 3);
 		lowBarButton = new JoystickButton(rightStick, 4);
 		moatButton = new JoystickButton(rightStick, 5);
 		rampartsButton = new JoystickButton(rightStick,6);
 		rockWallButton = new JoystickButton(rightStick, 7);
 		roughTerrainButton = new JoystickButton(rightStick,8);
 		
 		//driveStraightButton = new JoystickButton(rightStick, 1);
 		//driveStraightButton.whileHeld(new DriveStraight((double)1.0)); // cast to double to ensure it doesn't cast to Double
<<<<<<< b4ba2bcf228c728b7a0b2bf44707bf503a8fa223
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
 		
 		shootButton.whenPressed(new Shoot());
 		SpinUpButton.whenPressed(new SpinUpCommand());
 		AlignButton.whenPressed(new CenterTower());
 		// begin today buttons
 		driveStraightButton.whenPressed(new DriveStraight(.5,1));
 		climbButton.whenPressed(new ClimbCommand());
 		lowBarButton.whenPressed(new LowBarCommandGroup());
 		moatButton.whenPressed(new MoatCommand());
 		rampartsButton.whenPressed(new RampartsCommandGroup());
 		rockWallButton.whenPressed(new RockwallCommandGroup());
 		roughTerrainButton.whenPressed(new RoughTerrainCommandGroup());
 		// end 2/19 buttons
=======
//		shootButton.whenPressed(new Shoot());
//		SpinUpButton.whenPressed(new SpinUpCommand());
//		AlignButton.whenPressed(new CenterTower());
//		// begin today buttons
		driveStraightButton.whileHeld(new DriveStraight());
		driveStraightButton.whenReleased(new Command(){
			public void start(){
				getMotorSS().setRunning(false);
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
//		climbButton.whenPressed(new ClimbCommand());
//		lowBarButton.whenPressed(new LowBarCommandGroup());
		moatButton.whenPressed(new MoatCommand());
//		rampartsButton.whenPressed(new RampartsCommandGroup());
//		rockWallButton.whenPressed(new RockwallCommandGroup());
//		roughTerrainButton.whenPressed(new RoughTerrainCommandGroup());
 		// end today buttons
>>>>>>> First hour of testing, Drive straight Button 2 works
 		System.out.println("OI constructor End");
 		retrievalButton = new JoystickButton(rightStick, 1);
 		//retrievalButton.whileActive(new Shoot());
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

