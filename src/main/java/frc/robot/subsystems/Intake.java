package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.
ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class Intake extends SubsystemBase {

    private TalonSRX intake;

    public Intake() {
        this.intake = new TalonSRX(Constants.INTAKE_PORT);
    }

    public void move(double powerValue, int direction) {
        intake.set(ControlMode.PercentOutput, powerValue * direction);
    }

}