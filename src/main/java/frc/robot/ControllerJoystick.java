package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class ControllerJoystick {

    private Joystick joystick;

    public ControllerJoystick() {
        this.joystick = new Joystick(Constants.JOYSTICK_CONTROLLER_PORT);
    }

    public boolean isPressed(int button) { return joystick.getRawButton(button); }

    public double getSlider() { return (1.0 - joystick.getRawAxis(Constants.JOYSTICK_CONTROLLER_SLIDER)); }

    public double getXAxis() { return joystick.getRawAxis(Constants.JOYSTICK_CONTROLLER_X_AXIS); }

    public double getYAxis() { return joystick.getRawAxis(Constants.JOYSTICK_CONTROLLER_Y_AXIS); }

    public double getZAxis() { return joystick.getRawAxis(Constants.JOYSTICK_CONTROLLER_Z_AXIS); }

    public Joystick getJoystick() { return joystick; }

}