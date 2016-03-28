package org.usfirst.frc.team5243.robot.subsystems;


import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;

import com.ni.vision.NIVision;
//import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
//import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class CameraSubsystem extends Subsystem {
    private int session;
    private Image frame;
    NetworkTable table;
    CameraServer server;
    
    private Servo cameraServo;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public CameraSubsystem() {
    	cameraServo = new Servo(RobotMap.cameraServo);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void CameraInit(){
    
    }
    public void CameraSetUp(){
    	/*server = CameraServer.getInstance();
    	server.setQuality(15);
    	server.startAutomaticCapture("cam0");*/
    	frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        
        // the camera name (ex "cam0") can be found through the roborio web interface
        session = NIVision.IMAQdxOpenCamera("cam3", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);
    	System.out.println("In camera SetUp");
    	NIVision.IMAQdxStartAcquisition(session);
    }
    public void CameraLoop(){
    	try{
    		NIVision.IMAQdxGrab(session, frame, 2);
    		CameraServer.getInstance().setQuality(100);
    		CameraServer.getInstance().setImage(frame);
    	}catch (NullPointerException n){
    		CameraEnd();
    		CameraInit();
    		CameraSetUp();
    	}
    }
    public double getAreas(){
    	return 0;
    	/*int areas = (int) table.getNumber("dsTime",0);
    	System.out.println(areas);
        return areas;*/
    }
   
    
    public void CameraEnd(){
    	NIVision.IMAQdxStopAcquisition(session);
    }
	public double distanceToCenterTower() {
		// TODO Auto-generated method stub
		return 0.0;
	}
	public boolean isTowerCentered() {
		// TODO Auto-generated method stub
		return false;
	}
	
	// Spins the camera servo degree to parameter degree
	public void spinCamera(double d) {
		cameraServo.set(d);
	}
	
	public double getCameraAngle() {
		return cameraServo.getAngle();
	}
    
}