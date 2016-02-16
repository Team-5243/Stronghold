package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.SensorSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LowBarCommand extends Command {
	private boolean fertig = false;
    public LowBarCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
      while(isTilting()){ //drive up the ramp slow to clear lowbar
    	  DriveStraight scapegoat = new DriveStraight((double).5);
    	  scapegoat.execute();
      }
      
      //speed up once lowbar is cleared
      DriveStraight execution = new DriveStraight(1.0,1.0); // seconds,speed
      execution.start();
      fertig=true;
    }

	private boolean isTilting() {
		return Robot.oi.getSensorSS().isTilting();
	}

	// Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return fertig;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
