package org.usfirst.frc.team4015.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4015.robot.RobotMap;
import org.usfirst.frc.team4015.robot.subsystems.pneumaticsControl.Piston;

/* ===================================================
 * This class contains the methods/objects required to 
 * control claw.  The claw piston is controlled using a
 * FESTO double solenoid.
 * =================================================*/

public class Claw extends Subsystem
{
	public Piston clawPiston;
	
	// CONSTRUCTOR //
	
	public Claw()
	{
		clawPiston = new Piston(RobotMap.clawPistonLeftChannel, RobotMap.clawPistonRightChannel);
	}
	
	public void open()
	{
		clawPiston.extend();
	}
	
	public void close()
	{
		clawPiston.retract();
	}
	
	public void toggle()
	{
		clawPiston.toggle();
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}