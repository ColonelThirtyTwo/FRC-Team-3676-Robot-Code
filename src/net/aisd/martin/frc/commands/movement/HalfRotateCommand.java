
package net.aisd.martin.frc.commands.movement;

import edu.wpi.first.wpilibj.command.Command;
import net.aisd.martin.frc.Subsystems;

/**
 * Does a half-rotation.
 * @author Colonel Thirty Two
 */
public class HalfRotateCommand extends Command
{
	/// Time to run the motors. Since we have no feedback, we need to measure
	// this manually...
	public static final double RotateTime = 1.5;
	
	private char direction;
	
	/**
	 * @param toLeft Go to the left rather than the right.
	 */
	public HalfRotateCommand(boolean toLeft)
	{
		super(HalfRotateCommand.class.getName());
		this.setTimeout(RotateTime);
		this.requires(Subsystems.drivesystem);
		this.setInterruptible(true);
		direction = (char)(toLeft ? -1 : 1);
	}
	
	protected void initialize()
	{
	}

	protected void execute()
	{
		Subsystems.drivesystem.driver.drive(0, direction);
	}

	protected boolean isFinished()
	{
		return this.isTimedOut();
	}

	protected void end()
	{
		Subsystems.drivesystem.driver.stopMotor();
	}

	protected void interrupted()
	{
		Subsystems.drivesystem.driver.stopMotor();
	}
	
}
