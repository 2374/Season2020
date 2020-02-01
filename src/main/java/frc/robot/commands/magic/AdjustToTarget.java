package frc.robot.commands.magic;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;
import frc.robot.util.LimeLight;

public class AdjustToTarget extends CommandBase {

    private Turret turret;
    private LimeLight limelight;
    private boolean isFinished;

    public AdjustToTarget(Turret turret, LimeLight limelight) {
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
            if (Math.abs(limelight.getHorizontalTargetAngle()) > 0.05) {
                if (limelight.getHorizontalTargetAngle() > 1.0) {
                    turret.turn(0.2, limelight.getTurnValue() > 0 ? 1 : -1);
                } else if (limelight.getHorizontalTargetAngle() < 0.05) {
                    turret.turn(0.05, limelight.getTurnValue() > 0 ? 1 : -1);
                }
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