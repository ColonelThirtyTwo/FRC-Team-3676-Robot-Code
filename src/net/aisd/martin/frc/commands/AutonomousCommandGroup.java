/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aisd.martin.frc.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import net.aisd.martin.frc.commands.movement.ForwardCommand;
import net.aisd.martin.frc.commands.movement.HalfRotateCommand;
import net.aisd.martin.frc.commands.AutoShootCommand;

/**
 *
 * @author Manning
 */
public class AutonomousCommandGroup extends CommandGroup {
    public AutonomousCommandGroup() {
        super(AutonomousCommandGroup.class.getName());
        this.addSequential(new AutoShootCommand());
        this.addSequential(new HalfRotateCommand(false));
        this.addSequential(new ForwardCommand(.5,1)); 
    }
    
}
