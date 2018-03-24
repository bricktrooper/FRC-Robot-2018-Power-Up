package org.usfirst.frc.team4015.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.GenericHID.Hand;

import org.usfirst.frc.team4015.robot.OI;
import org.usfirst.frc.team4015.robot.Robot;

/* ===================================================
 * This command allows for control of the wrist.
 * =================================================*/

public class MoveWrist extends Command
{	
	public MoveWrist()
	{
		requires(Robot.wrist);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
		
	}
	
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{		
		if (OI.gamepad.getY(Hand.kRight) > 0.5 || OI.leftStick.getRawButtonPressed(3))
		{
			Robot.wrist.down();
		}
		else if (OI.gamepad.getY(Hand.kRight) < -0.5 || OI.leftStick.getRawButtonPressed(5))
		{
			Robot.wrist.up();
		}
		else
		{
			Robot.wrist.stop();
		}		
	}
	
	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end()
	{
		Robot.wrist.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
		Robot.wrist.stop();
	}
}
