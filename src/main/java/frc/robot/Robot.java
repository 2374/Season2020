package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

  // Is there any real reason to have the bulk of the code in RobotContainer instead of moving
  // everything directly into Robot? It isn't reused anywhere, and having a seemingly unused
  // variable that needs to be kept alive is generally bad practice.
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
  public void teleopPeriodic() { }

  @Override
  public void testInit() { }

  @Override
  public void testPeriodic() { }

  @Override
  public void disabledInit() { }

  @Override
  public void disabledPeriodic() { }

}
