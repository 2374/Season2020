package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {

    private TalonSRX arm;

    public Arm() {
        this.arm = new TalonSRX(Constants.ARM_PORT);
        
        arm.setInverted(true);
    }

    public void move(double power) {
        arm.set(ControlMode.PercentOutput, power);
    }

}