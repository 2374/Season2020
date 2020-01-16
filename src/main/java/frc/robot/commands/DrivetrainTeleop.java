package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class DrivetrainTeleop extends CommandBase {

    @Override
    public void execute() {
        // Robot.getLimeLight().updateTracking();
        // System.out.println("Debug");
        if (Robot.getController().getButtonA()) {
            
        }
    }

}