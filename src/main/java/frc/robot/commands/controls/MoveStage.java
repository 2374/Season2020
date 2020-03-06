package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;

public class MoveStage extends CommandBase {

    private Indexer indexer;
    private int stage;
    private double power;
    private int direction;

    public MoveStage(Indexer indexer, int stage, double power, int direction) {
        this.indexer = indexer;
        this.stage = stage;
        this.power = power;
        this.direction = direction;

        super.addRequirements(indexer);
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        indexer.move(stage, power, direction);
    }

    @Override
    public void end(boolean interrupted) {
        indexer.move(stage, 0.0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}