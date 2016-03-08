package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class LowShoot extends CommandGroup {
	public LowShoot(){
		addSequential(new RetrievalCommand(.5));
		addParallel(new DriveStraight(.5,-.2));
		addSequential(new RetrievalCommand(.6));
		addParallel(new DriveStraight(.5,.3));
	}
}
