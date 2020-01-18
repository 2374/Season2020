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

    // @Override
    // public void periodic() {
    //     if (Robot.getController().getLeftBumper()) {
    //         Robot.getIntake().move(Constants.SPEED_INTAKE, 1);
    //     } else if (Robot.getController().getRightBumper()) {
    //         Robot.getIntake().move(Constants.SPEED_INTAKE, -1);
    //     } else {
    //         Robot.getIntake().move(0.0, 1);
    //     }
    // }

}