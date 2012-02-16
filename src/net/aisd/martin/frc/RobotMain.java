
package net.aisd.martin.frc;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import net.aisd.martin.frc.commands.movement.ForwardCommand;
import net.aisd.martin.frc.commands.movement.HalfRotateCommand;

/**
 * Main robot class. Does stuff.
 */
public class RobotMain extends IterativeRobot
{
	private Command autonomousCommand;

	/**
		* This function is run when the robot is first started up and should be
		* used for any initialization code.
		*/
	public void robotInit()
	{
		Subsystems.init();

		// instantiate the command used for the autonomous period
		CommandGroup auto = new CommandGroup("Autonomous");
		auto.addSequential(new HalfRotateCommand(false));
		auto.addSequential(new ForwardCommand(1,2));
		autonomousCommand = auto;

		Subsystems.compressorsystem.compressor.start();
	}

	public void autonomousInit()
	{
		autonomousCommand.start();
	}

	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();
	}

	public void teleopInit()
	{
		autonomousCommand.cancel();
	}

	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();
	}

	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();
	}
}
