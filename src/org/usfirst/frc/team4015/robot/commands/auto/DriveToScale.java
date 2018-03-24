package org.usfirst.frc.team4015.robot.commands.auto;

import org.usfirst.frc.team4015.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveToScale extends Command
{
	//char side;
	//int position;
	boolean finish;

	public DriveToScale()
	{
		//this.side = side;
		//this.position = position;
		finish = false;
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
		Robot.drivetrain.stop();
	}

	@Override
	protected void execute()
	{
		Robot.drivetrain.drive(0, 1, 0);
		Timer.delay(3);
		Robot.drivetrain.stop();
		
		finish = true;
	}

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
