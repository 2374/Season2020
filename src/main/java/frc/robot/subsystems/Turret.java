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

    // @Override
    // public void periodic() {
    //     if (Robot.getController().getLeftTrigger() > 0.1) {
    //         Robot.getTurret().turn(Constants.SPEED_TURRET, 1);
    //     } else if (Robot.getController().getRightTrigger() > 0.1) {
    //         Robot.getTurret().turn(Constants.SPEED_TURRET, -1);
    //     }
    // }

}