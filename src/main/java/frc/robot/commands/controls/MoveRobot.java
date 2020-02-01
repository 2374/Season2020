package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class MoveRobot extends CommandBase {

    private Drivetrain drivetrain;
    private double firstValue;
    private double secondValue;
    private boolean isTank;

    public MoveRobot(Drivetrain drivetrain, double firstValue, double secondValue, boolean isTank) {
        this.drivetrain = drivetrain;
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.isTank = isTank;

        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        if (isTank) {
            drivetrain.tankDrive(firstValue, secondValue);
        } else {
            drivetrain.arcadeDrive(firstValue, secondValue);
        }
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.tankDrive(0.0, 0.0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}