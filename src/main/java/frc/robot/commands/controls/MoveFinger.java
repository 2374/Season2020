package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Finger;

public class MoveFinger extends CommandBase {

    private Finger finger;
    private double power;

    public MoveFinger(Finger finger, double power) {
        this.finger = finger;
        this.power = power;
        
        super.addRequirements(finger);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        finger.move(power);
    }

    @Override
    public void end(boolean interrupted) {
        finger.move(0.0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}