
package net.aisd.martin.frc.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
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
	private int ballsRemaining = 2;
	
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
		while(ballsRemaining > 0){
			Subsystems.shootersystem.setSpinning(1);
			boolean check = Subsystems.shootersystem.shoot();
			Subsystems.shootersystem.think();
			if(check){
				ballsRemaining--;
			}
		}
	}

	protected boolean isFinished()
	{
		return ballsRemaining == 0;
	}

	protected void end()
	{
		Subsystems.shootersystem.topmotor.set(1);
		Subsystems.shootersystem.bottommotor.set(1);	}

	protected void interrupted()
	{
		Subsystems.shootersystem.topmotor.set(1);
		Subsystems.shootersystem.bottommotor.set(1);
	}
	
}
