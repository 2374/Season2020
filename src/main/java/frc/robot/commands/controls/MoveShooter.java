package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;

public class MoveShooter extends CommandBase {

    private Shooter shooter;

    public MoveShooter(Shooter shooter) {
        this.shooter = shooter;

        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        shooter.move(Constants.SPEED_SHOOTER);
    }

    @Override
    public void end(boolean interrupted) {
        shooter.move(0.0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}