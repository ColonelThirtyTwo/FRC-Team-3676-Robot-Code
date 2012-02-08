
package net.aisd.martin.frc.commands;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import net.aisd.martin.frc.Subsystems;

/**
 * Manipulates the bridge.
 * @author Colonel Thirty Two
 */
public class HIDBridgeManipulatorCommand extends CommandBase
{

	public HIDBridgeManipulatorCommand()
	{
		super(HIDBridgeManipulatorCommand.class.getName());
		this.setInterruptible(true);
		this.requires(Subsystems.bridgesystem);
	}
	

	protected void initialize()
	{
	}

	protected void execute()
	{
		Subsystems.bridgesystem.setArmPower(Subsystems.joysticksystem.joystick.getRawButton(5) ? 0.1 : -0.1);
		Subsystems.bridgesystem.think();
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
