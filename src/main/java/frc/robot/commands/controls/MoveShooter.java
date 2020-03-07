package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;

public class MoveShooter extends CommandBase {

    private Shooter shooter;
    private double power;
    private int rpm;

    public MoveShooter(RobotContainer container, double power) {
        this.shooter = container.getShooter();
        this.power = power;

        super.addRequirements(shooter);
    }

    public MoveShooter(RobotContainer container, int rpm) {
        this.shooter = container.getShooter();
        this.rpm = rpm;

        super.addRequirements(shooter);
    }

    @Override
    public void initialize() {
        System.out.println("Shooting at power : " + power);
    }

    @Override
    public void execute() {
        if (rpm != 0) {
            shooter.move(rpm, 1);
        } else {
            shooter.move(power, 1);
        }   
    }

    @Override
    public void end(boolean interrupted) {
        shooter.move(0.0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}