package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoatCommand extends CommandGroup {
	public MoatCommand(){
		addSequential(new DriveStraight(2,.8));
	}
}
