package org.usfirst.frc.team4015.robot.subsystems;

import org.usfirst.frc.team4015.robot.RobotMap;
import org.usfirst.frc.team4015.robot.commands.Drive;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/* ===================================================
 * This class contains the methods required to drive 
 * the robot with a mecanum drive chassis.  The drive 
 * method can be configured to drive the robot in tank
 * drive mode as well.  The wheels are powered by CIM
 * motors that are each controlled using a Talon SR.
 * =================================================*/

public class Drivetrain extends Subsystem
{	
	public Talon frontLeft;
	public Talon frontRight;
	public Talon backLeft;
	public Talon backRight;
	
	public MecanumDrive chassis;
	
	// DEFAULT CONSTRUCTOR //
	
	public Drivetrain()
	{
		
	}
	
	// CREATE MECANUM DRIVE CHASSIS //
	
	public void newMecanumDrive()
	{
		frontLeft = new Talon(RobotMap.frontLeftMotor);
		frontRight = new Talon(RobotMap.frontRightMotor);
		backLeft = new Talon(RobotMap.backLeftMotor);
		backRight = new Talon(RobotMap.backRightMotor);
		chassis = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
	}
	
	/* ======================================
	 *                DRIVE
	 * ======================================                
	 * ------------MECANUM DRIVE-------------
	 * xSpeed ---> 1.0 = 100% right
	 * xSpeed ---> -1.0 = 100% left
	 * ySpeed ---> 1.0 = 100% forward
	 * ySpeed ---> -1.0 = 100% backward
	 * rotation ---> 1.0 = 100% CW
	 * rotation ---> -1.0 = 100% CCW
	 * 
	 *---------------TANK DRIVE-------------
	 * Same as mecanum but make xSpeed = 0.0
	 * =====================================*/
	
	public void drive(double xSpeed, double ySpeed, double rotation)
	{
		chassis.driveCartesian(xSpeed, ySpeed, rotation);
	}
	
	public void stop()
	{
		drive(0, 0, 0);
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		 setDefaultCommand(new Drive());
	}
}
