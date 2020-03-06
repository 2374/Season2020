package frc.robot.commands.automate;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.magic.LaunchBall;
import frc.robot.commands.magic.TurretToTarget;

public class AutomateShooter extends SequentialCommandGroup {

    public AutomateShooter(RobotContainer container) {

        addCommands(
            new TurretToTarget(container).withTimeout(5.0),
            new LaunchBall(container).withTimeout(5.0)
        );
    }

}