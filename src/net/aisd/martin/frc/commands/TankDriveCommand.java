
package net.aisd.martin.frc.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import net.aisd.martin.frc.Subsystems;

/**
 * Command to control the DriveSystem using the JoystickSystem. Arcade-style controls.
 * Is interruptible.
 * @author Col32
 */
public class TankDriveCommand extends CommandBase
{
	public TankDriveCommand()
	{
		super(TankDriveCommand.class.getName()); // Corrects name when refactoring
		setInterruptible(true);
		requires(Subsystems.drivesystem);
		requires(Subsystems.joysticksystem);
	}
	
	protected void initialize()
	{
	}

	protected void execute()
	{
		Subsystems.drivesystem.driver.tankDrive(Subsystems.joysticksystem.joystick, 1,
				Subsystems.joysticksystem.joystick, 5);
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
