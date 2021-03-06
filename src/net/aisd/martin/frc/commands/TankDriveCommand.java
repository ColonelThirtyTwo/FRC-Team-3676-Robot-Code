
package net.aisd.martin.frc.commands;

import edu.wpi.first.wpilibj.command.Command;
import net.aisd.martin.frc.Subsystems;

/**
 * Command to control the DriveSystem using the JoystickSystem. Tank-style controls.
 * Is interruptible.
 * @author Col32
 */
public class TankDriveCommand extends Command
{
	public TankDriveCommand()
	{
		super(TankDriveCommand.class.getName()); // Corrects name when refactoring
		setInterruptible(true);
		requires(Subsystems.drivesystem);
		requires(Subsystems.joystick1system);
	}
	
	protected void initialize()
	{
		System.out.println(TankDriveCommand.class.getName() + " started.");
	}

	protected void execute()
	{
		Subsystems.drivesystem.driver.tankDrive(Subsystems.joystick1system.joystick, 2, Subsystems.joystick1system.joystick, 5);
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
