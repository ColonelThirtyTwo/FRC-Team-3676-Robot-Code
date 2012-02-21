
package net.aisd.martin.frc;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.command.CommandGroup;
import net.aisd.martin.frc.commands.AutoShootCommand;
import net.aisd.martin.frc.commands.SpinupCommand;

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
		System.out.println("Initializing robot");
		Subsystems.init();
		// Changes camera setting to reduce lag to the computer
		AxisCamera camera = AxisCamera.getInstance();
		camera.writeMaxFPS(18);
		camera.writeResolution(AxisCamera.ResolutionT.k160x120);

		// instantiate the command used for the autonomous period
		CommandGroup group = new CommandGroup("Autonomous");
		group.addSequential(new SpinupCommand(1));
		group.addSequential(new AutoShootCommand());
		autonomousCommand = group;

		Subsystems.compressorsystem.compressor.start();
	}

	public void autonomousInit()
	{
            System.out.print("Autonomous Starting");
		autonomousCommand.start();
	}

	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();
	}

	public void teleopInit()
	{
            System.out.print("Teleop Starting");
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
