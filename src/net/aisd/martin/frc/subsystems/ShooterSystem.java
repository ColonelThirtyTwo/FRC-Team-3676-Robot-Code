
package net.aisd.martin.frc.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 * Controls the shooter.
 * @author Colonel Thirty Two
 */
public class ShooterSystem extends Subsystem
{
	private static final long RetractTimer = 2*1000;
	
	private boolean isSpinning = false;
	private long retractTimer = 0;

	private Solenoid piston;
	private SpeedController motor1, motor2;

	/**
	 * Creates a new Shooter system with specified components.
	 * @param piston Piston that pushes ball into the rollers
	 * @param motor1 First roller motor
	 * @param motor2 Second roller motor
	 */
	public ShooterSystem(Solenoid piston, SpeedController motor1, SpeedController motor2)
	{
		super(ShooterSystem.class.getName());
		this.piston = piston;
		this.motor1 = motor1;
		this.motor2 = motor2;
	}

	/**
	 * Creates a new shooter system, using values in RobotMap
	 */
	public ShooterSystem()
	{
		this(
			new Solenoid(RobotMap.Shooter.pneumatics_slot, RobotMap.Shooter.piston),
			new Jaguar(RobotMap.Shooter.motor_slot, RobotMap.Shooter.motor1),
			new Jaguar(RobotMap.Shooter.motor_slot, RobotMap.Shooter.motor2)
		);
	}
	
	/**
	 * Tells the motors to spin up or down.
	 * @param spin True to spin up, false to stop powering
	 */
	public void setSpinning(boolean spin)
	{
		isSpinning = spin;
	}
	
	/**
	 * Shoots a ball. Activates the piston and pushes the ball towards the spinners.
	 * @return True if successful, false if motors are not spinning or the piston is retracting.
	 */
	public boolean shoot()
	{
		if(!isSpinning) return false;
		long time = System.currentTimeMillis();
		if(time < retractTimer) return false;
		retractTimer = time+RetractTimer;
		return true;
	}
	
	/**
	 * Does per-tick logic. Controls motor and piston inputs.
	 */
	public void think()
	{
		if(System.currentTimeMillis() < retractTimer)
			piston.set(true);
		else
			piston.set(false);
		
		if(isSpinning)
		{
			motor1.set(1);
			motor2.set(1);
		}
		else
		{
			motor1.set(0);
			motor2.set(0);
		}
	}
	
	protected void initDefaultCommand()
	{
	}
	
}
