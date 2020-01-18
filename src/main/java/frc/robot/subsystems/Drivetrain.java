package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  // I'm not sure if all motor controllers have a common base class or share a common interface.
  // If they do, you can ignore this comment.
  // You can also ignore this if you only ever use one type of motor controller - not sure if
  // you exclusively use Talons at this point.
  // It might be worth creating your own "MotorController" class that is subclassed for each
  // type of actual controller. This would allow you to more easily swap out the controller
  // type if the hardware changes.
  // E.g. if you were switching from a Talon to a Jaguar would just be changing from:
  // this.frontLeft = new MotorControllerTalonSRX(...);
  // to
  // this.frontLeft = new MotorControllerJaguar(...);
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

  // @Override
  // public void periodic() {
  //   //Robot.getDrivetrain().tankDrive(Robot.getController().getJoystickLeftY(), Robot.getController().getJoystickRightY());
  //   Robot.getDrivetrain().arcadeDrive(Robot.getController().getJoystickLeftX(), Robot.getController().getJoystickLeftY());
  // }
}
