package frc.robot.commands.magic;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Finger;

public class SpinToRevolutions extends CommandBase {

    private Finger finger;
    private ColorSensorV3 colorSensor;
    private double power;
    private int revolutions;
    private int count;
    private boolean isFinished;

    public SpinToRevolutions(RobotContainer container, double power, int revolutions) {
        this.finger = container.getFinger();
        this.colorSensor = container.getColorSensor();
        this.power = power;
        this.revolutions = revolutions;
        this.count = 0;
        this.isFinished = false;
    }

    @Override
    public void initialize() {
        isFinished = false;
    }

    @Override
    public void execute() {
        if (count < (3 * revolutions)) {
            finger.move(power);
            if (colorSensor.getColor() == Color.kYellow) {
                count++;
            }
        } else if (count == (3 * revolutions)) {
            isFinished = true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        finger.move(0.0);
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

}