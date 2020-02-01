package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
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

        leftShooter.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 1000);
        leftShooter.configPulseWidthPeriod_EdgesPerRot(Constants.MAGIC_EDGES_PER_CYCLE, 1000);
        leftShooter.configPulseWidthPeriod_FilterWindowSz(Constants.MAGIC_FILTER_WINDOW_SIZE, 1000);
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

    public int getRPM() {
        int velocity = leftShooter.getSelectedSensorVelocity(0);
        return velocity * 600 / Constants.TALON_FX_SENSOR_UNITS;
    }

}