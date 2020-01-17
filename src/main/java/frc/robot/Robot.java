package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;
import frc.robot.util.LimeLight;

public class Robot extends TimedRobot {

  private static Drivetrain drivetrain;
  private static Shooter shooter;
  private static Turret turret;
  private static Intake intake;
  private static LimeLight limelight;
  private static Controller controller;

  @Override
  public void robotInit() {
    drivetrain = new Drivetrain();
    shooter = new Shooter();
    turret = new Turret();
    intake = new Intake();
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

  public static Shooter getShooter() { return shooter; }

  public static Turret getTurret() { return turret; }

  public static Intake getIntake() { return intake; }

  public static LimeLight getLimeLight() { return limelight; }

  public static Controller getController() { return controller; }

}
