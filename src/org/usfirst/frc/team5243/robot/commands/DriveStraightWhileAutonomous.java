package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightWhileAutonomous extends Command {
	private double speed;
	private double seconds;
	private boolean first = true;
	private long starttime;
	private int clock;
	
    public DriveStraightWhileAutonomous(double seconds, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.speed = speed;
    	this.seconds = seconds;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(first){
    		Robot.oi.getSensorSS().getGyro().reset();
			starttime=System.currentTimeMillis();
			first = false;
	    	Robot.oi.getMotorSS().setRunning(true);
	    	Robot.oi.getMotorSS().getDrive().drive(speed, (Robot.oi.getSensorSS().getGyro().getAngle())*.03);
    	}
 /*   	if(clock > 100){
    		clock = 0;
*/	    	Robot.oi.getMotorSS().getDrive().drive(speed, (Robot.oi.getSensorSS().getGyro().getAngle())*.03);
/*
    	} else { 
    		clock++;
	*/ //   	Robot.oi.getMotorSS().getDrive().drive(speed, 0);

    	//}
    	System.out.println("clock = "+clock);
  /*  	
	    System.out.println("first "+Robot.oi.getSensorSS().getGyro().getAngle());
	    	Robot.oi.getMotorSS().getDrive().drive(speed, (-Robot.oi.getSensorSS().getGyro().getAngle())*.03);
		System.out.println("second "+Robot.oi.getSensorSS().getGyro().getAngle());
		Timer.delay(.004);
    */	/*} else {
    		Robot.oi.getMotorSS().getDrive().drive(speed,0);
    	}*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() - starttime > seconds*1000;
    }

    // Called once after isFinished returns true
    protected void end() {
    	first = true;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
		Robot.oi.getMotorSS().setRunning(false);
    }
}
