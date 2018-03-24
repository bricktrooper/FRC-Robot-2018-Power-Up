package org.usfirst.frc.team4015.robot.commands.auto;

import org.usfirst.frc.team4015.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DropCube extends Command
{

	private int target;		// Switch == -1, Scale == 1
	private boolean finish;

	public DropCube(int target)
	{
		this.target = target;
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
		// MOVE WRIST INTO POSITION
		if (target == 1) // SWITCH
		{
			Robot.wrist.resetToBottom();
			Robot.wrist.up();
			Timer.delay(0.5);
			Robot.wrist.stop();
		}
		else if (target == -1) // SCALE
		{
			Robot.wrist.resetToBottom();
			Robot.wrist.up();
			Timer.delay(0.25);
			Robot.wrist.stop();
		}
		
		if (target == -1) // SWITCH
		{
			Robot.drivetrain.drive(0, 1, 0);
			Timer.delay(1);
			Robot.drivetrain.stop();
		}
		else if (target == 1) // SCALE
		{
			Robot.drivetrain.drive(0, 1, 0);
			Timer.delay(1);
			Robot.drivetrain.stop();
		}
		
		Timer.delay(1);
		Robot.claw.open();
		
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