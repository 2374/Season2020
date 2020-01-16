package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.Drivetrain;
import frc.robot.util.LimeLight;

public class Robot extends TimedRobot {

  private static Drivetrain drivetrain;
  private static LimeLight limelight;
  private static Controller controller;

  @Override
  public void robotInit() {
    drivetrain = new Drivetrain();
    limelight = new LimeLight();
    controller = new Controller();
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

  public static Drivetrain getDrivetrain() { return drivetrain; }

  public static LimeLight getLimeLight() { return limelight; }

  public static Controller getController() { return controller; }

}
