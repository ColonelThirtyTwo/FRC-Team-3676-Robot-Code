
package net.aisd.martin.frc.commands.movement;

import edu.wpi.first.wpilibj.command.Command;
import net.aisd.martin.frc.Subsystems;

/**
 * Moves forward with a specified power.
 * @author Colonel Thirty Two
 */
public class ForwardCommand extends Command
{
	private final double power;

	public ForwardCommand(double power, double timeout)
	{
		super(ForwardCommand.class.getName(), timeout);
		this.requires(Subsystems.drivesystem);
		this.power = power;
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Subsystems.drivesystem.driver.drive(power, 0);
	}

	protected boolean isFinished()
	{
		return this.isTimedOut();
	}

	protected void end()
	{
	}

	protected void interrupted()
	{
	}
}
