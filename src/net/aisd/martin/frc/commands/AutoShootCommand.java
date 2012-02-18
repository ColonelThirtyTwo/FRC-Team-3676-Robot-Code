
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
           //Starts the motors spinning directly to allow them to
            //spin up
            Subsystems.shootersystem.topmotor.set(1);
            Subsystems.shootersystem.bottommotor.set(1);
               //Pauses for 2 seconds 
             try {
                Thread.sleep(2000);
            } catch(Exception e) {}
             //While there are balls loop through the shootersytem think
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
