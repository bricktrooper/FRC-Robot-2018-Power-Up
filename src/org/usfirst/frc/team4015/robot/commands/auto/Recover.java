package org.usfirst.frc.team4015.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team4015.robot.Robot;

/* ===================================================
 * Recover after completing auto
 * =================================================*/

public class Recover extends Command
{
	private boolean finish;
	
	public Recover()
	{
		// Use requires() here to declare subsystem dependencies
		//requires(Robot.exampleSubsystem);
		
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
		// MOVE WRIST UP TO SAFE POSITION
		Robot.wrist.resetToTop();
		
		// BACK UP
		Robot.drivetrain.drive(0, -1, 0);
		Timer.delay(1);
		Robot.drivetrain.stop();
		
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
