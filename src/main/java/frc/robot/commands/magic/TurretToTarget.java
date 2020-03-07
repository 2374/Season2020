package frc.robot.commands.magic;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Turret;
import frc.robot.util.LimeLight;

public class TurretToTarget extends CommandBase {

    private Turret turret;
    private LimeLight limelight;
    private boolean isFinished;

    public TurretToTarget(RobotContainer container) {
        this.turret = container.getTurret();
        this.limelight = container.getLimeLight();
    }

    @Override
    public void initialize() {
        isFinished = false;

        NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3);
    }

    @Override
    public void execute() {
        if (limelight.hasValidTarget()) {
            if (Math.abs(limelight.getHorizontalTargetAngle()) > Constants.LIMELIGHT_TOLERANCE) {
                turret.turn(0.05, limelight.getTurnValue() > 0 ? 1 : -1);
            } else {
                isFinished = true;
            }
        }
    }

    @Override
    public void end(boolean interrupted) {
        turret.turn(0.0, 0);
        
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

}