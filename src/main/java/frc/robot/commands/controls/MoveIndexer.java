package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;

public class MoveIndexer extends CommandBase {

    private Indexer indexer;
    private double power;
    private int direction;
    private Shooter shooter;

    public MoveIndexer(Indexer indexer, double power, int direction, Shooter shooter) {
        this.indexer = indexer;
        this.power = power;
        this.direction = direction;
        this.shooter = shooter;

        super.addRequirements(indexer);
        super.addRequirements(shooter);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        indexer.moveAll(power, direction);
        shooter.move(0.8, 1);
    }

    @Override
    public void end(boolean interrupted) {
        indexer.moveAll(0.0, 0);
        shooter.move(0.0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}