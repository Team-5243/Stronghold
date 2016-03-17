package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
	
/**
 * Uses vision processing to center the robot
 */
public class CenterTower extends Command {

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {

		centerTower();

	}

	private void centerTower() {
		double speed = (Robot.oi.getCamera().distanceToCenterTower() * .001) + .2;
		Robot.oi.getMotorSS().setLeft(speed);
		Robot.oi.getMotorSS().setRight(-speed);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Robot.oi.getCamera().isTowerCentered();
	}

	@Override
	protected void end() {
		Robot.oi.getMotorSS().setAll(0);

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}
}
