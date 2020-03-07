package frc.robot.commands.magic;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.controls.MoveIndexer;

public class LaunchBall extends ParallelCommandGroup {

    public LaunchBall(RobotContainer container) {

        addCommands(
            //new MoveIndexer(container.getIndexer(), 0.5, 1).withTimeout(5.0),
            new ShootBall(container, container.getShooter().distanceToPower(container.getLimeLight().calculateDistance())).withTimeout(5.0)
            );

    }

}