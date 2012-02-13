
package net.aisd.martin.frc.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import net.aisd.martin.frc.Subsystems;

/**
 * Command to control the DriveSystem using the JoystickSystem. Arcade-style controls.
 * Is interruptible.
 * @author Col32
 */
public class ArcadeDriveCommand extends Command
{
	public ArcadeDriveCommand()
	{
		super(ArcadeDriveCommand.class.getName()); // Corrects name when refactoring
		setInterruptible(true);
		requires(Subsystems.drivesystem);
		requires(Subsystems.joystick1system);
	}
	
	protected void initialize()
	{
		System.out.println(ArcadeDriveCommand.class.getName() + " started.");
	}

	protected void execute()
	{
		Joystick stick = Subsystems.joystick1system.joystick;
		Subsystems.drivesystem.driver.arcadeDrive(stick, 2, stick, 1);
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
