package frc.robot.commands.autonomous;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class DriveToAngle extends CommandBase {
    
    private AHRS navx;
    private Drivetrain drivetrain;
    private double angle;
    private boolean isFinished;

    public DriveToAngle(RobotContainer robotContainer, double angle) {
        this.navx = robotContainer.getNavX();
        this.drivetrain = robotContainer.getDrivetrain();
        this.angle = angle;
    }

    @Override
    public void initialize() {
        isFinished = false;
        navx.reset();
    }

    @Override
    public void execute() {
        double yaw = navx.getYaw();

        // only accounts when YAW is POSITIVE
        System.out.println("Yaw: " + yaw + " Angle: " + angle);
        if (angle >= 0.0) {
            if (yaw < (angle - 7.0)) {
                drivetrain.arcadeDrive(0.0, -0.2);
            }else {
                isFinished = true;
            }
        }
        else {
            if (yaw > (angle + 7.0)) {
                drivetrain.arcadeDrive(0.0, 0.2);
            }
            else {
                isFinished = true;
            }
        }
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.tankDrive(0.0, 0.0);
        navx.reset();
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

} 