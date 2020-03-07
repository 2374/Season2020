package frc.robot.util;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants;

public class ControllerXbox {

    private XboxController controller;

    public ControllerXbox() {
        this.controller = new XboxController(Constants.XBOX_CONTROLLER_PORT);
    }

    public double getLeftXAxis() { return controller.getRawAxis(Constants.XBOX_CONTROLLER_LEFT_AXIS_X); }

    public double getLeftYAxis() { return controller.getRawAxis(Constants.XBOX_CONTROLLER_LEFT_AXIS_Y); }

    public double getRightXAxis() { return controller.getRawAxis(Constants.XBOX_CONTROLLER_RIGHT_AXIS_X); }

    public double getRightYAxis() { return controller.getRawAxis(Constants.XBOX_CONTROLLER_RIGHT_AXIS_Y); }

    public double getLeftTrigger() { return controller.getRawAxis(Constants.XBOX_CONTROLLER_LEFT_TRIGGER); }

    public double getRightTrigger() { return controller.getRawAxis(Constants.XBOX_CONTROLLER_RIGHT_TRIGGER); }

    public boolean getLeftBumper() { return controller.getRawButton(Constants.XBOX_CONTROLLER_LEFT_BUMPER); }

    public boolean getRightBumper() { return controller.getRawButton(Constants.XBOX_CONTROLLER_RIGHT_BUMPER); }

    public boolean getButtonA() { return controller.getRawButton(Constants.XBOX_CONTROLLER_BUTTON_A); }

    public boolean getButtonB() { return controller.getRawButton(Constants.XBOX_CONTROLLER_BUTTON_B); }

    public boolean getButtonX() { return controller.getRawButton(Constants.XBOX_CONTROLLER_BUTTON_X); }

    public boolean getButtonY() { return controller.getRawButton(Constants.XBOX_CONTROLLER_BUTTON_Y); }

    public boolean getButtonBack() { return controller.getRawButton(Constants.XBOX_CONTROLLER_BUTTON_BACK); }

    public boolean getButtonStart() { return controller.getRawButton(Constants.XBOX_CONTROLLER_BUTTON_START); }

    public boolean getButtonM1() { return controller.getRawButton(Constants.XBOX_CONTROLLER_BUTTON_M1); }

    public boolean getButtonM2() { return controller.getRawButton(Constants.XBOX_CONTROLLER_BUTTON_M2); }

    public XboxController getController() { return controller; }

}