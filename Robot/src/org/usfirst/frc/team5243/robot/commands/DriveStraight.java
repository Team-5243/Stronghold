package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {

	private RobotDrive iRobot;
	private AnalogGyro gyro;
	private double K = .05; // driving with a gyro konstant
	
	/**
	 * This method will initialize the DriveStraight command. It initializes the gyro, then it
	 * sets the expiration of the RobotDrive to .1
	 * @param thyRobot
	 */
	public DriveStraight(RobotDrive thyRobot) {
		gyro = new AnalogGyro(RobotMap.GyroscopePort);
		iRobot = thyRobot;
		iRobot.setExpiration(.1);
	}
	/**
	 * This 
	 */
	protected void initialize() {

	}
	/**
	 * Ok, so, here is the situation with the execute method of the
	 * DriveStraight command. It returns void and it takes no parameters. What
	 * it does do, however, is make the robot drive straight. The first thing
	 * this method does, is gyro.reset(), which resets the gyro. Next, it calls
	 * RobotDrive.drive, using the parameters Magnitude and Curve. Magnitude is
	 * the speed that the robot will drive at. Curve is the angle that it will
	 * drive out. We use a magnitude of 1, so that it will drive forward as fast
	 * as possible, because we just want it to drive forward. Next, we use of a
	 * curve of K (gyro driving forward konstant) multiplied by gyro.getAngle().
	 * The product of these two numbers creates an angle which will change as
	 * the robot starts to turn, thereby correcting the turn. Finally, it
	 * creates a minor delay, which will allow this method to take effect before
	 * its effects are neutralized. Effectively, the combination of this:
	 * 
	 * will make the robot drive straight for .004 seconds.
	 */
	public void start(){
		gyro.reset();
		iRobot.drive(1, -gyro.getAngle() * K);
		Timer.delay(0.004);
	}
	/**
	 * Ok, so, here is the situation with the execute method of the
	 * DriveStraight command. It returns void and it takes no parameters. What
	 * it does do, however, is make the robot drive straight. The first thing
	 * this method does, is gyro.reset(), which resets the gyro. Next, it calls
	 * RobotDrive.drive, using the parameters Magnitude and Curve. Magnitude is
	 * the speed that the robot will drive at. Curve is the angle that it will
	 * drive out. We use a magnitude of 1, so that it will drive forward as fast
	 * as possible, because we just want it to drive forward. Next, we use of a
	 * curve of K (gyro driving forward konstant) multiplied by gyro.getAngle().
	 * The product of these two numbers creates an angle which will change as
	 * the robot starts to turn, thereby correcting the turn. Finally, it
	 * creates a minor delay, which will allow this method to take effect before
	 * its effects are neutralized. Effectively, the combination of this:
	 * 
	 * will make the robot drive straight for .004 seconds.
	 */
	protected void execute() {
		gyro.reset();
		iRobot.drive(1, -gyro.getAngle() * K);
		Timer.delay(0.004);
	}

	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	protected void interrupted() {
	}
}
