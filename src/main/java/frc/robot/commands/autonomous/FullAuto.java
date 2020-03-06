package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;

public class FullAuto extends SequentialCommandGroup {
    public FullAuto(RobotContainer robotContainer) {
        super.addCommands(
            new DriveToDistance(robotContainer, 50.0, 0.5),
            new WaitCommand(1.0),
            new DriveToAngle(robotContainer, -90),
            new WaitCommand(1.0),
            new DriveToDistance(robotContainer, 50.0, 0.5)
        );
    }
}