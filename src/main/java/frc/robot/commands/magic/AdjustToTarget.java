package frc.robot.commands.magic;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.util.LimeLight;

public class AdjustToTarget extends CommandBase {

    private Drivetrain drivetrain;
    private LimeLight limelight;
    private boolean isFinished;

    public AdjustToTarget(Drivetrain drivetrain, LimeLight limelight) {
        this.drivetrain = drivetrain;
        this.limelight = limelight;
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        limelight.updateTracking();
        while (limelight.hasValidTarget() && Math.abs(limelight.getTurnValue()) > 0.1) {
            drivetrain.arcadeDrive(0.0, limelight.getTurnValue());
            System.out.println("Turn: " + limelight.getTurnValue());
            System.out.println("Throttle: " + limelight.getThrottleValue());
        }
        isFinished = true;
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.tankDrive(0.0, 0.0);
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

}