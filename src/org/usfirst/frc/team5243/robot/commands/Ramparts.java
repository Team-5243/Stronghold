package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */




/**
 * WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?
 * WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?
 * WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?
 * WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?
 * WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?
 * WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?
 * WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?
 * WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?
 * WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?
 * WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?WHATISHAPPENING!??!?
 * 
 * 
 * 
 * 
 * Magic.
 */
public class Ramparts extends Command {
	
	private boolean stageOne = true;
	private boolean stageTwo = true;
	private boolean stageThree = true;
	private boolean stageFour = true;
	
	private boolean first = true;
	
	private boolean finished = false;
    public Ramparts() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.oi.getMotorSS());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (first) {
    		first = false;
    		Robot.oi.getMotorSS().setRunning(true);
    	}
    	
    	if (stageOne) {
    		stageOne();
    	}
    	else if (stageTwo) {
    		stageTwo();
    	}
    	else if (stageThree) {
    		stageThree();
    	}
    	else if (stageFour) {
    		stageFour();
    	}
    	
    	
    	
    	if(!finished){
    		DriveStraight go = new DriveStraight(1, .5);
    		go.execute();
    		Turn right = new Turn(.3, 30);
    		right.execute();
    		Turn left = new Turn(.3,30);
    		left.execute();
    		go.execute();
    	}
    	/*while(Robot.oi.getSensorSS().getY() < 1000000000/*PLACEHOLDER*//* && Robot.oi.getSensorSS().getY() > 0){
    		//drive up to ramparts
    		DriveStraight exeggcute = new DriveStraight();
    		exeggcute.execute();
    	}
    	//turn right onto ramparts
    	Robot.oi.getMotorSS().getFrontRight().set(0);
    	Robot.oi.getMotorSS().getBackRight().set(0);
    	//placeholder, need to test time needed to turn right
    	try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//wait for right side to catch up
    	Robot.oi.getMotorSS().getFrontRight().set(1);
    	Robot.oi.getMotorSS().getBackRight().set(1);
    	Robot.oi.getMotorSS().getFrontLeft().set(0);
    	Robot.oi.getMotorSS().getBackLeft().set(0);
    	///placeholder, need to test time needed to straighten out
    	try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//drive off ramparts
    	DriveStraight theKnightUsed = new DriveStraight(1,1); // speed,seconds
    	theKnightUsed.execute();
    	//placeholder, need to test time needed to drive off ramparts
    	finished = true;*/
    }
    
    private void stageOne() {
    	Robot.oi.getMotorSS().getDrive().drive(1,  Robot.oi.getSensorSS().getAngle()*0.01);
    	if (Math.abs(Robot.oi.getSensorSS().getAngle()) > 10) {
    		stageOne = false;
    	}
    }
    
    private void stageTwo() {
    	if (!(Math.abs(Robot.oi.getSensorSS().getAngle()) < 30)) {
    		Robot.oi.getMotorSS().getDrive().drive(1, (Robot.oi.getSensorSS().getAngle()*0.01)-180);
    	}
    	else
    		stageTwo = false;
    }
    
    private void stageThree() {
    	if ((Math.abs(Robot.oi.getSensorSS().getAngle())) < 45) {
    		Robot.oi.getMotorSS().getDrive().drive(1,  (Robot.oi.getSensorSS().getAngle() * 0.01) - 180);
    	}
    	else
    		stageThree = false;
    }
    
    private void stageFour() {
    	if (!Robot.oi.getSensorSS().isTiltingY() && !Robot.oi.getSensorSS().isTiltingYneg()) {
    		stageFour = false;
    	}
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