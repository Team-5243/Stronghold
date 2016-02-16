package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbCommand extends Command {
	private boolean done = false;
	private Jaguar leftMotor;
	private Jaguar rightMotor;
	
    public ClimbCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	leftMotor = new Jaguar(RobotMap.leftClimbMotor);
    	rightMotor = new Jaguar(RobotMap.rightClimbMotor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(!Robot.oi.getSensorSS().isTiltingZ()){
    		leftMotor.set(1);
    		rightMotor.set(1);
    	
    		if(Robot.oi.getSensorSS().isTiltingZneg()){
    			leftMotor.set(1);
    			rightMotor.set(0);
    		}
    		if(Robot.oi.getSensorSS().isTiltingZ()){
    			rightMotor.set(1);	
    			leftMotor.set(0);
    		} 		
    	}
    	done = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
