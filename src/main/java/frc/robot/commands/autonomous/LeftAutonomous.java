package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;

public class LeftAutonomous extends SequentialCommandGroup {
    public LeftAutonomous(RobotContainer robotContainer) {
        super.addCommands(
            // Shoot 3 balls
            // Intake, indexer started
            // moving to get all three balls
            new DriveToDistance(robotContainer, 206.25, 0.5),
            // move back to a little bit
            new DriveToDistance(robotContainer, -110.25, 0.5)
            // shoot the balls
        );
    }

}