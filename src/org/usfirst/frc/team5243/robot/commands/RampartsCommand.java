package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */





/**
 * WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?
 * 
 * Magic.
 */

public class RampartsCommand extends Command {

	private boolean finished = false;
    public RampartsCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.oi.getMotorSS());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	DriveStraight one = new DriveStraight(1, .3);//assuming its in front of the left ramp
    	one.execute();
    	Wait stawp = new Wait(1);
    	stawp.execute();
    	Turn go = new Turn(35);
    	go.execute();
    	one = new DriveStraight(.5,.3);
    	one.execute();
    	stawp.execute();
    	go = new Turn(-35);
    	go.execute();
    	one = new DriveStraight(1,.3);
    	one.execute();
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
