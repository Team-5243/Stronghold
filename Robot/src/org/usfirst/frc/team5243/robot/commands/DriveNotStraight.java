package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveNotStraight extends Command {
<<<<<<< 93714487abcb098b35bf8a9eb5be6b048c2c59d4
	private double seconds = 1;
	private double speedthedroog = 1;
	private double degrees = 0;
	public DriveNotStraight() {
		requires(Robot.oi.getMotorSS());
		requires(Robot.oi.getSensorSS());
		
	}
	public DriveNotStraight(double seconds, double speed) {
		requires(Robot.oi.getMotorSS());
		requires(Robot.oi.getSensorSS());
		
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		
	}
=======

	private double speed = 1;
	private double degrees = 0;
	private int milliseconds = 1000;
	
	
    public DriveNotStraight(int millisecs, double speedthedroog) {
        requires(Robot.oi.getMotorSS());
        requires(Robot.oi.getSensorSS());
        milliseconds = millisecs;
        if (speedthedroog > 1) {
        	speedthedroog = 1;
        }
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
>>>>>>> fixed drive straight...?
}
