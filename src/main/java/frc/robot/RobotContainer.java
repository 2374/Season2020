package frc.robot;

import frc.robot.commands.magic.FindTarget;
import frc.robot.commands.controls.MoveIntake;
import frc.robot.commands.controls.MoveShooter;
import frc.robot.commands.controls.MoveTurret;
import frc.robot.commands.auto.MoveForward;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;
import frc.robot.util.LimeLight;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  private Drivetrain drivetrain;
  private Shooter shooter;
  private Turret turret;
  private Intake intake;
  private LimeLight limelight;
  private Controller controller;

  private MoveForward moveForwardCommand;

  public RobotContainer() {
    this.drivetrain = new Drivetrain();
    this.shooter = new Shooter();
    this.turret = new Turret();
    this.intake = new Intake();
    this.limelight = new LimeLight();
    this.controller = new Controller();

    this.moveForwardCommand = new MoveForward(drivetrain);

    configureButtonBindings();
  }

  private void configureButtonBindings() {
    JoystickButton leftBumper = new JoystickButton(controller.getController(), Constants.CONTROLLER_LEFT_BUMPER);
    JoystickButton rightBumper = new JoystickButton(controller.getController(), Constants.CONTROLLER_RIGHT_BUMPER);
    JoystickButton leftTrigger = new JoystickButton(controller.getController(), Constants.CONTROLLER_LEFT_TRIGGER);
    JoystickButton rightTrigger = new JoystickButton(controller.getController(), Constants.CONTROLLER_RIGHT_TRIGGER);
    JoystickButton buttonX = new JoystickButton(controller.getController(), Constants.CONTROLLER_BUTTON_X);
    JoystickButton buttonB = new JoystickButton(controller.getController(), Constants.CONTROLLER_BUTTON_B);

    leftBumper.whileHeld(new MoveIntake(intake, 1));
    rightBumper.whileHeld(new MoveIntake(intake, -1));

    leftTrigger.whenPressed(new MoveTurret(turret, controller.getLeftTrigger(), 1));
    rightTrigger.whenPressed(new MoveTurret(turret, controller.getRightTrigger(), -1));

    buttonX.whenPressed(new MoveShooter(shooter));
    buttonB.whenPressed(new FindTarget(limelight));
  }

  public Command getMoveForwardAutonomousCommand() {
    return moveForwardCommand;
  }

  public Drivetrain getDrivetrain() {
    return drivetrain;
  }

  public Controller getController() {
    return controller;
  }

}
