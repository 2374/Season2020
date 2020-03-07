package frc.robot.util;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants;

public class ControllerJoystick {

    private Joystick joystick;

    public ControllerJoystick() {
        this.joystick = new Joystick(Constants.JOYSTICK_CONTROLLER_PORT);
    }

    public boolean isPressed(int button) { return joystick.getRawButton(button); }

    public double getSlider() { return (1.0 - joystick.getRawAxis(Constants.JOYSTICK_CONTROLLER_SLIDER)); }

    public double getXAxis() { return Toolkit.deadZone(joystick.getRawAxis(Constants.JOYSTICK_CONTROLLER_X_AXIS), 0.1); }

    public double getYAxis() { return Toolkit.deadZone(joystick.getRawAxis(Constants.JOYSTICK_CONTROLLER_Y_AXIS), 0.1); }

    public double getZAxis() { return joystick.getRawAxis(Constants.JOYSTICK_CONTROLLER_Z_AXIS); }

    public Joystick getJoystick() { return joystick; }

}