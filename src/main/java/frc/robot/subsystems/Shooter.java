package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {

    private TalonFX leftShooter;
    private TalonFX rightShooter;

    public Shooter() {
        this.leftShooter = new TalonFX(Constants.SHOOTER_LEFT_PORT);
        this.rightShooter = new TalonFX(Constants.SHOOTER_RIGHT_PORT);
    }

    public void move(double powerValue) {
        leftShooter.set(ControlMode.PercentOutput, -powerValue);
        rightShooter.set(ControlMode.PercentOutput, powerValue);
    }

    // @Override
    // public void periodic() {
    //     if (Robot.getController().getLeftTrigger() > 0.1) {
    //         Robot.getShooter().move(Robot.getController().getLeftTrigger());
    //     } else {
    //         Robot.getShooter().move(0.0);
    //     }
    // }

}