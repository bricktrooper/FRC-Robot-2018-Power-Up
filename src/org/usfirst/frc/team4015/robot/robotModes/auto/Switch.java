package org.usfirst.frc.team4015.robot.robotModes.auto;

import org.usfirst.frc.team4015.robot.commands.Initialize;
import org.usfirst.frc.team4015.robot.commands.auto.DriveToBaseLine;
import org.usfirst.frc.team4015.robot.commands.auto.DropCube;
import org.usfirst.frc.team4015.robot.commands.auto.TurnToTarget;
import org.usfirst.frc.team4015.robot.commands.auto.Recover;

import edu.wpi.first.wpilibj.command.CommandGroup;

/* ===================================================
 * CommandGroup for placing cube in SWITCH
 * =================================================*/

public class Switch extends CommandGroup
{
	// CONSTRUCTOR //
	
	public  Switch(int position, char side)
	{	
		addSequential(new Initialize());
		addSequential(new DriveToBaseLine());  // GET TO BASE LINE
		
		if (side == 'L' && position == 1)
		{
			addSequential(new TurnToTarget(-1, 'R'));
		}
		else if (side == 'R' && position == 2)
		{
			addSequential(new TurnToTarget(-1, 'N'));
		}	
		else if (side == 'R' && position == 3)
		{
			addSequential(new TurnToTarget(-1, 'L'));
		}
		
		addSequential(new DropCube(-1));  // DROP CUBE IN SWITCH
		addSequential(new Recover());
    }
	
}