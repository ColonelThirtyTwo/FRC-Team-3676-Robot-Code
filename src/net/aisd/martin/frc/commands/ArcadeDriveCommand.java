
package net.aisd.martin.frc.commands;

import net.aisd.martin.frc.subsystems.DriveSystem;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import net.aisd.martin.frc.Subsystems;
import net.aisd.martin.frc.subsystems.JoystickSystem;

/**
 * Command to control the DriveSystem using the JoystickSystem. Arcade-style controls.
 * Is interruptible.
 * @author Col32
 */
public class ArcadeDriveCommand extends CommandBase
{
	public ArcadeDriveCommand()
	{
		super(ArcadeDriveCommand.class.getName()); // Corrects name when refactoring
		setInterruptible(true);
		requires(Subsystems.drivesystem);
		requires(Subsystems.joysticksystem);
	}
	
	protected void initialize()
	{
	}

	protected void execute()
	{
		Subsystems.drivesystem.driver.arcadeDrive(Subsystems.joysticksystem.joystick);
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
		Subsystems.drivesystem.driver.stopMotor();
	}
	
}
