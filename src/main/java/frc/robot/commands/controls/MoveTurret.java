package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;

public class MoveTurret extends CommandBase {

    private Turret turret;
    private double powerValue;
    private int direction;

    public MoveTurret(Turret turret, double powerValue, int direction) {
        this.turret = turret;
        this.powerValue = powerValue;
        this.direction = direction;

        addRequirements(turret);
    }

    @Override
    public void initialize() {
        turret.turn(powerValue, direction);
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        turret.turn(0.0, 0);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}