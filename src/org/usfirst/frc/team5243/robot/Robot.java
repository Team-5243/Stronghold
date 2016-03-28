
package org.usfirst.frc.team5243.robot;

import org.usfirst.frc.team5243.robot.commands.*;
import org.usfirst.frc.team5243.robot.subsystems.MotorSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	@SuppressWarnings("unused")
	private RobotDrive myDrive;
	NetworkTable table;
	double[] defaultValue = new double[0];

	public Robot() {
		//table = NetworkTable.getTable("GRIP/myCoutoursReport");

	}

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		oi.init();
		oi.getCamera().CameraInit();
		oi.getCamera().CameraSetUp();
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		CommandGroup s = new NewAuto();
		s.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		oi.getCamera().CameraLoop();
		LiveWindow.run();
		SmartDashboard.putNumber("Motor RPM", oi.getMotorSS().getSpeed());
		SmartDashboard.putNumber("Doggy Door Speed",oi.getRetrievalSS().getSpeed());
		SmartDashboard.putNumber("Accelerometer X", oi.getSensorSS().getX());
		SmartDashboard.putNumber("Accelerometer Y", oi.getSensorSS().getY());
		SmartDashboard.putNumber("Accelerometer Z", oi.getSensorSS().getZ());
		SmartDashboard.putNumber("Gyro Angle", oi.getSensorSS().getAngle());
		SmartDashboard.putNumber("Gyro Rate", oi.getSensorSS().getRate());
		SmartDashboard.putNumber("Ultrasonic", Robot.oi.getSensorSS().ultraOutput());
		SmartDashboard.putNumber("Network Table", oi.getCamera().getAreas());
	}

	public void teleopInit() {

    }


	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {
		//oi.getCamera().CameraEnd();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();// Never delete
		MotorSubsystem ms = oi.getMotorSS();
		if (!ms.isCommandRunning()) {
			ms.getDrive().tankDrive(oi.getLeftStick(), oi.getRightStick());

		}
		LiveWindow.run();
		
		SmartDashboard.putNumber("Motor RPM", oi.getMotorSS().getSpeed());
		SmartDashboard.putNumber("Doggy Door Speed",oi.getRetrievalSS().getSpeed());
		SmartDashboard.putNumber("Accelerometer X", oi.getSensorSS().getX());
		SmartDashboard.putNumber("Accelerometer Y", oi.getSensorSS().getY());
		SmartDashboard.putNumber("Accelerometer Z", oi.getSensorSS().getZ());
		SmartDashboard.putNumber("Gyro Angle", oi.getSensorSS().getAngle());
		SmartDashboard.putNumber("Gyro Rate", oi.getSensorSS().getRate());
		SmartDashboard.putNumber("Ultrasonic", Robot.oi.getSensorSS().ultraOutput());
		SmartDashboard.putNumber("Network Table", oi.getCamera().getAreas());

		oi.getCamera().CameraLoop();
		//SmartDashboard.putNumber("NetworkTable areas", oi.getCamera().getAreas());

		/*
		 * double areas = table.getNumber("area", 0); System.out.print("areas: "
		 * ); for (double area: areas) { System.out.print(areas + " "); }
		 * System.out.println();
		 * 
		 * oi.getSensorSS().TestAccel(); oi.getSensorSS().TestUltra();
		 * 
		 * System.out.print("");
		 */
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
		SmartDashboard.putNumber("Motor RPM", oi.getMotorSS().getSpeed());
		SmartDashboard.putNumber("Doggy Door Speed", oi.getRetrievalSS().getSpeed());
		SmartDashboard.putNumber("Accelerometer X", oi.getSensorSS().getX());
		SmartDashboard.putNumber("Accelerometer Y", oi.getSensorSS().getY());
		SmartDashboard.putNumber("Accelerometer Z", oi.getSensorSS().getZ());
		SmartDashboard.putNumber("Gyro Angle", oi.getSensorSS().getAngle());
		SmartDashboard.putNumber("Gyro Rate", oi.getSensorSS().getRate());
	}
}