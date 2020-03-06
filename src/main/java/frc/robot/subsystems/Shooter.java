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

        rightShooter.follow(leftShooter);
        leftShooter.setInverted(true);
    }

    public void move(double powerValue, int direction) {
        leftShooter.set(ControlMode.PercentOutput, powerValue);
    }

    public void move(int rpm, int direction) {
        leftShooter.set(ControlMode.PercentOutput, rpmToPower(rpm));
    }

    private double rpmToPower(int rpm) {
        return ((9.0 / 60400.0) * rpm) + (343.0 / 6040.0);
    }

    public double distanceToPower(double distance) {
        double power = (-2.0 * Math.pow(10.0, -8) * Math.pow(distance, 3.0)) + (3.0 * Math.pow(10.0, -5.0) * Math.pow(distance, 2.0)) - (0.0116 * distance) + 2.2446;
        return power < 1.0 ? power : 0.0;
    }

    public int getRPM() {
        int velocity = leftShooter.getSelectedSensorVelocity(0);
        return velocity * 600 / Constants.MAGIC_TALON_FX_SENSOR_UNITS;
    }

}