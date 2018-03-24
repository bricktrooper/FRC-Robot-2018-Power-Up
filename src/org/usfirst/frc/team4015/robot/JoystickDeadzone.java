package org.usfirst.frc.team4015.robot;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickDeadzone extends Joystick
{
	public JoystickDeadzone(int port)
	{
		super(port);
	}

	public double X()
	{
		double val = super.getX();
		
		if ((val <= 0.3 && val >= 0) || (val < 0 && val >= -0.3))
		{
			return 0;
		}
		
		return val;
	}

	public double Y()
	{
		double val = super.getY();
		
		if ((val <= 0.3 && val >= 0) || (val < 0 && val >= -0.3))
		{
			return 0;
		}
		
		return val;
	}

	public double Z()
	{
		double val = super.getZ();
		
		if ((val <= 0.3 && val >= 0) || (val < 0 && val >= -0.3))
		{
			return 0;
		}
		
		return val;
	}

}
