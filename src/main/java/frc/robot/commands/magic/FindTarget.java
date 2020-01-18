package frc.robot.commands.magic;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.util.LimeLight;

public class FindTarget extends CommandBase {

    private LimeLight limelight;

    public FindTarget(LimeLight limelight) {
        this.limelight = limelight;
    }

    //private boolean isFinished;

    @Override
    public void initialize() {
        System.out.println("Has valid target: " + limelight.hasValidTarget());
    }

    @Override
    public boolean isFinished() {
        return true;
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