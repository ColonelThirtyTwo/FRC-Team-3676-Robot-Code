
package net.aisd.martin.frc;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.RobotMap;
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
	public static DriveSystem drivesystem;

	/**
	 * First JoystickSystem subsystem.
	 */
	public static JoystickSystem joystick1system;
	
	/**
	 * Second JoystickSystem subsystem. 
	 */
	public static JoystickSystem joystick2system;
	
	/**
	 * ShooterSystem subsystem.
	 */
	public static ShooterSystem shootersystem;
        
	/**
	 * Compressor subsystem.
	 */
	public static CompressorSystem compressorsystem;

	/**
	 * Bridge Subsystem.
	 */
	public static BridgeSystem bridgesystem;
	
	/**
	 * This function initializes all of the subsystems.
	 */
	public static void init()
	{
		drivesystem = new DriveSystem();
		joystick1system = new JoystickSystem(new Joystick(RobotMap.Input.joystick1));
		joystick2system = new JoystickSystem(new Joystick(RobotMap.Input.joystick2));
		shootersystem = new ShooterSystem();
		compressorsystem = new CompressorSystem();
		bridgesystem = new BridgeSystem();
	}
}
