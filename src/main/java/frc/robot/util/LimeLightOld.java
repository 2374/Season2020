package frc.robot.util;

import edu.wpi.first.networktables.NetworkTableInstance;

public class LimeLightOld {

    private double throttleValue;
    private double turnValue;
    private boolean hasValidTarget;

    public void updateTracking() {

        // These numbers must be tuned for your Robot!  Be careful!
        final double STEER_K = 0.03;                    // how hard to turn toward the target
        final double DRIVE_K = 0.26;                    // how hard to drive fwd toward the target
        final double DESIRED_TARGET_AREA = 13.0;        // Area of the target when the robot reaches the wall
        final double MAX_DRIVE = 0.7;                   // Simple speed limit so we don't drive too fast

        double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
        double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
        //double ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
        double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);

        if (tv < 1.0)
        {
            hasValidTarget = false;
            throttleValue = 0.0;
            turnValue = 0.0;
            return;
        }

        hasValidTarget = true;

        // Start with proportional steering
        double steer_cmd = tx * STEER_K;
        turnValue = steer_cmd;

        // try to drive forward until the target area reaches our desired area
        double drive_cmd = (DESIRED_TARGET_AREA - ta) * DRIVE_K;

        // don't let the robot drive too fast into the goal
        if (drive_cmd > MAX_DRIVE)
        {
            drive_cmd = MAX_DRIVE;
        }
        throttleValue = drive_cmd;

    }

    public double getThrottleValue() { return throttleValue; }

    public double getTurnValue() { return turnValue; }

    public boolean hasValidTarget() { return hasValidTarget; }

}