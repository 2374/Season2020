package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  private CANSparkMax frontLeft;
  private CANSparkMax frontRight;
  private CANSparkMax backLeft;
  private CANSparkMax backRight;

  public Drivetrain() {
    this.frontLeft = new CANSparkMax(Constants.DRIVETRAIN_FRONT_LEFT_PORT, CANSparkMaxLowLevel.MotorType.kBrushless);
    this.frontRight = new CANSparkMax(Constants.DRIVETRAIN_FRONT_RIGHT_PORT, CANSparkMaxLowLevel.MotorType.kBrushless);
    this.backLeft = new CANSparkMax(Constants.DRIVETRAIN_BACK_LEFT_PORT, CANSparkMaxLowLevel.MotorType.kBrushless);
    this.backRight = new CANSparkMax(Constants.DRIVETRAIN_BACK_RIGHT_PORT, CANSparkMaxLowLevel.MotorType.kBrushless);

    frontRight.setInverted(true);
    backRight.setInverted(true);

    backLeft.follow(frontLeft);
    backRight.follow(frontRight);
  }

  public void tankDrive(double leftValue, double rightValue) {
    frontLeft.set(leftValue);
    frontRight.set(rightValue);
  }

  public void arcadeDrive(double throttleValue, double turnValue) {
    double leftMotor = throttleValue + turnValue;
    double rightMotor = throttleValue - turnValue;
    
    if (throttleValue < 0.0) {
      tankDrive(rightMotor, leftMotor);
    } else {
      tankDrive(leftMotor, rightMotor);
    }
  }
  
}
