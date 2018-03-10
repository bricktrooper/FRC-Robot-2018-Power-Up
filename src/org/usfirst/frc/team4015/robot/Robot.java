package org.usfirst.frc.team4015.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CameraServer;


// SUBSYSTEM IMPORTS //

import org.usfirst.frc.team4015.robot.subsystems.Drivetrain;
import org.usfirst.frc.team4015.robot.subsystems.Pneumatics;
import org.usfirst.frc.team4015.robot.subsystems.Claw;
import org.usfirst.frc.team4015.robot.subsystems.Arm;
import org.usfirst.frc.team4015.robot.subsystems.Wrist;
import org.usfirst.frc.team4015.robot.subsystems.Winch;

// ROBOT MODES (COMMAND GROUP) IMPORTS //

import org.usfirst.frc.team4015.robot.robotModes.Teleop;
import org.usfirst.frc.team4015.robot.robotModes.auto.*;

/* =============================================================================
 * The RoboRIO will automatically run the methods in this class depending on
 * which part of the match is being played.
 * ============================================================================*/

public class Robot extends IterativeRobot
{
	// SUBSYSTEM DECLARATION //
	public static SendableChooser autoChooser;
	public static Drivetrain drivetrain;
	public static Pneumatics pneumatics;
	public static Claw claw;
	public static Arm arm;
	public static Wrist wrist;
	public static Winch winch;
	//public static Gyro gyro;
	
	// DECLARE ROBOT MODES (COMMAND GROUPS) //
	
	Command teleop;
	Command auto;
	
	//SendableChooser<Command> chooser = new SendableChooser<>();

	/* ===================================
	 * This function is run when the robot 
	 * is first started up and should be
	 * used for any initialization code.
	 * ==================================*/

	@Override
	public void robotInit()
	{
		// SUBSYSTEM INSTANTIATION //
		/*autoChooser=new SendableChooser();
		autoChooser.addDefault("Switch", object);
		autoChooser.addDefault("Baseline", object);*/
		CameraServer.getInstance().startAutomaticCapture();
		drivetrain = new Drivetrain();
		drivetrain.newMecanumDrive();
		
		pneumatics = new Pneumatics();
		
		claw = new Claw();
		arm = new Arm();
		wrist = new Wrist();
		winch = new Winch();
		//gyro=new AnalogGyro();
		// INSTANTIATE ROBOT MODES (COMMAND GROUPS) //
		
		teleop = new Teleop();
		//auto = new Auto();
		
		/*
		chooser.addDefault("Default Auto", new ExampleCommand());
		chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
		*/
		
		// CAMERA //
		
		
	}

	/* =================================================
	 * This function is called once each time the robot 
	 * enters Disabled mode. You can use it to reset any 
	 * subsystem information you want to clear when the 
	 * robot is disabled.
	 * ================================================*/
	
	@Override
	public void disabledInit()
	{

	}

	@Override
	public void disabledPeriodic()
	{
		// Run Scheduler to manage Commands / CommandGroups
		Scheduler.getInstance().run();
	}

	/* =========================================================================
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 * ========================================================================*/
	
