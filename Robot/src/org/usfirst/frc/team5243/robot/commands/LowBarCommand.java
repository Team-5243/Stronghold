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
        requires(Robot.oi.getMotorSS());
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
      	if(!Robot.oi.getSensorSS().isTiltingX()){
      		Robot.oi.getMotorSS().getDrive().drive(.5, -Robot.oi.getSensorSS().getGyro().getAngle() * .05);
      	}
      	if(Robot.oi.getSensorSS().isTiltingX()){
      		Robot.oi.getMotorSS().getDrive().drive(.1, -Robot.oi.getSensorSS().getGyro().getAngle() * .05);
      	}
      	Robot.oi.getMotorSS().getDrive().drive(.5, -Robot.oi.getSensorSS().getGyro().getAngle() * .05);

      
    }

	private boolean isTilting() {
		// TODO Auto-generated method stub
		return false;
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
