package frc.robot.commands.magic;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;
import frc.robot.util.LimeLight;

public class DeployBall extends SequentialCommandGroup {

    private Turret turret;
    private Shooter shooter;
    private LimeLight limelight;

    public DeployBall(Turret turret, Shooter shooter, LimeLight limelight) {
        this.turret = turret;
        this.shooter = shooter;
        this.limelight = limelight;

        addRequirements(turret);
        addRequirements(shooter);
    }

    public DeployBall() {

        System.out.println("Running");

        addCommands(

            //new FindTarget(drivetrain, limelight),
            //new MoveRobot(drivetrain, 0.2, limelight.getTurnValue(), false)
            /*,*/
            /*new EjectBall(shooter, 0.69).withTimeout(1)*/
        );

    }

}