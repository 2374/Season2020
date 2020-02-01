package frc.robot;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;
import frc.robot.util.LimeLight;

public class RobotContainer {

  private Drivetrain drivetrain;
  private Shooter shooter;
  private Turret turret;
  private Intake intake;
  private LimeLight limelight;
  private Controller controller;

  public RobotContainer() {
    this.drivetrain = new Drivetrain();
    this.shooter = new Shooter();
    this.turret = new Turret();
    this.intake = new Intake();
    this.limelight = new LimeLight();
    this.controller = new Controller();

    configureButtonBindings();
  }

  private void configureButtonBindings() {
    
  }

  public Drivetrain getDrivetrain() {
    return drivetrain;
  }

  public Shooter getShooter() {
    return shooter;
  }

  public Controller getController() {
    return controller;
  }

}
