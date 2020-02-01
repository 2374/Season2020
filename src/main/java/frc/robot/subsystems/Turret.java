package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Turret extends SubsystemBase {

    private TalonSRX turret;

    public Turret() {
        this.turret = new TalonSRX(Constants.TURRET_PORT);
    }

    public void turn(double powerValue, int direction) {
        turret.set(ControlMode.PercentOutput, powerValue * direction);
    }

}