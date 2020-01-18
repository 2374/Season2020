package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class Controller {

    private XboxController controller;

    public Controller() {
		this.controller = new XboxController(Constants.CONTROLLER_PORT);
    }

	// This applies everywhere, but you should pick a style guide and stick with it. Consistent
	// line length, naming, etc. does more than you'd expect for long-term maintainability,
	// particularly as team members change. I imagine VS Code has plugins for automatically
	// catching and fixing style issues for common standards.

	// Magic numbers should be moved to well-named constants, or at the very least, should have
	// comments explaining why they were chosen.
    public double getJoystickLeftX() { return deadZone(controller.getRawAxis(Constants.CONTROLLER_LEFT_AXIS_X), 0.4); }
	
	public double getJoystickLeftY() { return deadZone(controller.getRawAxis(Constants.CONTROLLER_LEFT_AXIS_Y), 0.4); }

	public double getJoystickRightX() { return deadZone(controller.getRawAxis(Constants.CONTROLLER_RIGHT_AXIS_X), 0.4); }
	
	public double getJoystickRightY() { return deadZone(controller.getRawAxis(Constants.CONTROLLER_RIGHT_AXIS_Y), 0.4); }

	public double getLeftTrigger() { return deadZone(controller.getRawAxis(Constants.CONTROLLER_LEFT_TRIGGER), 0.4); }

	public double getRightTrigger() { return deadZone(controller.getRawAxis(Constants.CONTROLLER_RIGHT_TRIGGER), 0.5); }
	
	public boolean getLeftBumper() { return controller.getRawButton(Constants.CONTROLLER_LEFT_BUMPER); }

	public boolean getRightBumper() { return controller.getRawButton(Constants.CONTROLLER_RIGHT_BUMPER); }

	public boolean getButtonA() { return controller.getRawButton(Constants.CONTROLLER_BUTTON_A); }
	
	public boolean getButtonB() { return controller.getRawButton(Constants.CONTROLLER_BUTTON_B); }

	public boolean getButtonX() { return controller.getRawButton(Constants.CONTROLLER_BUTTON_X); }

	public boolean getButtonY() { return controller.getRawButton(Constants.CONTROLLER_BUTTON_Y); }

	public boolean getButtonBack() { return controller.getRawButton(Constants.CONTROLLER_BUTTON_BACK); }
	
	public boolean getButtonStart() { return controller.getRawButton(Constants.CONTROLLER_BUTTON_START); }

	public boolean getButtonM1() { return controller.getRawButton(Constants.CONTROLLER_BUTTON_M1); }

	public boolean getButtonM2() { return controller.getRawButton(Constants.CONTROLLER_BUTTON_M2); }

	// Could be condensed into a one liner using the ternary operator, although it's up to you
	// which to use.
	// return Math.abs(axisValue) > deadValue ? axisValue : 0;
	private double deadZone(double axisValue, double deadValue) {
		if (Math.abs(axisValue) > deadValue) {
			return axisValue;
		}
		return 0.0;
	}
	
	public XboxController getController() { return controller; }

}