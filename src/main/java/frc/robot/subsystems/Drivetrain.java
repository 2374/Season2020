package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  private TalonSRX frontLeft;
  private TalonSRX frontRight;
  private TalonSRX backLeft;
  private TalonSRX backRight;

  public Drivetrain() {
    this.frontLeft = new TalonSRX(Constants.DRIVETRAIN_FRONT_LEFT_PORT);
    this.frontRight = new TalonSRX(Constants.DRIVETRAIN_FRONT_RIGHT_PORT);
    this.backLeft = new TalonSRX(Constants.DRIVETRAIN_BACK_LEFT_PORT);
    this.backRight = new TalonSRX(Constants.DRIVETRAIN_BACK_RIGHT_PORT);

    frontLeft.setSelectedSensorPosition(0);
    frontRight.setSelectedSensorPosition(0);

    frontRight.setInverted(true);
    backRight.setInverted(true);

    backLeft.follow(frontLeft);
    backRight.follow(frontRight);

    configureSettings(frontLeft, frontRight, backLeft, backRight);
  }

  public void tankDrive(double leftValue, double rightValue) {
    frontLeft.set(ControlMode.PercentOutput, leftValue);
    frontRight.set(ControlMode.PercentOutput, rightValue);
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

  public void setEncodersToZero() {
    frontLeft.setSelectedSensorPosition(0);
    frontRight.setSelectedSensorPosition(0);
  }
  
  private void configureSettings(TalonSRX ... talons) {
    for (TalonSRX talon : talons) {
        talon.enableVoltageCompensation(true);
        talon.configVoltageCompSaturation(12.0);
        talon.setNeutralMode(NeutralMode.Brake);
    }
  }

  private double getLeftEncoderRotations() {
    return frontLeft.getSelectedSensorPosition(0) / Constants.MAGIC_TALON_SRX_SENSOR_UNITS;
  }

  private double getRightEncoderRotations() {
      return frontRight.getSelectedSensorPosition(0) / Constants.MAGIC_TALON_SRX_SENSOR_UNITS;
  }

  public double getLeftEncoderDistance() {
      return rotationsToInches(getLeftEncoderRotations());
  }

  public double getRightEncoderDistance() {
      return rotationsToInches(getRightEncoderRotations());
  }

  public double getLeftEncoderVelocity() {
      return rotationsToInches(frontLeft.getSelectedSensorVelocity(0) * 10.0 / Constants.MAGIC_TALON_SRX_SENSOR_UNITS);
  }

  public double getRightEncoderVelocity() {
      return rotationsToInches(frontRight.getSelectedSensorVelocity(0) * 10.0 / Constants.MAGIC_TALON_SRX_SENSOR_UNITS);
  }

  private double rotationsToInches(double rotations) {
      return rotations * Constants.WHEEL_DIAMETER * Math.PI;
  }

}
