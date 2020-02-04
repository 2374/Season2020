package frc.robot.commands.magic;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;
import frc.robot.util.LimeLight;

public class DeployBall extends SequentialCommandGroup {

    public DeployBall(Turret turret, Shooter shooter, LimeLight limelight) {
        addRequirements(turret);
        addRequirements(shooter);

        addCommands(
            new TurretToTarget(turret, limelight),
            new EjectBall(shooter, shooter.distanceToPower(limelight.calculateDistance())).withTimeout(8.0)
        );
    }

}