package frc.robot.commands.magic;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;
import frc.robot.util.LimeLight;

public class EjectBall extends CommandBase {

    private Shooter shooter;
    private LimeLight limelight;
    private double powerValue;

    public EjectBall(Shooter shooter, LimeLight limelight, double powerValue) {
        this.shooter = shooter;
        this.limelight = limelight;
        this.powerValue = powerValue;

        addRequirements(shooter);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        System.out.println("Power: " + powerValue);
        if (limelight.calculateDistance() > 300.0) {
            shooter.move(powerValue, 1);
        } else {
            shooter.move(0.80, 1);
        }

    }

    @Override
    public void end(boolean interrupted) {
        shooter.move(0.0, 1);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}