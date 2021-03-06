
package net.aisd.martin.frc.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import net.aisd.martin.frc.RobotMap;
import net.aisd.martin.frc.commands.ArcadePrecisionDriveCommand;
import net.aisd.martin.frc.commands.TankDriveCommand;

/**
 * Subsystem for robot drive motors. Default command is an TankDriveCommand.
 * @see TankDriveCommand
 * @author Col32
 */
public final class DriveSystem extends Subsystem
{
	/**
	 * Workaround to set up a drivesystem while still calling this constructor,
	 * since we cannot call methods in constructor until its too late.
	 */
	private static RobotDrive setupDriveSystem(SpeedController sp1, SpeedController sp2, SpeedController sp3, SpeedController sp4)
	{
		RobotDrive d = new RobotDrive(sp1, sp2, sp3, sp4);
		d.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
		d.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		d.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
		d.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		return d;
	}
	
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
	 * by RobotMap.DriveMotors.slotleft/right.
	 */
	public DriveSystem()
	{
		this(setupDriveSystem(
		     new Jaguar(RobotMap.DriveMotors.slot, RobotMap.DriveMotors.frontLeft),
		     new Jaguar(RobotMap.DriveMotors.slot, RobotMap.DriveMotors.leftBack),
		     new Jaguar(RobotMap.DriveMotors.slot, RobotMap.DriveMotors.frontRight),
		     new Jaguar(RobotMap.DriveMotors.slot, RobotMap.DriveMotors.rightBack)
		));
	}
	
	protected void initDefaultCommand()
	{
		setDefaultCommand(new ArcadePrecisionDriveCommand());
	}
}
