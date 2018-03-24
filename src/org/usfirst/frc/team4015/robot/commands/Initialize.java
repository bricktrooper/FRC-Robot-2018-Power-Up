package org.usfirst.frc.team4015.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4015.robot.Robot;

/* ===================================================
 * Robot startup routine
 * =================================================*/

public class Initialize extends Command
{
	private boolean finish;
	
	public Initialize()
	{
		requires(Robot.drivetrain);
		requires(Robot.arm);
		requires(Robot.claw);
		requires(Robot.wrist);
		requires(Robot.winch);
		
		finish = false;
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
		Robot.claw.close();
		Robot.drivetrain.stop();
		Robot.arm.stop();
		Robot.wrist.resetToTop();
		Robot.winch.stop();
		
		finish = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished()
	{
		return finish;
	}

	// Called once after isFinished returns true
	@Override
	protected void end()
	{
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
		
	}
}
