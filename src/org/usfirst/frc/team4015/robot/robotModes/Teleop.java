package org.usfirst.frc.team4015.robot.robotModes;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team4015.robot.commands.Drive;
import org.usfirst.frc.team4015.robot.commands.MoveClaw;
import org.usfirst.frc.team4015.robot.commands.ToggleCompressor;
import org.usfirst.frc.team4015.robot.commands.MoveArm;
import org.usfirst.frc.team4015.robot.commands.MoveWrist;
import org.usfirst.frc.team4015.robot.commands.Climb;

/* ===================================================
 * This CommandGroup enables control of the drivetrain,
 * claw, arm, wrist, winch, and compressor during teleop mode.
 * To leave the compressor on automatic control, 
 * remove the line "addParallel(new ToggleCompressor());"
 * =================================================*/

public class Teleop extends CommandGroup
{
	// CONSTRUCTOR //
	
	public  Teleop()
	{
    	addParallel(new Drive());
    	addParallel(new MoveClaw());
    	addParallel(new MoveArm());
    	addParallel(new MoveWrist());
    	addParallel(new Climb());
    	//addParallel(new ToggleCompressor());
    }
	
}
