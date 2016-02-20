package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowBarCommandGroup extends CommandGroup {
    
    public  LowBarCommandGroup() {
        
    	Robot.oi.getSensorSS().getGyro().reset();
    	while(!Robot.oi.getSensorSS().isTiltingX()){
    		Robot.oi.getMotorSS().getDrive().drive(.3, -Robot.oi.getSensorSS().getGyro().getAngle() * .05);
    	}
    	while(Robot.oi.getSensorSS().isTiltingX()){
    		Robot.oi.getMotorSS().getDrive().drive(.1, -Robot.oi.getSensorSS().getGyro().getAngle() * .05);
    	}
    	Robot.oi.getMotorSS().getDrive().drive(.5, -Robot.oi.getSensorSS().getGyro().getAngle() * .05);

    }
}
