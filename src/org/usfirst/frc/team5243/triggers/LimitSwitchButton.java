package org.usfirst.frc.team5243.triggers;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;

public class LimitSwitchButton extends Button {

	@Override
	public boolean get() {
		// TODO Auto-generated method stub
		return Robot.oi.getRetrievalSS().getLimit1().get()&&Robot.oi.getRetrievalSS().getLimit2().get();
	}

}
