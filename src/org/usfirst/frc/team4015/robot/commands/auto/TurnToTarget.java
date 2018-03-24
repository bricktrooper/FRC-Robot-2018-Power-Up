package org.usfirst.frc.team4015.robot.commands.auto;

import org.usfirst.frc.team4015.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class TurnToTarget extends Command
{
	private int target; // -1 == Switch, 1 == Scale
	private char turn; // R == right, L == left, N == no turn
	private boolean finish;

	public TurnToTarget(int target, char turn)
	{
		this.target = target;
		this.turn = turn;
		finish = false;
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
		
	}
	
	@Override
	protected void execute()
	{
		// TURN TO SWITCH/SCALE AS NECESSARY
		if (turn == 'L')
		{
			Robot.drivetrain.drive(0, 0, -1);
			Timer.delay(0);// TODO: TURNING TIME 1/4 TURN
			Robot.drivetrain.stop();
		}
		else if (turn == 'R')
		{
			Robot.drivetrain.drive(0, 0, 1);
			Timer.delay(0);// TODO: TURNING TIME 1/4 TURN
			Robot.drivetrain.stop();
		}
		
		// BACK ROBOT UP TO RAISE ARM
		Robot.drivetrain.drive(0, -1, 0);
		Timer.delay(0.5); // Back up to raise arm
		Robot.drivetrain.stop();
		
		// RAISE ARM TO APPROPRIATE HEIGHT
		
		if (target == -1) // Switch
		{
			Robot.arm.up();
			Timer.delay(0); // TODO Arm raise time SWITCH
			Robot.arm.stop();
			Robot.wrist.resetToBottom();
		}
		else if (target == 1) // Scale
		{
			Robot.arm.up();
			Timer.delay(0); // TODO Arm raise time SWITCH
			Robot.arm.stop();
			
			Robot.wrist.resetToBottom();
			
			Robot.arm.up();
			Timer.delay(0); // TODO Arm raise time to SCALE from SWITCH height
			Robot.arm.stop();
		}
		
		Timer.delay(1);
		
		finish = true;
	}

	@Override
	protected boolean isFinished()
	{
		// TODO Auto-generated method stub
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
