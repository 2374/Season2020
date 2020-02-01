package frc.robot.commands.magic;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.util.LimeLight;

public class TestDistance extends CommandBase {
    private LimeLight limelight;

    public TestDistance(LimeLight limelight) {
        this.limelight = limelight;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        limelight.updateTracking();
        System.out.println(limelight.calculateDistance());
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}