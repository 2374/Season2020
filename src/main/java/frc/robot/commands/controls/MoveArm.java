package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Arm;

public class MoveArm extends CommandBase {

    private Arm arm;
    private double power;

    public MoveArm(RobotContainer container, double power) {
        this.arm = container.getArm();
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