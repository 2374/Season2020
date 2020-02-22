package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class MoveShooter extends CommandBase {

    private Shooter shooter;
    private double power;
    private int rpm;

    public MoveShooter(Shooter shooter, double power) {
        this.shooter = shooter;
        this.power = power;

        addRequirements(shooter);
    }

    public MoveShooter(Shooter shooter, int rpm) {
        this.shooter = shooter;
        this.rpm = rpm;

        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        System.out.println("Shooting at power : " + power);
    }

    @Override
    public void execute() {
        if (rpm != 0) {
            shooter.move(rpm, 1);
        } else {
            shooter.move(power, 1);
        }   
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