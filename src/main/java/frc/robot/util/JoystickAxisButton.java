package frc.robot.util;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.Button;

public class JoystickAxisButton extends Button {

    private GenericHID joystick;
    private int axisNumber;
    private double threshold = 0.0;

    public JoystickAxisButton(GenericHID joystick, int axisNumber) {
        this.joystick = joystick;
        this.axisNumber = axisNumber;
    }

    public JoystickAxisButton(GenericHID joystick, int axisNumber, double threshold) {
        this(joystick, axisNumber);
        this.threshold = threshold;
    }

    public boolean get() {
        return (Math.abs(joystick.getRawAxis(axisNumber)) > threshold);
    }

}