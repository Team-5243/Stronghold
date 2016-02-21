package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;
/**
 *
 */
public class LiftCommand extends Command {

	private boolean isFinished;
	private double speed;
	private Compressor c;
	private Solenoid solenoid;
    public LiftCommand(double s) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.oi.getLiftSS());
        speed = s;
        c = new Compressor();
        solenoid = new Solenoid(1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.oi.getLiftSS().raiseArm(solenoid, c);
    	Robot.oi.getLiftSS().extendArm(speed);
    	try {
			wait(0/*placeholder*/);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	isFinished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
