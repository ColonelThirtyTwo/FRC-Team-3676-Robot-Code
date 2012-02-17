
package net.aisd.martin.frc.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import net.aisd.martin.frc.Subsystems;

/**
 *
 * @author Colonel Thirty Two
 */
public class ArcadePrecisionDriveCommand extends Command
{
	public ArcadePrecisionDriveCommand()
	{
		super(ArcadePrecisionDriveCommand.class.getName());
		setInterruptible(true);
		requires(Subsystems.drivesystem);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Joystick stickCoarse = Subsystems.joystick1system.joystick;
		Joystick stickFine = Subsystems.joystick2system.joystick;
		if(stickFine.getRawButton(5))
			Subsystems.drivesystem.driver.arcadeDrive(stickFine, 4, stickFine, 3);
		else
			Subsystems.drivesystem.driver.arcadeDrive(stickCoarse, 2, stickCoarse, 3);
	}

	protected boolean isFinished()
	{
		return false;
	}

	protected void end()
	{
	}

	protected void interrupted()
	{
	}
	
}
