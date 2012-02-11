
package net.aisd.martin.frc.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 * TODO: REMOVE THIS. Joysticks do not make good subsystems. Multiple commands
 * require it. A better idea would be to make a subsystem for each button/axis.
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
		this(new Joystick(RobotMap.Input.joystick1));
	}

	/// No default command
	protected void initDefaultCommand()
	{
	}

}
