package frc.robot.commands.magic;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.util.LimeLight;

public class FindTarget extends CommandBase {

    private Drivetrain drivetrain;
    private LimeLight limelight;

    public FindTarget(Drivetrain drivetrain, LimeLight limelight) {
        this.drivetrain = drivetrain;
        this.limelight = limelight;
    }

    private boolean isFinished;

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        limelight.updateTracking();
        if (limelight.hasValidTarget() && Math.abs(limelight.getTurnValue()) > 0.1) {
            drivetrain.arcadeDrive(0.0, limelight.getTurnValue());
            System.out.println("Turn: " + limelight.getTurnValue());
            isFinished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

    // @Override
    // public void execute() {
    //     System.out.println("Has valid target: " + Robot.getLimeLight().hasValidTarget());
    //     if (Robot.getLimeLight().hasValidTarget()) {
    //         //Robot.getTurret().turn(0.0, 0);
    //         isFinished = true;
    //     } else {
    //         //System.out.println("Test, not working");
    //     }
    // }

    // @Override
    // public boolean isFinished() {
    //     return isFinished;
    // }

}