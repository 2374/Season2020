package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
    
    private TalonFX climberMaster;
    private TalonFX climberSlave;

    public Climber() {
        this.climberMaster = new TalonFX(Constants.CLIMBER_LEFT_PORT);
        this.climberSlave = new TalonFX(Constants.CLIMBER_RIGHT_PORT);

        climberSlave.follow(climberMaster);
    }

    public void move(double power) {
        climberMaster.set(ControlMode.PercentOutput, power);
    }

}