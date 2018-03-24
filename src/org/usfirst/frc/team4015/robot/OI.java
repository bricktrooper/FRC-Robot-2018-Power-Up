package org.usfirst.frc.team4015.robot;

import edu.wpi.first.wpilibj.XboxController;

import org.usfirst.frc.team4015.robot.RobotMap;

/* =============================================================================
 * This class stores the objects that are used to interface with the joysticks
 * and controllers used for controlling the robot.
 * ============================================================================*/
public class OI
{
	public static JoystickDeadzone leftStick = new JoystickDeadzone(RobotMap.leftStickPort);
	public static JoystickDeadzone rightStick = new JoystickDeadzone(RobotMap.rightStickPort);
	public static XboxController gamepad = new XboxController(RobotMap.gamepadPort);
}
