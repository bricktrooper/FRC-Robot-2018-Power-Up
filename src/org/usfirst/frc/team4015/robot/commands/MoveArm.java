package org.usfirst.frc.team4015.robot.commands;
	
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4015.robot.Robot;
import org.usfirst.frc.team4015.robot.OI;

/* ===================================================
 * This command allows for control of the arm.
 * =================================================*/

public class MoveArm extends Command
{
	public MoveArm()
	{
		requires(Robot.arm);
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
		if (OI.gamepad.getY(Hand.kLeft) > 0.5 || OI.rightStick.getRawButton(6))
		{
			Robot.arm.down();
		} 
		else if (OI.gamepad.getY(Hand.kLeft) < -0.5 || OI.rightStick.getRawButton(4))
		{
			Robot.arm.up();
		}
		else
		{
			Robot.arm.stop();
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
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
		Robot.arm.stop();
	}
}
