package frc.robot.commands.magic;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.ControllerJoystick;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;
import frc.robot.util.LimeLight;

public class ShootBall extends CommandBase {

    private ControllerJoystick controller;
    private Shooter shooter;
    private Indexer indexer;
    private LimeLight limelight;
    private double power;

    public ShootBall(ControllerJoystick controller, Shooter shooter, Indexer indexer, LimeLight limelight, double power) {
        this.controller = controller;
        this.shooter = shooter;
        this.indexer = indexer;
        this.limelight = limelight;
        this.power = power;

        addRequirements(shooter);
        addRequirements(indexer);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        // if (limelight.calculateDistance() > 300.0) {
        //     indexer.move(4, Constants.SPEED_INDEXER_STAGE_4);
        //     shooter.move(power, 1);
        // } else {
            indexer.move(4, Constants.SPEED_INDEXER_STAGE_4, 1);
            shooter.move(0.80 + (controller.getSlider() * 0.20), 1);
        // }
    }

    @Override
    public void end(boolean interrupted) {
        shooter.move(0.0, 1);
        indexer.move(4, 0.0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}