package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.controls.MoveShooter;

public class Robot extends TimedRobot {

  private RobotContainer container;

  @Override
  public void robotInit() {
    container = new RobotContainer();

    // SmartDashboard.putNumber("speed", 0.80);
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    container.getLimeLight().updateTracking();
  }

  @Override
  public void autonomousInit() { }

  @Override
  public void autonomousPeriodic() { }

  @Override
  public void teleopInit() { }

  @Override
  public void teleopPeriodic() {
    // MoveShooter shootCommand = new MoveShooter(container.getShooter(), 0.00);
    // if (container.getController().getLeftTrigger() > 0.80) {
    //   System.out.println("SCurrently set to : " + SmartDashboard.getNumber("speed", 0.01));
    //   shootCommand = new MoveShooter(container.getShooter(), SmartDashboard.getNumber("speed", 0.01));
    //   shootCommand.schedule();
    // } else {
    //   CommandScheduler.getInstance().cancelAll();
    // }

    //container.getDrivetrain().tankDrive(-container.getController().getJoystickLeftY() / 2.0, -container.getController().getJoystickRightY() / 2.0);
    //container.getDrivetrain().arcadeDrive(-container.getController().getJoystickLeftY(), container.getController().getJoystickLeftX());
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
