package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Controller;
import frc.robot.subsystems.Drivetrain;

public class MoveRobot extends CommandBase {

    private Drivetrain drivetrain;
    private Controller controller;

    public MoveRobot(Drivetrain drivetrain, Controller controller) {
        this.drivetrain = drivetrain;
        this.controller = controller;

        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        drivetrain.arcadeDrive(controller.getJoystickLeftX(), controller.getJoystickLeftY());
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.tankDrive(0.0, 0.0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}