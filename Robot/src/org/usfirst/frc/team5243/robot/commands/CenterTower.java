package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
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
		Robot.oi.getMotorSS().getBackLeft().set(speed);
		Robot.oi.getMotorSS().getFrontLeft().set(speed);
		Robot.oi.getMotorSS().getFrontRight().set(-speed);
		Robot.oi.getMotorSS().getBackRight().set(-speed);
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
