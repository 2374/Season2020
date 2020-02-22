package frc.robot.commands.magic;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Finger;

public class SpinToColor extends CommandBase {

    private Finger finger;
    private ColorSensorV3 colorSensor;
    private double power;
    private Color spinColor;

    private boolean isFinished;
    private int count;

    public SpinToColor(RobotContainer container, double power, Color spinColor) {
        this.finger = container.getFinger();
        this.colorSensor = container.getColorSensor();
        this.power = power;
        this.spinColor = spinColor;

        this.isFinished = false;
        this.count = 0;
    }

    @Override
    public void initialize() {
        isFinished = false;
    }

    @Override
    public void execute() {
        if (count < 3) {
            finger.move(power);
            if (colorSensor.getColor() == spinColor) {
                count++;
            }
        } else if (count == 3) {
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