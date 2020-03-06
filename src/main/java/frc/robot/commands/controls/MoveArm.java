package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class MoveArm extends CommandBase {

    private Arm arm;
    private double power;

    public MoveArm(Arm arm, double power) {
        this.arm = arm;
        this.power = power;

        super.addRequirements(arm);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        arm.move(power);
    }

    @Override
    public void end(boolean interrupted) {
        arm.move(0.0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}