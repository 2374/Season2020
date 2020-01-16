package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

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

    frontLeft.setInverted(true);
    backLeft.setInverted(true);

    backLeft.follow(frontLeft);
    backRight.follow(frontRight);
  }

  public void tankDrive(double leftValue, double rightValue) {
    frontLeft.set(ControlMode.PercentOutput, leftValue);
    frontRight.set(ControlMode.PercentOutput, rightValue);
  }

  public void arcadeDrive(double throttleValue, double turnValue) {
		double leftMotor = -throttleValue + turnValue;
		double rightMotor = -throttleValue - turnValue;

    tankDrive(leftMotor, -rightMotor);
	}

  @Override
  public void periodic() {
    //Robot.getDrivetrain().tankDrive(Robot.getController().getJoystickLeftY(), Robot.getController().getJoystickRightY());
    Robot.getDrivetrain().arcadeDrive(Robot.getController().getJoystickLeftX(), Robot.getController().getJoystickLeftY());
  }
}
