package org.usfirst.frc.team4015.robot.robotModes.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4015.robot.commands.auto.DriveToBaseLine;
import org.usfirst.frc.team4015.robot.commands.Initialize;

/* ===================================================
 * This CommandGroup drives the robot to the baseline
 * in auto.
 * =================================================*/

public class BaseLine extends CommandGroup
{
	// CONSTRUCTOR //
	
	public  BaseLine()
	{
		addSequential(new Initialize());
		addSequential(new DriveToBaseLine());
    }
	
}
