
package net.aisd.martin.frc.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Col32
 */
public class JoystickSystem extends Subsystem
{
	public static JoystickSystem self = new JoystickSystem(RobotMap.Joysticks.joystick);
	
	public Joystick joystick;
	
	private JoystickSystem(int port)
	{
		super("JoystickSystem");
		if(self != null) throw new RuntimeException("Instanciated multiple JoystickSystem's");
		joystick = new Joystick(port);
	}

	protected void initDefaultCommand()
	{
		// None
	}
	
}
