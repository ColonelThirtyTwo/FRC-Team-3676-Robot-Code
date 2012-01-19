
package net.aisd.martin.frc.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import net.aisd.martin.frc.Subsystems;

/**
 *
 * @author Colonel Thirty Two
 */
public class HIDShooterCommand extends CommandBase
{
	public HIDShooterCommand()
	{
		super(HIDShooterCommand.class.getName());
		setInterruptible(true);
		requires(Subsystems.shootersystem);
	}
	
	protected void initialize()
	{
		setInterruptible(true);
	}

	protected void execute()
	{
		Joystick joy = Subsystems.joysticksystem.joystick;
		double power = joy.getRawAxis(3);
		if(power < 0.1) power = 0;
		Subsystems.shootersystem.setSpinning(power*0.8);
		Subsystems.shootersystem.think();
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
