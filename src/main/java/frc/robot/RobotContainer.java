package frc.robot;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.controls.MoveClimber;
import frc.robot.commands.controls.MoveFinger;
import frc.robot.commands.controls.MoveIndexer;
import frc.robot.commands.controls.MoveIntake;
import frc.robot.commands.controls.MoveStage;
import frc.robot.commands.controls.MoveTurret;
import frc.robot.commands.magic.SpinToColor;
import frc.robot.commands.magic.SpinToRevolutions;
import frc.robot.commands.automate.AutomateShooter;
import frc.robot.commands.automate.indexer.ProcessStage;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Finger;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;
import frc.robot.util.LimeLight;

public class RobotContainer {

  private Drivetrain drivetrain;
  private Intake intake;
  private Indexer indexer;
  private Turret turret;
  private Shooter shooter;
  private Finger finger;
  private Climber climber;
  private ColorSensorV3 colorSensor;
  private LimeLight limelight;
  private ControllerXbox xboxController;
  private ControllerJoystick joystickController;

  public RobotContainer() {
    this.drivetrain = new Drivetrain();
    this.intake = new Intake();
    this.indexer = new Indexer();
    this.turret = new Turret();
    this.shooter = new Shooter();
    this.climber = new Climber();
    this.colorSensor = new ColorSensorV3(I2C.Port.kOnboard);
    this.limelight = new LimeLight();
    this.xboxController = new ControllerXbox();
    this.joystickController = new ControllerJoystick();

    configureButtonBindings();
  }

  private void configureButtonBindings() {
    XboxController xbox = getXboxController().getController();
    Joystick joystick = getJoystickController().getJoystick();

    JoystickButton button1 = new JoystickButton(joystick, Constants.JOYSTICK_CONTROLLER_BUTTON_1);
    JoystickButton button2 = new JoystickButton(joystick, Constants.JOYSTICK_CONTROLLER_BUTTON_2);
    JoystickButton button3 = new JoystickButton(joystick, Constants.JOYSTICK_CONTROLLER_BUTTON_3);
    JoystickButton button4 = new JoystickButton(joystick, Constants.JOYSTICK_CONTROLLER_BUTTON_4);
    JoystickButton button5 = new JoystickButton(joystick, Constants.JOYSTICK_CONTROLLER_BUTTON_5);
    JoystickButton button6 = new JoystickButton(joystick, Constants.JOYSTICK_CONTROLLER_BUTTON_6);
    JoystickButton button7 = new JoystickButton(joystick, Constants.JOYSTICK_CONTROLLER_BUTTON_7);
    JoystickButton button8 = new JoystickButton(joystick, Constants.JOYSTICK_CONTROLLER_BUTTON_8);
    JoystickButton button9 = new JoystickButton(joystick, Constants.JOYSTICK_CONTROLLER_BUTTON_9);
    JoystickButton button10 = new JoystickButton(joystick, Constants.JOYSTICK_CONTROLLER_BUTTON_10);
    JoystickButton button11 = new JoystickButton(joystick, Constants.JOYSTICK_CONTROLLER_BUTTON_11);
    JoystickButton button12 = new JoystickButton(joystick, Constants.JOYSTICK_CONTROLLER_BUTTON_12);

    JoystickButton buttonX = new JoystickButton(xbox, Constants.XBOX_CONTROLLER_BUTTON_X);
    JoystickButton buttonY = new JoystickButton(xbox, Constants.XBOX_CONTROLLER_BUTTON_Y);
    JoystickButton buttonA = new JoystickButton(xbox, Constants.XBOX_CONTROLLER_BUTTON_A);
    JoystickButton buttonB = new JoystickButton(xbox, Constants.XBOX_CONTROLLER_BUTTON_B);

    JoystickButton backButton = new JoystickButton(xbox, Constants.XBOX_CONTROLLER_BUTTON_BACK);
    JoystickButton startButton = new JoystickButton(xbox, Constants.XBOX_CONTROLLER_BUTTON_START);
    JoystickButton leftBumper = new JoystickButton(xbox, Constants.XBOX_CONTROLLER_LEFT_BUMPER);

    button1.whileHeld(new MoveIntake(intake, Constants.SPEED_INTAKE, 1));
    button2.whileHeld(new MoveIntake(intake, Constants.SPEED_INTAKE, -1));

    button3.whenPressed(new AutomateShooter(joystickController, turret, shooter, limelight, indexer, intake));
    button4.whileHeld(new ProcessStage(indexer));
    button5.whileHeld(new MoveTurret(turret, Constants.SPEED_TURRET, -1));
    button6.whileHeld(new MoveTurret(turret, Constants.SPEED_TURRET, 1));
    button7.whileHeld(new MoveStage(indexer, 3, Constants.SPEED_INDEXER_STAGE_3, 1));
    button8.whileHeld(new MoveStage(indexer, 2, Constants.SPEED_INDEXER_STAGE_2, -1));
    button9.whileHeld(new MoveStage(indexer, 2, Constants.SPEED_INDEXER_STAGE_2, 1));
    button10.whileHeld(new MoveStage(indexer, 4, Constants.SPEED_INDEXER_STAGE_4, 1));
    button11.whileHeld(new MoveStage(indexer, 1, Constants.SPEED_INDEXER_STAGE_1, 1));
    button12.whileHeld(new MoveIndexer(indexer, Constants.SPEED_INDEXER, 1));

    backButton.whileHeld(new MoveFinger(finger, Constants.SPEED_FINGER));
    startButton.whileHeld(new MoveClimber(climber, Constants.SPEED_CLIMBER));

    buttonA.whenPressed(new SpinToColor(this, Constants.SPEED_FINGER, Color.kGreen));
    buttonB.whenPressed(new SpinToColor(this, Constants.SPEED_FINGER, Color.kRed));
    buttonX.whenPressed(new SpinToColor(this, Constants.SPEED_FINGER, Color.kBlue));
    buttonY.whenPressed(new SpinToColor(this, Constants.SPEED_FINGER,  Color.kYellow));

    leftBumper.whenPressed(new SpinToRevolutions(this, Constants.SPEED_FINGER, 4));
  }

  public Drivetrain getDrivetrain() { return drivetrain; }

  public Intake getIntake() { return intake; }

  public Indexer getIndexer() { return indexer; }

  public Turret getTurret() { return turret; }

  public Shooter getShooter() { return shooter; }

  public Finger getFinger() { return finger; }

  public Climber getClimber() { return climber; }

  public ColorSensorV3 getColorSensor() { return colorSensor; }
  
  public LimeLight getLimeLight() { return limelight; }

  public ControllerXbox getXboxController() { return xboxController; }

  public ControllerJoystick getJoystickController() { return joystickController; }

}
