
package net.aisd.martin.frc.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import net.aisd.martin.frc.RobotMap;
import net.aisd.martin.frc.commands.HIDShooterCommand;

/**
 * Controls the shooter.
 * @author Colonel Thirty Two
 */
public class ShooterSystem extends Subsystem
{
	/// Time delay, in milliseconds, between calling shoot() and
	// setting the piston to retract
	public static final long ExtendTime = 1*1000;
	/// Time delay, in milliseconds, between the piston beginning to retract
	// and the ability to shoot again.
	public static final long RetractTime = 1*1000;
	
	private double spinPower = 0;
	private long retractTimer = Long.MIN_VALUE;

	private DoubleSolenoid piston;
	private SpeedController topmotor, bottommotor;

	/**
	 * Creates a new Shooter system with specified components.
	 * @param piston Piston that pushes ball into the rollers
	 * @param motor1 First roller motor
	 * @param motor2 Second roller motor
	 */
	public ShooterSystem(DoubleSolenoid piston, SpeedController topmotor, SpeedController bottommotor)
	{
		super(ShooterSystem.class.getName());
		this.piston = piston;
		this.topmotor = topmotor;
		this.bottommotor = bottommotor;
	}

	/**
	 * Creates a new shooter system, using values in RobotMap
	 */
	public ShooterSystem()
	{
		this(
			new DoubleSolenoid(RobotMap.Shooter.pneumatics_slot, RobotMap.Shooter.piston_forward, RobotMap.Shooter.piston_backward),
			new Jaguar(RobotMap.Shooter.motor_slot, RobotMap.Shooter.topmotor),
			new Jaguar(RobotMap.Shooter.motor_slot, RobotMap.Shooter.bottommotor)
		);
	}
	
	/**
	 * Sets the motor power. 
	 */
	public void setSpinning(double power)
	{
		spinPower = power;
	}
	
	/**
	 * Shoots a ball. Activates the piston and pushes the ball towards the spinners.
	 * @return True if successful, false if motors are not spinning or the piston is retracting.
	 */
	public boolean shoot()
	{
		if(spinPower == 0) return false;
		long time = System.currentTimeMillis();
		if(time < retractTimer+RetractTime) return false;
		retractTimer = time+ExtendTime;
		System.out.println("Shooting");
		return true;
	}
	
	/**
	 * Does per-tick logic. Controls motor and piston inputs.
	 */
	public void think()
	{
		if(System.currentTimeMillis() < retractTimer)
			piston.set(DoubleSolenoid.Value.kForward);
		else
			piston.set(DoubleSolenoid.Value.kReverse);
		
		topmotor.set(spinPower*0.6);
		bottommotor.set(spinPower);
	}
	
	protected void initDefaultCommand()
	{
		setDefaultCommand(new HIDShooterCommand());
	}
	
}
