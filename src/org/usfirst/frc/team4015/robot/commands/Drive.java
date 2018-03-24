package org.usfirst.frc.team4015.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4015.robot.OI;
import org.usfirst.frc.team4015.robot.Robot;

/* ===================================================
 * This command drives the robot with one or two 
 * joysticks on a mecanum chassis.
 * =================================================*/

public class Drive extends Command
{
	public Drive()
	{
		requires(Robot.drivetrain);
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
		// DUAL STICK //
		Robot.drivetrain.drive(OI.rightStick.X(), (-1*OI.leftStick.Y()), OI.rightStick.Z());
		
		// SINGLE STICK //
		// Robot.drivetrain.drive(OI.rightStick.getX(), (-1*OI.rightStick.getY()), OI.rightStick.getZ());
		
		Timer.delay(0.05);  // motor update time
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
