
package net.aisd.martin.frc.commands;

import net.aisd.martin.frc.subsystems.DriveSystem;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import net.aisd.martin.frc.subsystems.JoystickSystem;

/**
 *
 * @author Col32
 */
public class JoyDriveCommand extends CommandBase
{
	public JoyDriveCommand()
	{
		super("JoyDriveCommand");
		setInterruptible(true);
		requires(DriveSystem.self);
		requires(JoystickSystem.self);
	}
	
	protected void initialize()
	{
	}

	protected void execute()
	{
		DriveSystem.self.driver.arcadeDrive(JoystickSystem.self.joystick);
	}

	protected boolean isFinished()
	{
		return isTimedOut();
	}

	protected void end()
	{
	}

	protected void interrupted()
	{
		DriveSystem.self.driver.stopMotor();
	}
	
}
