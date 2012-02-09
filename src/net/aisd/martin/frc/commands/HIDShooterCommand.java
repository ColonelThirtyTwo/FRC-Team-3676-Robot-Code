
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
		requires(Subsystems.compressorsystem);
	}
	
	protected void initialize()
	{
	}

	protected void execute()
	{
		Joystick joy = Subsystems.joysticksystem.joystick;
		double power;
		if(joy.getRawButton(1))
			power = 0.25;
		else if(joy.getRawButton(2))
			power = 0.5;
		else if(joy.getRawButton(3))
			power = 0.75;
		else if(joy.getRawButton(4))
			power = 1;
		else
			power = 0;
		if(joy.getRawButton(6))
			Subsystems.shootersystem.shoot();
		
		Subsystems.shootersystem.setSpinning(power);
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
