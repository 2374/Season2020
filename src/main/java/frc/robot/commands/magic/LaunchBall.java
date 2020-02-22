package frc.robot.commands.magic;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.ControllerJoystick;
import frc.robot.commands.controls.MoveIndexer;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.util.LimeLight;

public class LaunchBall extends ParallelCommandGroup {

    public LaunchBall(ControllerJoystick controller, Shooter shooter, LimeLight limelight, Indexer indexer, Intake intake) {

        addCommands(
            new MoveIndexer(indexer, 0.5, 1).withTimeout(5.0),
            new ShootBall(controller, shooter, indexer, limelight, shooter.distanceToPower(limelight.calculateDistance())).withTimeout(5.0)
            );

    }

}