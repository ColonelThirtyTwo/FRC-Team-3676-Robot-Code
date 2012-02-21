
package net.aisd.martin.frc.commands;

import edu.wpi.first.wpilibj.command.Command;
import net.aisd.martin.frc.Subsystems;

/**
 * Spins up the shooter motors
 * @author Colonel Thirty Two
 */
public class SpinupCommand extends Command
{

	public SpinupCommand(double timeout)
	{
		super(SpinupCommand.class.getName(), timeout);
		this.requires(Subsystems.shootersystem);
		this.setInterruptible(true);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Subsystems.shootersystem.setSpinning(1);
		Subsystems.shootersystem.think();
	}

	protected boolean isFinished()
	{
		return isTimedOut();
	}

	protected void end()
	{
		Subsystems.shootersystem.setSpinning(0);
		Subsystems.shootersystem.think();
	}

	protected void interrupted()
	{
		Subsystems.shootersystem.setSpinning(0);
		Subsystems.shootersystem.think();
	}
	
}
