
package net.aisd.martin.frc.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import net.aisd.martin.frc.commands.TankDriveCommand;

/**
 * Subsystem for robot drive motors. Default command is an TankDriveCommand.
 * @see TankDriveCommand
 * @author Col32
 */
public final class DriveSystem extends Subsystem
{
	
	/**
	 * The RobotDrive that this subsystem controls.
	 * Don't access it unless the command owns the subsystem.
	 */
	public RobotDrive driver;
	
	/**
	 * Creates a DriveSystem which holds a RobotDrive instance.
	 * @param drive The RobotDrive instance to control.
	 */
	public DriveSystem(RobotDrive drive)
	{
		super(DriveSystem.class.getName());
		driver = drive;
	}
	
	/**
	 * Creates a DriveSystem which holds a RobotDrive instance.
	 * This constructor initializes a new RobotDrive using four new Jaguars defined
	 * by RobotMap.DriveMotors.slot front/rear/left/right.
	 */
	public DriveSystem()
	{
		this(new RobotDrive(
				new Jaguar(RobotMap.DriveMotors.slot, RobotMap.DriveMotors.rear_left),
                                new Jaguar(RobotMap.DriveMotors.slot, RobotMap.DriveMotors.rear_right)
			));
	}
	
	protected void initDefaultCommand()
	{
		setDefaultCommand(new TankDriveCommand());
	}
	
}
