package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.controls.MoveRobot;
import frc.robot.commands.controls.MoveShooter;
import frc.robot.commands.controls.MoveTurret;
import frc.robot.commands.magic.TurretToTarget;
import frc.robot.commands.magic.DeployBall;
import frc.robot.commands.TempShooter;
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

    buttonB.whenHeld(new MoveTurret(turret, 0.2, 1));
    buttonX.whenHeld(new MoveTurret(turret, 0.2, -1));
    buttonStart.whenPressed(new TurretToTarget(turret, limelight));
    leftTrigger.whileHeld(new TempShooter(shooter));
    buttonBack.whenPressed(new TestCommand(shooter, limelight));
    buttonY.whenPressed(new DeployBall(turret, shooter, limelight));

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
