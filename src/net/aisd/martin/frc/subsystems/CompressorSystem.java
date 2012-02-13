package net.aisd.martin.frc.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import net.aisd.martin.frc.RobotMap;
import net.aisd.martin.frc.AISDCompressor;
import net.aisd.martin.frc.commands.CompressorSendStatusCommand;

/**
 * Subsystem for the compressor system that turns
 * the compressor on and off
 * @author Manning
 */

public class CompressorSystem extends Subsystem
{
    /// Creates a CommpressorSystem to hold a compressor object
    public AISDCompressor compressor;
    
    public CompressorSystem(AISDCompressor comp)
    {
        super(CompressorSystem.class.getName());
        compressor = comp;
    }
    
    public CompressorSystem()
    {
        this(new AISDCompressor(
                RobotMap.Compressor.compressor_slot, 
                RobotMap.Compressor.pressure_switch, 
                RobotMap.Compressor.compressor_slot, 
                RobotMap.Compressor.compressor));
    }
    

    protected void initDefaultCommand() 
    {
        this.setDefaultCommand(new CompressorSendStatusCommand());
    }
    
    
}
