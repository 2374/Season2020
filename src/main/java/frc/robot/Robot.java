package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

  private RobotContainer container;

  @Override
  public void robotInit() {
    container = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() { }

  @Override
  public void autonomousPeriodic() { }

  @Override
  public void teleopInit() { }

  @Override
  public void teleopPeriodic() {
    container.getDrivetrain().arcadeDrive(container.getController().getJoystickLeftX(), container.getController().getJoystickLeftY());
  }

  @Override
  public void testInit() { }

  @Override
  public void testPeriodic() { }

  @Override
  public void disabledInit() { }

  @Override
  public void disabledPeriodic() { }

}
