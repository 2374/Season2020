package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class MoveForward extends CommandBase {

    private Drivetrain drivetrain;

    public MoveForward(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;

        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        drivetrain.tankDrive(Constants.SPEED_AUTO, Constants.SPEED_AUTO);
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.tankDrive(0.0, 0.0);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}