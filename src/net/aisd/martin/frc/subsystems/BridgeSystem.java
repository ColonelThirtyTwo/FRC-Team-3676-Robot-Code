
package net.aisd.martin.frc.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import net.aisd.martin.frc.RobotMap;
import net.aisd.martin.frc.commands.HIDBridgeManipulatorCommand;

/**
 * Bridge Manipulator Subsystem.
 * @author Niel Manning
 */
public class BridgeSystem extends Subsystem {
    
    private double power = 0;
    
    private SpeedController manipulatorArm;
	private DigitalInput limitSwitchUp;
        private DigitalInput limitSwitchDown;
    

    public BridgeSystem(SpeedController manipulatorArm, DigitalInput limitSwitchUp, DigitalInput limitSwitchDown)
	{
		super(BridgeSystem.class.getName());
		this.manipulatorArm = manipulatorArm;
		this.limitSwitchUp = limitSwitchUp;
                this.limitSwitchDown = limitSwitchDown;
    }    
    //creates new BridgeSystem
    public BridgeSystem(){
			this.manipulatorArm = new Jaguar(RobotMap.Manipulator.motorSlot, RobotMap.Manipulator.motorChannel);
			this.limitSwitchUp = new DigitalInput(RobotMap.Manipulator.limitSlot, RobotMap.Manipulator.limitUpChannel);
                        this.limitSwitchDown = new DigitalInput(RobotMap.Manipulator.limitSlot, RobotMap.Manipulator.limitDownChannel);
		
    }
    
    public void setArmPower(double power){
        this.power = power;
    }
    
    public void think()
	{
		if( (limitSwitchUp == null || !limitSwitchUp.get()) && //if up is off or null
                    (limitSwitchDown == null || !limitSwitchDown.get())){//and down is off or null
                            
                        manipulatorArm.set(power);//set to input power
                        
                } else if(limitSwitchDown.get()){//Otherwise if down is on then only go up
			manipulatorArm.set(Math.max(power,0));
                } else if(limitSwitchUp.get()) {
                        manipulatorArm.set(Math.min(power,0));//And if up is on then only go down
                }
    }
	
	public boolean getLimitSwitch()
	{
		return limitSwitchUp == null ? true : limitSwitchUp.get();
	}
    
    protected void initDefaultCommand()
	{
		this.setDefaultCommand(new HIDBridgeManipulatorCommand());
	}
}
