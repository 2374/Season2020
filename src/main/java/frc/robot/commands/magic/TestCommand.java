package frc.robot.commands.magic;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;
import frc.robot.util.LimeLight;

public class TestCommand extends CommandBase {

    private Shooter shooter;
    private LimeLight limelight;

    public TestCommand(Shooter shooter, LimeLight limelight) {
        this.shooter = shooter;
        this.limelight = limelight;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        System.out.println("RPM: " + shooter.getRPM() + " | Distance: " + limelight.calculateDistance());
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}