package org.usfirst.frc.team4015.robot.subsystems;

import org.usfirst.frc.team4015.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMTalonSRX;

/* ===================================================
 * This class controls the arm.  The arm is raised and
 * lowered using two CIM motors, each controlled by a 
 * Talon SRX.
 * =================================================*/

public class Arm extends Subsystem
{
	public PWMTalonSRX armMotors;
	//private DigitalInput topSwitch;
	//private DigitalInput bottomSwitch;
	
	public Arm()
	{
		armMotors = new PWMTalonSRX(RobotMap.armMotors);
		//topSwitch = new DigitalInput(5);
		//bottomSwitch = new DigitalInput(6);
	}
	
	// MOVE ARM UP //
	
	public void up()
	{
		armMotors.set(-0.5);
	}
	
	// MOVE ARM DOWN //
	
	public void down()
	{
		armMotors.set(0.3);
	}
	
	// DIRECT MOTOR CONTROL //
	
	public void move(double speed)
	{
		armMotors.set(speed);
	}
	
	// STOP ARM //
	
	public void stop()
	{
		armMotors.set(0);
	}
	
	/*
	
	// GET TOP SWITCH VALUE //
	
	public boolean getTopSwitch()
	{
		return topSwitch.get();
	}

	// GET BOTTOM SWITCH VALUE //

	public boolean getBottomSwitch()
	{
		return bottomSwitch.get();
	}
	
	*/
	
	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
