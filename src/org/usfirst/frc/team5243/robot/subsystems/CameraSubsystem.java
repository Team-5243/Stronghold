package org.usfirst.frc.team5243.robot.subsystems;


import org.usfirst.frc.team5243.robot.RobotMap;

import com.ni.vision.NIVision;
//import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
//import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
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
    double area;
    double x1;
    double y1;
    double h1;
    double w1;
    private int run = 0;
    
    private Servo cameraServo;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public CameraSubsystem() {
    	table = NetworkTable.getTable("piTable"/*MUST CHANGEWHENITISSETNOWDONTYELLATMYLACKOFSPACES*/);
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
    	}catch (Exception ex){
    		ex.printStackTrace();
    		CameraEnd();
    		CameraInit();
    		CameraSetUp();
    	}
    }
    public void runPy(){
		table.putNumber("run", 1);	
		Timer.delay(0.1);
    	run = 0;
    }
    public double getAreas(){
    	double[] defaultValue = new double[0];
    		double[] areas = table.getNumberArray("area", defaultValue);
    		System.out.println("Areas: ");
    		for(double area : areas){
    			System.out.print(area + " ");
    			this.area = area;
    		}
    		System.out.println("");
    		return area;
    }
    public double getX(){
		return table.getNumber("x", 0);
    }
    public double getY(){
    	return table.getNumber("y", 0);
    }
    public double getHeight(){
		return table.getNumber("Height", 0);
    }
    public double getOurOrdersBasedOnXValue(){
    	/*if(getX() > getWidth()/2){
    		System.out.println("Turn Democratic (left) you Scrubs");
    		return -1;
    	}
    	if(getX() < getWidth()/2){
    		System.out.println("Turn Republican (right) you scrubs");
    		return 1;
    	}
    	System.out.println("Amazing.");
    	return 0;*/
    	return -(getX() - getWidth()/2); //Negative so that a negative number will mean we need to turn left, positive turn right
    }
    public void getOurOrdersBasedOnYValue(){
    	if(getY() > getHeight()/2){
    		System.out.println("Turn ___ For what (Down)");
    	}
    	if(getY() < getHeight()/2){
    		System.out.println("Music is too quiet. Turn it _____     (up)");
    	}
    	if(getY() == getHeight()/2){
    		System.out.println("Perfect.");
    	}
    }
    
    public double getWidth(){
    	return table.getNumber("Width", 0);
		
    }
    public void CameraEnd(){
    	NIVision.IMAQdxStopAcquisition(session);
    }
	/*public double distanceToCenterTower() {
		return 0.0;
	}/*
	public boolean isTowerCentered() {
		return false;
	}*/
	
	// Spins the camera servo degree to parameter degree
	public void spinCamera(double d) {
		cameraServo.set(d);
	}
	public double getCameraAngle() {
		return cameraServo.getAngle();
	}    
}