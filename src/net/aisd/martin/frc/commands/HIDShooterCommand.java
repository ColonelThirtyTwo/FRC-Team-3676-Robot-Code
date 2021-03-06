
package net.aisd.martin.frc.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import net.aisd.martin.frc.Subsystems;

/**
 *
 * @author Colonel Thirty Two
 */
public class HIDShooterCommand extends Command
{
	public HIDShooterCommand()
	{
		super(HIDShooterCommand.class.getName());
		setInterruptible(true);
		requires(Subsystems.shootersystem);
	}
	
	protected void initialize()
	{
		System.out.println(HIDShooterCommand.class.getName() + " started.");
	}

	protected void execute()
	{
		Joystick joy = Subsystems.joystick2system.joystick;
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
