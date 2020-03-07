package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Climber;

public class MoveClimber extends CommandBase {

    private Climber climber;
    private double power;
    
    public MoveClimber(RobotContainer container, double power) {
        this.climber = container.getClimber(); 
        this.power = power;

        super.addRequirements(climber); 
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