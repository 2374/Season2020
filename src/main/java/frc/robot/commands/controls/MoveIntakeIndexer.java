package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class MoveIntakeIndexer extends ParallelCommandGroup {
    public MoveIntakeIndexer(RobotContainer container) {
        super.addCommands(
            new MoveIntake(container, Constants.SPEED_INTAKE, 1)
            //new MoveIndexer(indexer, Constants.SPEED_INDEXER, 1)
        );
    }
}