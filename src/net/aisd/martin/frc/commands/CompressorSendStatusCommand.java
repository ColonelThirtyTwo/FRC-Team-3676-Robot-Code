
package net.aisd.martin.frc.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import net.aisd.martin.frc.Subsystems;

/**
 * Sends compressor pressure switch status to the DriverStation and SmartDashboard.
 * The name is "PressureStatus". True = low pressure, false = high pressure
 * @author Colonel Thirty Two
 */
public class CompressorSendStatusCommand extends CommandBase
{
	private static final int dashboardDigitalOut = 1;
	private static final String Key = "PressureStatus";
	
	public CompressorSendStatusCommand()
	{
		super(CompressorSendStatusCommand.class.getName());
		this.requires(Subsystems.compressorsystem);
		this.setInterruptible(true);
		this.setRunWhenDisabled(true);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		boolean pressure = Subsystems.compressorsystem.compressor.getPressureSwitch();
		SmartDashboard.putBoolean(Key, pressure);
		DriverStation.getInstance().setDigitalOut(dashboardDigitalOut, pressure);
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
