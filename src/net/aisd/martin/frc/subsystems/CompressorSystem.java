package net.aisd.martin.frc.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 * Subsystem for the compressor system that turns
 * the compressor on and off
 * @author Manning
 */

public class CompressorSystem extends Subsystem
{
    /// Creates a CommpressorSystem to hold a compressor object
    public Compressor compressor;
    
    public CompressorSystem(Compressor comp)
    {
        super(CompressorSystem.class.getName());
        compressor = comp;
    }
    
    public CompressorSystem()
    {
        this(new Compressor(
                RobotMap.Shooter.pneumatics_slot, 
                RobotMap.Shooter.pressureSwitch, 
                RobotMap.Shooter.pneumatics_slot, 
                RobotMap.Shooter.compressor));
    }
    

    protected void initDefaultCommand() 
    {
        //No Default Command
    }
    
    
}
