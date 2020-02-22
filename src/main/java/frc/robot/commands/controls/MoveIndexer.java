package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;

public class MoveIndexer extends CommandBase {

    private Indexer indexer;
    private double power;
    private int direction;

    public MoveIndexer(Indexer indexer, double power, int direction) {
        this.indexer = indexer;
        this.power = power;
        this.direction = direction;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        indexer.moveAll(power, direction);
    }

    @Override
    public void end(boolean interrupted) {
        indexer.moveAll(0.0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}