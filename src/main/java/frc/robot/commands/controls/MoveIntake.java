package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

public class MoveIntake extends CommandBase {

    private Intake intake;
    private int direction;

    // Should direction be clamped in the range [-1, 1]?
    public MoveIntake(Intake intake, int direction) {
        this.intake = intake;
        this.direction = direction;

        addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.move(Constants.SPEED_INTAKE, direction);
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        // I think the 0.0 is superfluous when passing to a method - just "0" should be fine.
        // This applies here and everywhere else in this project.
        intake.move(0.0, 0);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}