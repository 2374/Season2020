package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class MoveClimber extends CommandBase {

    private Climber climber;
    private double power;
    
    public MoveClimber(Climber climber, double power) {
        this.climber = climber; 
        this.power = power;

        addRequirements(climber); 
    }
    
    public void initialize() {

    }
    
    public void execute() {
        climber.move(power);
    }

    @Override
    public void end(boolean interrupted) {
        climber.move(0.0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}