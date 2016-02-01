package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.subsystems.Shooting;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Shoot extends Command {
	public boolean finished = false;
	public Shooting bob = new Shooting();
	//public Retrival bobber = new Retrival();
    public Shoot() {
        // Use requires() here to declare subsystem dependencies
        requires(Shooting);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	bob.spinUp();
    	try {
			wait(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//turn doggy door using bobber
    	try {
			wait(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	bob.spinDown();
    	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
