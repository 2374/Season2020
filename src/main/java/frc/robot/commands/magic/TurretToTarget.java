package frc.robot.commands.magic;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Turret;
import frc.robot.util.LimeLight;

public class TurretToTarget extends CommandBase {

    private Turret turret;
    private LimeLight limelight;
    private boolean isFinished;

    public TurretToTarget(Turret turret, LimeLight limelight) {
        this.turret = turret;
        this.limelight = limelight;
    }

    @Override
    public void initialize() {
        isFinished = false;
    }

    @Override
    public void execute() {
        if (limelight.hasValidTarget()) {
            if (Math.abs(limelight.getHorizontalTargetAngle()) > Constants.MAGIC_LIMELIGHT_GOAL) {
                turret.turn(0.05, limelight.getTurnValue() > 0 ? 1 : -1);
            } else {
                isFinished = true;
            }
        }
    }

    @Override
    public void end(boolean interrupted) {
        turret.turn(0.0, 0);
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

}