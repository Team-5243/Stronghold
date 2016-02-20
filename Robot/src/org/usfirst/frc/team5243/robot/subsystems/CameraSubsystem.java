package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class CameraSubsystem extends Subsystem {
    private int session;
    private Image frame;
    private NIVision.Rect rect;
    NetworkTable table;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void CameraInit(){
    
    }
    public void CameraSetUp(){

        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        
        // the camera name (ex "cam0") can be found through the roborio web interface
        session = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);
    	System.out.println("In camera SetUp");
    	NIVision.IMAQdxStartAcquisition(session);
        /**
         * grab an image, draw the circle, and provide it for the camera server
         * which will in turn send it to the dashboard.
         */
         rect =  new NIVision.Rect(10, 10, 100, 100);
    }
    public void CameraLoop(){	
        NIVision.IMAQdxGrab(session, frame, 1);
    	table = NetworkTable.getTable("GRIP/myContoursReport");
        NIVision.imaqDrawShapeOnImage(frame, frame, rect,DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
        CameraServer.getInstance().setQuality(60);
        CameraServer.getInstance().setImage(frame);
        
    }
    public double getAreas(){
<<<<<<< 802c647afa1b8a506695138f1cc869e19ca056c2
    	double areas[] = table.getNumberArray("targets/area", new double[0]);
=======
    	return 0.0;
    /*	double areas[] = table.getNumberArray("area", new double[0]);
>>>>>>> Fixed project to running state
    	if(areas.length == 0)
    		return -1;
    	System.out.println(areas);
        return areas[0];*/
    }
   
    
    public void CameraEnd(){
    	//NIVision.IMAQdxStopAcquisition(session);
    }
	public double distanceToCenterTower() {
		// TODO Auto-generated method stub
		return Robot.oi.getSensorSS().getRange();
	}
	public boolean isTowerCentered() {
		// TODO Auto-generated method stub
		return false;
	}
    
}