	@Override
	public void autonomousInit()
	{
		String plateLocations;
		//SmartDashboard.putString("DB/String 0", "AutoSelector");
		System.out.println("hiiiii");
		plateLocations = DriverStation.getInstance().getGameSpecificMessage();
                
		//autonomousCommand = chooser.getSelected();
		
		String selectedAuto = SmartDashboard.getString("DB/String 0", "baseline1");

		System.out.println(selectedAuto.substring(0, selectedAuto.length()-1));
		
		if (selectedAuto.substring(0, selectedAuto.length()-1).equalsIgnoreCase("Switch"))
		{
			System.out.println("hjedhu");
			
			if (plateLocations.length() > 0)
			{
				if (plateLocations.charAt(0) == 'L')
				{
					if (selectedAuto.charAt(selectedAuto.length() - 1) == '1')
					{
						
						auto = new Switch(1, 'L');
						System.out.println("Switch 1L ");
					}
					else if (selectedAuto.charAt(selectedAuto.length() - 1) == '2')
					{
						auto = new Switch(2, 'L');
						System.out.println("Switch 2L");
					}
					else if (selectedAuto.charAt(selectedAuto.length() - 1) == '3')
					{
						auto = new Switch(3, 'L');
						System.out.println("Switch 3L");
					}
				}
				else if (plateLocations.charAt(0) == 'R')
				{
					if (selectedAuto.charAt(selectedAuto.length() - 1) == '1')
					{
						auto = new Switch(1, 'R');
						System.out.println("Switch 1R");
					}
					else if (selectedAuto.charAt(selectedAuto.length() - 1) == '2')
					{
						auto = new Switch(2, 'R');
						System.out.println("Switch 2R ");
					}
					else if (selectedAuto.charAt(selectedAuto.length() - 1) == '3')
					{
						auto = new Switch(3, 'R');
						System.out.println("Switch 3R");
					}
				}
			}
		}
		else if (selectedAuto.substring(0, selectedAuto.length()).equalsIgnoreCase("Scale"))
		{
			if (plateLocations.length() > 0)
			{
				if (plateLocations.charAt(1) == 'L')
				{
					if (selectedAuto.charAt(selectedAuto.length() - 1) == '1')
					{
						auto = new Scale(1, 'L');
					}
					else if (selectedAuto.charAt(selectedAuto.length() - 1) == '2')
					{
						auto = new Scale(2, 'L');
					}
					else if (selectedAuto.charAt(selectedAuto.length() - 1) == '3')
					{
						auto = new Scale(3, 'L');
					}
				}
				else if (plateLocations.charAt(1) == 'R')
				{
					if (selectedAuto.charAt(selectedAuto.length() - 1) == '1')
					{
						auto = new Scale(1, 'R');
					}
					else if (selectedAuto.charAt(selectedAuto.length() - 1) == '2')
					{
						auto = new Scale(2, 'R');
					}
					else if (selectedAuto.charAt(selectedAuto.length() - 1) == '3')
					{
						auto = new Scale(3, 'R');
					}
				}
			}
		}
		else if (selectedAuto.substring(0, selectedAuto.length()-1).equalsIgnoreCase("BaseLine"))
		{
		
			/*if (selectedAuto.charAt(selectedAuto.length() - 1) == '1')
			{
				long startTime = System.nanoTime();
				while((System.nanoTime() - startTime)<2000000000) {
					
					System.out.println("3b");
					//auto = new BaseLine(1);
					
					Robot.drivetrain.chassis.driveCartesian(0.5, 0, 0);
				
					}
				Robot.drivetrain.chassis.stopMotor();
				
			}
			else if (selectedAuto.charAt(selectedAuto.length() - 1) == '2')
			{
				/*while((double)(System.nanoTime() - startTime)<8000000000.0) {
					
					System.out.println("3b");
					//auto = new BaseLine(1);
					
					//Robot.drivetrain.chassis.driveCartesian(0.5, 0, 0);
				
					}
				while((double)(System.nanoTime() - startTime)<3000000000.0) {
					
					System.out.println("3b");
					//auto = new BaseLine(1);
					
					Robot.drivetrain.chassis.driveCartesian(0, 0.5, 0);
				
					}
				while((System.nanoTime() - startTime)<2000000000) {
					
					System.out.println("3b");
					//auto = new BaseLine(1);
					
					Robot.drivetrain.chassis.driveCartesian(0.5, 0, 0);
				
					}
				
			}
			else if (selectedAuto.charAt(selectedAuto.length() - 1) == '3')
			{
				System.out.println("3b");
				//auto = new BaseLine(3);
				long startTime = System.nanoTime();
				while((System.nanoTime() - startTime)<2000000000) {
					
					System.out.println("3b");
					//auto = new BaseLine(1);
					
					Robot.drivetrain.chassis.driveCartesian(0.5, 0, 0);
				
					}
				Robot.drivetrain.chassis.stopMotor();
			}*/
			System.out.println("3b");
			//auto = new BaseLine(3);
			long startTime = System.nanoTime();
			while((System.nanoTime() - startTime)<2000000000) {
				
				System.out.println("3b");
				//auto = new BaseLine(1);
				
				Robot.drivetrain.drive(0, 0.5, 0);
			
				}
			Robot.drivetrain.chassis.stopMotor();
		}
		/*this.drivetrain.frontLeft.set(1);
		this.drivetrain.backLeft.set(-1);
		this.drivetrain.frontRight.set(-1);
		this.drivetrain.backRight.set(1);*/
		
		
		
		/*
		 switch (selectedAuto)
		 {
		 	case "Switch1":
		 		
		 		if (plateLocations.length() > 0)
		        {
				  if(plateLocations.charAt(0) == 'L')
				  {
					auto = new Switch1('L');
				  }
				  else if (plateLocations.charAt(0) == 'R')
				  {
					auto = new Switch1('R');
				  }
				}
		 		
		 		break;
		 		
		 	case "Scale1":
		 		
		 		if (plateLocations.length() > 0)
		        {
				  if(plateLocations.charAt(1) == 'L')
				  {
					auto = new Scale1('L');
				  }
				  else if (plateLocations.charAt(1) == 'R')
				  {
					auto = new Scale1('R');
				  }
				}
		 		
		 		break;
		 		
		 	case "AutoSpinToWin":
		 		auto = new AutoSpinToWin();
		 		break;
		 		
		 	case "BaseLine1":
		 		auto = new BaseLine(1);
		 		break;
		 		
		 	case "BaseLine2":
		 		auto = new BaseLine(2);
		 		break;
		 		
		 	case "BaseLine3":
		 		auto = new BaseLine(3);
		 		break;
		 		
		 	default:
		 		auto = new BaseLine(0);
		 		break;
		 }
		 */
		 
		// START AUTONOMOUS COMMAND GROUP //
		
		if (auto != null)
		{
			auto.start();
		}
	}

	/* ======================================================
	 * This function is called periodically during autonomous
	 * =====================================================*/
	
	@Override
	public void autonomousPeriodic()
	{
		
	}

	@Override
	public void teleopInit()
	{
		/* This makes sure that the autonomous stops
		 * running when teleop starts running. If you
		 * want the autonomous to continue until 
		 * interrupted by another command, remove 
		 * this line or comment it out.
		 */
		
		// STOP AUTONOMOUS COMMAND GROUP //
		
		if (auto != null)
		{
			auto.cancel();
		}
		
		// START TELEOP COMMAND GROUP //
		
		if (teleop != null)
		{
			teleop.start();
		}
	}

	/* ===================================================
	 * This function is called periodically during teleop
	 * ==================================================*/
	
	@Override
	public void teleopPeriodic()
	{
		// Run Scheduler to manage Commands / CommandGroups
		Scheduler.getInstance().run();
	}

	/* =====================================================
	 * This function is called periodically during test mode
	 * ====================================================*/
	@Override
	public void testPeriodic()
	{
		LiveWindow.run();
	}
}
