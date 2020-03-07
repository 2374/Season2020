package frc.robot.commands.magic;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;

public class ProcessStage extends CommandBase {

    private Indexer indexer;
    
    public ProcessStage(Indexer indexer) {
        this.indexer = indexer;
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        if (indexer.isEmpty(2, 3, 4)) {
            indexer.move(1, 0.50, 1);
        } else {
            for (int i = getHighestOpenStage() - 1; i > 0; i--) {
                if (indexer.isOccupied(i) && indexer.isEmpty(i + 1)) {
                    indexer.move(i, 0.50, 1);
                }
            }
        }
    }

    @Override
    public void end(boolean interrupted) {
        indexer.moveAll(0.0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    private int getHighestOpenStage() {
        for (int i = 4; i >= 1; i--) {
            if (indexer.isEmpty(i)) {
                return i;
            }
        }
        return -1;
    }

}