
package net.aisd.martin.frc.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import net.aisd.martin.frc.commands.HIDShooterCommand;

/**
 * Controls the shooter.
 * @author Colonel Thirty Two
 */
public class ShooterSystem extends Subsystem
{
	/// Time delay, in milliseconds, between calling shoot() and
	// setting the piston to retract
	private static final long RetractTimer = 2*1000;
	
	private double spinPower = 0;
	private long retractTimer = 0;

	private Solenoid piston;
	private SpeedController topmotor, bottommotor;

	/**
	 * Creates a new Shooter system with specified components.
	 * @param piston Piston that pushes ball into the rollers
	 * @param motor1 First roller motor
	 * @param motor2 Second roller motor
	 */
	public ShooterSystem(Solenoid piston, SpeedController topmotor, SpeedController bottommotor)
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
			new Solenoid(RobotMap.Shooter.pneumatics_slot, RobotMap.Shooter.piston),
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
		if(time < retractTimer) return false;
		retractTimer = time+RetractTimer;
		return true;
	}
	
	/**
	 * Does per-tick logic. Controls motor and piston inputs.
	 */
	public void think()
	{
		if((System.currentTimeMillis()) < retractTimer)
			piston.set(true);
		else
			piston.set(false);
		
		topmotor.set(spinPower*0.8);
		bottommotor.set(spinPower);
	}
	
	protected void initDefaultCommand()
	{
		setDefaultCommand(new HIDShooterCommand());
	}
	
}
