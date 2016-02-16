package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.ShootingSubsystem;

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
		return Robot.oi.getRetrievalSS().isForwardPosition();
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

	/*
	 * public Shoot() { System.out.println("Shoot Constructor Started");
	 * //requires(Robot.oi.getRetrievalSS());
	 * requires(Robot.oi.getShootingSS()); System.out.println(
	 * "Shoot constructor ended"); }
	 * 
	 * // Called repeatedly when this Command is scheduled to run
	 * 
	 * @Override public void start() { Robot.oi.getShootingSS().spinUp(); try {
	 * wait(2000); } catch (InterruptedException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } //turn doggy door using bobber
	 * Robot.oi.getRetrievalSS().turn(); try { wait(2000); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } Robot.oi.getRetrievalSS().stop();
	 * Robot.oi.getShootingSS().spinDown(); }
	 * 
	 * @Override protected void initialize() { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 * 
	 * @Override protected void execute() { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override protected boolean isFinished() { // TODO Auto-generated method
	 * stub return false; }
	 * 
	 * @Override protected void end() { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override protected void interrupted() { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 * 
	 */
}
