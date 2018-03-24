package org.usfirst.frc.team4015.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4015.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

/* ===================================================
 * This command drives the robot in a straight line
 * to the baseline in the autonomous period.
 * The compressor will run in preparation for teleop.
 * =================================================*/

public class DriveToBaseLine extends Command
{
	private boolean finish;

	public DriveToBaseLine()
	{
		requires(Robot.drivetrain);
		finish = false;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
		Robot.drivetrain.stop();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{
		Robot.drivetrain.drive(0, 0.5, 0);
		Timer.delay(2);
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
		Robot.drivetrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
		Robot.drivetrain.stop();
	}
}
