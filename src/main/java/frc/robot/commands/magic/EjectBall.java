package frc.robot.commands.magic;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class EjectBall extends CommandBase {

    private Shooter shooter;
    private double powerValue;

    public EjectBall(Shooter shooter, double powerValue) {
        this.shooter = shooter;
        this.powerValue = powerValue;

        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        shooter.move(powerValue, 1);
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        shooter.move(0.0, 1);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}