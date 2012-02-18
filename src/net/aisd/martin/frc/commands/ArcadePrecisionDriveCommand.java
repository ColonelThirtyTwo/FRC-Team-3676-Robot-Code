
package net.aisd.martin.frc.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import net.aisd.martin.frc.Subsystems;

/**
 *
 * @author Colonel Thirty Two
 */
public class ArcadePrecisionDriveCommand extends Command
{
	public ArcadePrecisionDriveCommand()
	{
		super(ArcadePrecisionDriveCommand.class.getName());
		setInterruptible(true);
		requires(Subsystems.drivesystem);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Joystick stickCoarse = Subsystems.joystick1system.joystick;
		Joystick stickFine = Subsystems.joystick2system.joystick;
		if(stickFine.getRawButton(5)){
                    //left-y=2 , right-y=5 , left-x=1 , right-x=4 
                    // 3 is the triggers?
                        Subsystems.drivesystem.driver.setMaxOutput(.5);
			Subsystems.drivesystem.driver.arcadeDrive(stickFine, 5, stickFine, 4);
                }else {
                        Subsystems.drivesystem.driver.setMaxOutput(1);
			Subsystems.drivesystem.driver.arcadeDrive(stickCoarse, 2, stickCoarse, 4);
                }
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
