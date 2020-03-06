package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;

public class MoveTurret extends CommandBase {

    private Turret turret;
    private double power;
    private int direction;

    public MoveTurret(Turret turret, double power, int direction) {
        this.turret = turret;
        this.power = power;
        this.direction = direction;

        super.addRequirements(turret);
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        turret.turn(power, direction);
    }

    @Override
    public void end(boolean interrupted) {
        turret.turn(0.0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}