package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootCommand extends Command {
	private double speed;
	private boolean first;
	private long startTime;
	private final int deltaT = 2;
	
	public ShootCommand(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.speed = speed;
    	first = true;
    }
	public ShootCommand(boolean IDONOTHINGHERE){
		this.speed = RobotMap.std.getNumber("ShootSpeed", -1);
	}
	public ShootCommand(int ItooDonothingHeresoIamAscrubWithmyTerriblecamelCasing){
		this.speed = RobotMap.std.getNumber("ShootSpeed",-1)/2;
	}
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (first){
    		first = false;
    		startTime = System.currentTimeMillis();
    	}
    	Robot.oi.getShootingSS().spinUp(speed);
    	Robot.oi.getShootingSS().spinServo();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (System.currentTimeMillis()-startTime)/1000 > deltaT;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.oi.getShootingSS().spinDown();
    	first =true;
    	}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
