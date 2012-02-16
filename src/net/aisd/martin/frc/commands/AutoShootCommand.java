
package net.aisd.martin.frc.commands;

import edu.wpi.first.wpilibj.command.Command;
import net.aisd.martin.frc.Subsystems;

/**
 * Autonomous command to shoot hoops in place.
 * @author Colonel Thirty Two
 */
public class AutoShootCommand extends Command
{
	/// Spin power
	private static final double SpinPower = 1.0;
	
	/// Amount of balls remaining.
	private int ballsRemaining = 3;
	
	public AutoShootCommand()
	{
		super(AutoShootCommand.class.getName());
		this.requires(Subsystems.shootersystem);
	}
	
	protected void initialize()
	{
	}

	protected void execute()
	{
		Subsystems.shootersystem.setSpinning(SpinPower);
		if(ballsRemaining == 0) return;
		if(Subsystems.shootersystem.shoot())
			ballsRemaining--;
	}

	protected boolean isFinished()
	{
		return ballsRemaining == 0;
	}

	protected void end()
	{
		Subsystems.shootersystem.setSpinning(0);
	}

	protected void interrupted()
	{
		Subsystems.shootersystem.setSpinning(0);
	}
	
}
