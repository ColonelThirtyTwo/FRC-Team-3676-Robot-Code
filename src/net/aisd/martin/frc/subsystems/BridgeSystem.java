/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aisd.martin.frc.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import net.aisd.martin.frc.commands.TankDriveCommand;

/**
 *
 * @author Manning
 */
public class BridgeSystem extends Subsystem {
    
    private double power = 0;
    
    private SpeedController manipulatorArm;
    
    //creates new BridgeSystem with specified parts
    public BridgeSystem(SpeedController manipulatorArm){
        super(BridgeSystem.class.getName());
        this.manipulatorArm = manipulatorArm;
    }    
    //creates new BridgeSystem
    public BridgeSystem(){
        this(
                new Jaguar(RobotMap.ManipulatorSolenoid.slot, RobotMap.ManipulatorSolenoid.channel)
            );
    }
    
    public void setArmPower(double power){
        this.power = power;
    }
    
    public void think() {
        if(power >= .1 || power <= -.1){
        manipulatorArm.set(power);
        }
    }
    
    protected void initDefaultCommand() {
        //no default command
    }
}
