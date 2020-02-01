package frc.robot.commands.magic;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.controls.MoveRobot;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import frc.robot.util.LimeLight;

public class DeployBall extends SequentialCommandGroup {

    private Drivetrain drivetrain;
    private LimeLight limelight;
    private Shooter shooter;

    public DeployBall(Drivetrain drivetrain, LimeLight limelight, Shooter shooter) {
        this.drivetrain = drivetrain;
        this.limelight = limelight;
        this.shooter = shooter;

        addRequirements(drivetrain);
        addRequirements(shooter);
    }

    public DeployBall() {

        System.out.println("Running");

        addCommands(
            new FindTarget(drivetrain, limelight),
            new MoveRobot(drivetrain, 0.2, limelight.getTurnValue(), false)
            /*,*/
            /*ew EjectBall(shooter, 0.69).withTimeout(1)*/
        );

    }

}