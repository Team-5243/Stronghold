package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Wait extends Command {
	private int sec;
	@SuppressWarnings("unused")
	private double startTime;
	
    public Wait(int seconds) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	sec = seconds;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*if(first){
    		first=false;
    		startTime=System.currentTimeMillis();
    	}
    	System.out.println(System.currentTimeMillis()-startTime);
		System.out.println(sec);
		System.out.println(System.currentTimeMillis()-startTime>sec*1000);
		*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return System.currentTimeMillis()-startTime<sec*1000;
    	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	try {
    		System.out.println("Started wait");
			wait(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("ended wait");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
