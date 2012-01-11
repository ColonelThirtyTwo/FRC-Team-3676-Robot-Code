
package net.aisd.martin.frc;

import net.aisd.martin.frc.subsystems.*;

/**
 * Container class for Subsystems that we use.
 * Unless otherwise specified, each subsystem is constructed using its default
 * constructor.
 * @author Col32
 */
public final class Subsystems
{
	private Subsystems() {}
	
	/**
	 * DriveSystem subsystem.
	 */
	public static final DriveSystem drivesystem = new DriveSystem();
	
	/**
	 * JoystickSystem subsystem.
	 */
	public static final JoystickSystem joysticksystem = new JoystickSystem();
}
