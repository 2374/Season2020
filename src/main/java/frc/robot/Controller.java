package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class Controller {

    private XboxController controller;

    public Controller() {
		this.controller = new XboxController(Constants.CONTROLLER_PORT);
    }

    public double getJoystickLeftX() { return deadZone(controller.getRawAxis(Constants.CONTROLLER_LEFT_AXIS_X), 0.4); }
	
	public double getJoystickLeftY() { return deadZone(controller.getRawAxis(Constants.CONTROLLER_LEFT_AXIS_Y), 0.4); }

	public double getJoystickRightX() { return deadZone(controller.getRawAxis(Constants.CONTROLLER_RIGHT_AXIS_X), 0.4); }
	
	public double getJoystickRightY() { return deadZone(controller.getRawAxis(Constants.CONTROLLER_RIGHT_AXIS_Y), 0.4); }

	public double getLeftTrigger() { return deadZone(controller.getRawAxis(Constants.CONTROLLER_LEFT_TRIGGER), 0.4); }

	public double getRightTrigger() { return deadZone(controller.getRawAxis(Constants.CONTROLLER_RIGHT_TRIGGER), 0.5); }
	
	private double deadZone(double axisValue, double deadValue) {
		return Math.abs(axisValue) > deadValue ? axisValue : 0.0;
	}
	
	public XboxController getController() { return controller; }

}