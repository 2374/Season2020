package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
    
    private TalonFX leftClimber;
    private TalonFX rightClimber;

    public Climber() {
        this.leftClimber = new TalonFX(Constants.CLIMBER_LEFT_PORT);
        this.rightClimber = new TalonFX(Constants.CLIMBER_RIGHT_PORT);

        rightClimber.follow(leftClimber);
    }

    public void move(double power) {
        leftClimber.set(ControlMode.PercentOutput, power);
    }

}