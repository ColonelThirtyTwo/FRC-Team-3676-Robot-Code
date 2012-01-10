
package net.aisd.martin.frc.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import net.aisd.martin.frc.commands.JoyDriveCommand;

/**
 *
 * @author Col32
 */
public class DriveSystem extends Subsystem
{
	public static DriveSystem self = new DriveSystem();
	public RobotDrive driver;
	
	private DriveSystem()
	{
		super("DriveSystem");
		if(self != null) throw new RuntimeException("Instanciated multiple DriveSystem's");
		SpeedController left = new Jaguar(RobotMap.DriveMotors.slot, RobotMap.DriveMotors.left);
		SpeedController right = new Jaguar(RobotMap.DriveMotors.slot, RobotMap.DriveMotors.right);
		driver = new RobotDrive(left,right);
	}
	
	protected void initDefaultCommand()
	{
		setDefaultCommand(new JoyDriveCommand());
	}
	
}
