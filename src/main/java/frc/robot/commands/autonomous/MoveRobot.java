package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class MoveRobot extends CommandBase {
    
    private Drivetrain drivetrain;
    private double distance;
    private int direction;

    public MoveRobot(Drivetrain drivetrain, double distance, int direction) {
        this.drivetrain = drivetrain;
        this.distance = distance;
        this.direction = direction;
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        
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