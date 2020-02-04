package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class TempShooter extends CommandBase {

    private Shooter shooter;

    public TempShooter(Shooter shooter) {
        this.shooter = shooter;

        addRequirements(shooter);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        double power = (double) SmartDashboard.getNumber("speed", 0.01);
        System.out.println("Shooting at : " + power);
        shooter.move(power, 1);
    }

    @Override
    public void end(boolean interrupted) {
        shooter.move(0.0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}