package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class EjectBall extends CommandBase {

    private double powerValue;

    public EjectBall(double powerValue) {
        this.powerValue = powerValue;
    }

    @Override
    public void initialize() {
        Robot.getShooter().move(powerValue);
    }

    @Override
    public boolean isFinished() {
        return true; // use this.withTimeout(time)
    }

}