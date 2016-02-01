
package org.usfirst.frc.team5243.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
<<<<<<< 724fd99e2ed1146c45958c09f9e48c406346b45e
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
=======
>>>>>>> Made the shooting subsystem and shoot command *second go*


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	
	public static OI oi;
<<<<<<< 724fd99e2ed1146c45958c09f9e48c406346b45e
	//NetworkTable table;
	double[] defaultValue = new double[0];
	public Robot() {
	//	table = NetworkTable.getTable("GRIP/myCoutoursReport");
		
	}
=======
>>>>>>> Made the shooting subsystem and shoot command *second go*
	

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		oi.getCamera().CameraInit();
		oi.getCamera().CameraSetUp();
        // instantiate the command used for the autonomous period
<<<<<<< 724fd99e2ed1146c45958c09f9e48c406346b45e
		myDrive = new RobotDrive(oi.getMotorSS().getFrontLeft(), oi.getMotorSS().getBackLeft(), oi.getMotorSS().getFrontRight(), oi.getMotorSS().getBackRight());
		SmartDashboard.putNumber("Motor", 5);
		
=======
>>>>>>> Made the shooting subsystem and shoot command *second go*
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	//	oi.getCamera().CameraEnd();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    
         
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	
    	
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();//Never delete
        oi.getCamera().CameraLoop();
<<<<<<< 724fd99e2ed1146c45958c09f9e48c406346b45e
        
      //  double areas = table.getNumber("area", 0);
		//System.out.print("areas: ");
		//for (double area: areas) {
		//	System.out.print(areas + " ");
		//}
		//System.out.println();
		myDrive.tankDrive(oi.getLeftStick(),oi.getRightStick());
		oi.getSensorSS().TestAccel();
		oi.getSensorSS().TestUltra();
		//System.out.print("");
	}
=======
    }
>>>>>>> Made the shooting subsystem and shoot command *second go*
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
