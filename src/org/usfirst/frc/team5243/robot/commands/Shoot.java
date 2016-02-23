package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Shoot extends Command {

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		Robot.oi.getRetrievalSS().turn();
		

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		Robot.oi.getRetrievalSS().stop();
		Robot.oi.getShootingSS().spinDown();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}


}
