package frc.robot;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.controls.MoveRobot;
import frc.robot.commands.controls.MoveShooter;
import frc.robot.commands.controls.MoveTurret;
import frc.robot.commands.magic.AdjustToTarget;
import frc.robot.commands.magic.TestCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;
import frc.robot.util.JoystickAxisButton;
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
    JoystickButton buttonA = new JoystickButton(controller.getController(), Constants.CONTROLLER_BUTTON_A);
    JoystickButton buttonB = new JoystickButton(controller.getController(), Constants.CONTROLLER_BUTTON_B);
    JoystickButton buttonX = new JoystickButton(controller.getController(), Constants.CONTROLLER_BUTTON_X);
    JoystickButton buttonY = new JoystickButton(controller.getController(), Constants.CONTROLLER_BUTTON_Y);
    JoystickButton buttonM1 = new JoystickButton(controller.getController(), Constants.CONTROLLER_BUTTON_M1);
    JoystickButton buttonM2 = new JoystickButton(controller.getController(), Constants.CONTROLLER_BUTTON_M2);
    JoystickButton leftBumper = new JoystickButton(controller.getController(), Constants.CONTROLLER_LEFT_BUMPER);
    JoystickButton rightBumper = new JoystickButton(controller.getController(), Constants.CONTROLLER_RIGHT_BUMPER);
    JoystickButton buttonStart = new JoystickButton(controller.getController(), Constants.CONTROLLER_BUTTON_START);
    JoystickButton buttonBack = new JoystickButton(controller.getController(), Constants.CONTROLLER_BUTTON_BACK);

    JoystickAxisButton leftTrigger = new JoystickAxisButton(controller.getController(), Constants.CONTROLLER_LEFT_TRIGGER);
    JoystickAxisButton leftYAxis = new JoystickAxisButton(controller.getController(), Constants.CONTROLLER_LEFT_AXIS_Y, 0.1);

    buttonB.whenHeld(new MoveTurret(turret, 0.1, 1));
    buttonX.whenHeld(new MoveTurret(turret, 0.1, -1));
    buttonStart.whenPressed(new AdjustToTarget(turret, limelight));
    leftTrigger.whileHeld(new MoveShooter(shooter, controller.getLeftTrigger()));
    buttonBack.whenPressed(new TestCommand(shooter, limelight));

    buttonA.whenHeld(new MoveShooter(shooter, 0.80));
    buttonY.whenHeld(new MoveShooter(shooter, 0.85));
    buttonM1.whenHeld(new MoveShooter(shooter, 0.87));
    buttonM2.whenHeld(new MoveShooter(shooter, 0.90));
    leftBumper.whenHeld(new MoveShooter(shooter, 0.95));
    rightBumper.whenHeld(new MoveShooter(shooter, 1.0));

    //leftYAxis.whileHeld(new TestCommand(controller));
    //leftYAxis.whileHeld(new MoveRobot(drivetrain, controller.getJoystickLeftY(), controller.getJoystickLeftX(), false));
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
  
  public LimeLight getLimeLight() {
    return limelight;
  }

}
