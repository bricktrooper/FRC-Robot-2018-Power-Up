package org.usfirst.frc.team4015.robot;

/* =============================================================================
 * This class stores the port numbers that the robot hardware is attached to.
 * ============================================================================*/

public class RobotMap
{
	// JOYSTICK / GAMEPAD CONTROLLER USB PORTS //
	
	public static final int leftStickPort = 0;
	public static final int rightStickPort = 1;
	public static final int gamepadPort = 2;
	
	// MECANUM TALON CHANNELS //
	
	public static final int frontLeftMotor = 0;
	public static final int backLeftMotor = 1;
	public static final int frontRightMotor = 2;
	public static final int backRightMotor = 3;
	
	// CLAW PISTON CHANNELS //
	
	public static final int clawPistonLeftChannel = 6;
	public static final int clawPistonRightChannel = 7;
	
	// WINCH //
	
	 public static final int winchMotors = 6;
	
	// ARM //
	
	 public static final int armMotors = 5;
	
	// WRIST //
	
	 public static final int wristMotor = 4;
}
