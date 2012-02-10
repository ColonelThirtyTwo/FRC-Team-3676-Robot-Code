
package net.aisd.martin.frc.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import net.aisd.martin.frc.commands.HIDBridgeManipulatorCommand;

/**
 * Bridge Manipulator Subsystem.
 * @author Niel Manning
 */
public class BridgeSystem extends Subsystem {
    
    private double power = 0;
    
    private SpeedController manipulatorArm;
	private DigitalInput limitSwitch;
    

    public BridgeSystem(SpeedController manipulatorArm, DigitalInput limitSwitch)
	{
		super(BridgeSystem.class.getName());
		this.manipulatorArm = manipulatorArm;
		this.limitSwitch = limitSwitch;
    }    
    //creates new BridgeSystem
    public BridgeSystem(){
        this(
			new Jaguar(RobotMap.Manipulator.motorSlot, RobotMap.Manipulator.motorChannel),
			new DigitalInput(RobotMap.Manipulator.limitSlot, RobotMap.Manipulator.limitChannel)
		);
    }
    
    public void setArmPower(double power){
        this.power = power;
    }
    
    public void think()
	{
		if(limitSwitch == null || !limitSwitch.get())
			manipulatorArm.set(power);
		else
			manipulatorArm.set(0);
    }
	
	public boolean getLimitSwitch()
	{
		return limitSwitch == null ? true : limitSwitch.get();
	}
    
    protected void initDefaultCommand()
	{
		this.setDefaultCommand(new HIDBridgeManipulatorCommand());
	}
}
