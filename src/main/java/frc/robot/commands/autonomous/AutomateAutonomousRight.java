package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.ControllerJoystick;
import frc.robot.RobotContainer;
import frc.robot.commands.automate.AutomateShooter;
import frc.robot.commands.controls.MoveIntakeIndexer;
import frc.robot.commands.controls.MoveShooter;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;
import frc.robot.util.LimeLight;

public class AutomateAutonomousRight extends SequentialCommandGroup {
    public AutomateAutonomousRight (RobotContainer robotContainer) {
        Drivetrain drivetrain = robotContainer.getDrivetrain();
        Intake intake = robotContainer.getIntake();
        Indexer indexer = robotContainer.getIndexer();
        Turret turret = robotContainer.getTurret();
        Shooter shooter = robotContainer.getShooter();
        LimeLight limelight = robotContainer.getLimeLight();
        ControllerJoystick controller = robotContainer.getJoystickController();

        super.addCommands(
            new MoveRobot(drivetrain, 10.0, 1),
            new MoveIntakeIndexer(intake, indexer).withTimeout(2.0),
            new MoveShooter(shooter, Constants.SPEED_SHOOTER),
            new AutomateShooter(controller, turret, shooter, limelight, indexer, intake)
        );
    }
} 