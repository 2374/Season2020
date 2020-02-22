package frc.robot.commands.automate;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.ControllerJoystick;
import frc.robot.commands.magic.LaunchBall;
import frc.robot.commands.magic.TurretToTarget;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;
import frc.robot.util.LimeLight;

public class AutomateShooter extends SequentialCommandGroup {

    public AutomateShooter(ControllerJoystick controller, Turret turret, Shooter shooter, LimeLight limelight, Indexer indexer, Intake intake) {

        addCommands(
            new TurretToTarget(turret, limelight).withTimeout(5.0),
            new LaunchBall(controller, shooter, limelight, indexer, intake).withTimeout(5.0)
        );
    }

}