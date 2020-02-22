package frc.robot.commands.automate.indexer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;

public class MoveStageMagic extends CommandBase {

    private Indexer indexer;

    public MoveStageMagic(Indexer indexer) {
        this.indexer = indexer;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        // for (int i = 4; i >= 1; i--) {
        //     if (indexer.isEmpty(i)) {
        //         for (int k = i - 1; k >= 1; k++) {
                    
        //         }
        //     }
        // }

        // System.out.println("---");
        // System.out.println("1 occupied: " + indexer.isOccupied(1));
        // System.out.println("2 occupied: " + indexer.isOccupied(2));
        // System.out.println("3 occupied: " + indexer.isOccupied(3));
        // System.out.println("4 occupied: " + indexer.isOccupied(4));
        // System.out.println("---");
        // if (indexer.isEmpty()) {
        //     System.out.println("Indexer empty");
        //     indexer.move(0.0, 2, 3, 4);
        //     indexer.move(1, 0.50);
        // } else if (indexer.isOccupied(1) && indexer.isEmpty(2, 3, 4)) {
        //     System.out.println("O: 1,      E: 2, 3, 4");
        //     indexer.move(0.0, 3, 4);
        //     indexer.move(1, 0.2);
        //     indexer.move(2, 0.2);
        // } else if (indexer.isOccupied(1, 2) && indexer.isEmpty(3, 4)) {
        //     System.out.println("O: 1, 2    E: 3, 4");
        //     indexer.move(0.0, 1);
        //     indexer.move(3, 0.2);
        //     indexer.move(2, 0.2);
        //     indexer.move(1, 0.2);
        // } else if (indexer.isEmpty(1) && indexer.isOccupied(2, 3, 4)) {
        //     System.out.println("O: 2, 3, 4 E: 1");
        //     indexer.move(0.0, 2, 3, 4);
        //     indexer.move(1, 0.2);
        // } else if (indexer.isOccupied(2, 4) && indexer.isEmpty(1, 3)) {
        //     System.out.println("O: 2, 4    E: 1, 3");
        //     indexer.move(1, 0.2);
        // } else if (indexer.isOccupied(2) && indexer.isEmpty(1, 3, 4)) {
        //     System.out.println("O: 2       E: 1, 3, 4");
        //     indexer.move(1, 0.2);
        // } else if (indexer.isOccupied(2, 3) && indexer.isEmpty(1, 4)) {
        //     indexer.move(3, 0.2);
        //     indexer.move(2, 0.2);
        //     indexer.move(1, 0.2);
        // } else if (indexer.isFull()) {
        //     System.out.println("Indexer full");
        //     indexer.moveAll(0.0);
        // } else {
        //     System.out.println("---");
        //     System.out.println("1 occupied: " + indexer.isOccupied(1));
        //     System.out.println("2 occupied: " + indexer.isOccupied(2));
        //     System.out.println("3 occupied: " + indexer.isOccupied(3));
        //     System.out.println("4 occupied: " + indexer.isOccupied(4));
        //     System.out.println("---");
            //indexer.moveAll(0.0);
            // this might cause false positives during testing
    //     }
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