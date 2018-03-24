package org.usfirst.frc.team4015.robot.robotModes.auto;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team4015.robot.commands.Initialize;
import org.usfirst.frc.team4015.robot.commands.auto.DriveToBaseLine;
import org.usfirst.frc.team4015.robot.commands.auto.DriveToScale;
import org.usfirst.frc.team4015.robot.commands.auto.DropCube;
import org.usfirst.frc.team4015.robot.commands.auto.Recover;
import org.usfirst.frc.team4015.robot.commands.auto.TurnToTarget;

public class Scale extends CommandGroup
{
	// CONSTRUCTOR //

	public Scale(int position, char side)
	{
		addSequential(new Initialize());
		addSequential(new DriveToBaseLine()); // GET TO BASE LINE
		
		if (side == 'L' && position == 1)
		{
			addSequential(new DriveToScale());  // GET TO SCALE FROM BASE LINE
			addSequential(new TurnToTarget(1, 'R'));
		}
		else if (side == 'R' && position == 3)
		{
			addSequential(new DriveToScale());  // GET TO SCALE FROM BASE LINE
			addSequential(new TurnToTarget(1, 'L'));
		}
		
		addSequential(new DropCube(1));  // DROP CUBE IN SCALE
		addSequential(new Recover());
	}

}