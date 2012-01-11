
package net.aisd.martin.frc.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 * Subsystem for a Joystick.
 * @author Col32
 */
public final class JoystickSystem extends Subsystem
{
	
	/**
	 * The joystick that this system uses.
	 * Don't access it unless the command owns the subsystem.
	 */
	public Joystick joystick;
	
	/**
	 * Creates a JoystickSystem with a specified joystick.
	 */
	public JoystickSystem(Joystick stick)
	{
		super(JoystickSystem.class.getName());
		joystick = stick;
	}
	
	/**
	 * Creates a JoystickSystem with a new joystick specified by RobotMap.Joysticks.joystick
	 */
	public JoystickSystem()
	{
		this(new Joystick(RobotMap.Joysticks.joystick));
	}

	/// No default command
	protected void initDefaultCommand()
	{
	}
	
}
