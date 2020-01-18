package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

public class MoveIntake extends CommandBase {

    private Intake intake;
    private int direction;

    public MoveIntake(Intake intake, int direction) {
        this.intake = intake;
        this.direction = direction;

        addRequirements(intake);
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        intake.move(Constants.SPEED_INTAKE, direction);
    }

    @Override
    public void end(boolean interrupted) {
        intake.move(0.0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}