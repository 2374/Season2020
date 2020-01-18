// "magic" doesn't seem like a very descriptive part of the package name.
package frc.robot.commands.magic;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Shooter;
import frc.robot.util.LimeLight;

public class DeployBall extends SequentialCommandGroup {

    private LimeLight limelight;
    private Shooter shooter;

    public DeployBall(LimeLight limelight, Shooter shooter) {
        this.limelight = limelight;
        this.shooter = shooter;

        addRequirements(shooter);
    }

    public DeployBall() {

        addCommands(
            new FindTarget(limelight),
            // Magic number
            new EjectBall(shooter, 0.69).withTimeout(1)
        );        

    }

}