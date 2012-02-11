
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
		System.out.println(HIDBridgeManipulatorCommand.class.getName() + " started.");
	}

	protected void execute()
	{
		// Scale negative values.
		double power = Subsystems.joystick2system.joystick.getRawAxis(2);
		if(power <= 0)
			power *= 0.5;
		
		Subsystems.bridgesystem.setArmPower(power);
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
