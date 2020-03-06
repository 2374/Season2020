package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class DriveToDistance extends CommandBase {

    private Drivetrain drivetrain;
    private double inches;
    private double power;
    private boolean isFinished;

    public DriveToDistance(RobotContainer container, double inches, double power) {
        this.drivetrain = container.getDrivetrain();
        this.inches = inches;
        this.power = power;
    }

    @Override
    public void initialize() {
        isFinished = false;
        drivetrain.setEncodersToZero();
    }

    @Override
    public void execute() {
        double inchesRemaining = Math.abs(inches) - Math.abs(drivetrain.getRightEncoderDistance());
        // double throttleValue = ( ( Math.abs ( inches - Math.abs (drivetrain.getRightEncoderDistance() ) ) )  / inches);
        double throttleValue = inchesRemaining / Math.abs(inches);
 
        if (Math.abs(drivetrain.getRightEncoderDistance()) < Math.abs(inches)) {
            if (inches < 0) {
                if (inchesRemaining < 20) {
                    drivetrain.arcadeDrive(-throttleValue - 0.1, 0.0);
                }
                else {
                    drivetrain.arcadeDrive(-throttleValue, 0.0);
                }
            } 
            else {
                if (inchesRemaining < 20) {
                    drivetrain.arcadeDrive(throttleValue + 0.1, 0.0);
                } else {
                    drivetrain.arcadeDrive(throttleValue, 0.0);
                }    
            }
        } else {
            isFinished = true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.tankDrive(0.0, 0.0);
        drivetrain.setEncodersToZero();
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

}