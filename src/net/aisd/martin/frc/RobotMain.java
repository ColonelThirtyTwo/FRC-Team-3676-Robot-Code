
package net.aisd.martin.frc;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import net.aisd.martin.frc.commands.AutoShootCommand;
import edu.wpi.first.wpilibj.camera.AxisCamera;

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
                // Changes camera setting to reduce lag to the computer
                AxisCamera camera = AxisCamera.getInstance();
                camera.writeMaxFPS(18);
                camera.writeResolution(AxisCamera.ResolutionT.k160x120);
                System.out.print("AxisCamera is configured");
                
                

		// instantiate the command used for the autonomous period
		autonomousCommand = new AutoShootCommand();

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
