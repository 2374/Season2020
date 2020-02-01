// accounted for the change in the angle

package frc.robot.util;

import edu.wpi.first.networktables.NetworkTableInstance;

public class LimeLight {

    private boolean hasValidTarget = false;
    private double throttleValue = 0.0;
    private double horizontalTargetAngle = 0.0;
    private double verticalTargetAngle = 0.0;

    static final double LIMELIGHT_HEIGHT_CM = 62.865; //h1
    static final double TARGET_HEIGHT_CM = 206.0; //h2
    static final double LIMELIGHT_MOUNTING_ANGLE = 11.0; //a1
    
    public void updateTracking() {

        // These numbers must be tuned for your Robot!  Be careful!
        final double STEER_K = 0.03;                    // how hard to turn toward the target
        final double DRIVE_K = 0.26;                    // how hard to drive fwd toward the target
        final double DESIRED_TARGET_AREA = 13.0;        // Area of the target when the robot reaches the wall
        //final double DESIRED_TARGET_AREA = 23.0;        // Area of the target when the robot reaches the wall
        final double MAX_DRIVE = 0.7;                   // Simple speed limit so we don't drive too fast
        
        // for horizontal alignment limelight pipeline 1 is the ball, pipeline two is the hatch 
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(1); // change the setNumber to the appropriate target
        final double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
        final double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
        final double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
        final double ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);

        if (tv < 1.0) {
            hasValidTarget = false;
            throttleValue = 0.0;
            horizontalTargetAngle = 0.0;
            verticalTargetAngle = 0.0;
            return;
        }

        hasValidTarget = true;

        // Start with proportional steering
        final double steer_cmd = tx * STEER_K;
        horizontalTargetAngle = steer_cmd;
        verticalTargetAngle = ty;
  
        // try to drive forward until the target area reaches our desired area
        // This should be replaced by LIDAR call
        double drive_cmd = (DESIRED_TARGET_AREA - ta) * DRIVE_K;

        // don't let the robot drive too fast into the goal
        if (drive_cmd > MAX_DRIVE)
        {
            drive_cmd = MAX_DRIVE;
        }
        throttleValue = drive_cmd;

    }

    public double calculateDistance() {
        double distance = 0.0;
        System.out.println("    ");
        System.out.println("A1: " + LIMELIGHT_MOUNTING_ANGLE);
        System.out.println("A2: " + this.getVerticalTargetAngle());
        System.out.println("H2: " + TARGET_HEIGHT_CM);
        System.out.println("H1: " + LIMELIGHT_HEIGHT_CM);
        
        double differenceDistance = TARGET_HEIGHT_CM - LIMELIGHT_HEIGHT_CM;
        double denom = Math.tan(Math.toRadians(this.getVerticalTargetAngle()));
        double denomTest = Math.toDegrees(denom);
        distance = differenceDistance / denom;
        
        System.out.println("h2 - h1: " + differenceDistance);
        System.out.println("Tan: " + denom);
        System.out.println("Testing tan " + denomTest);
        System.out.println("D: " + distance);
        System.out.println("    ");
        return distance;
    }

    public double getVerticalTargetAngle() { return this.verticalTargetAngle; }

    public boolean hasValidTarget() { return hasValidTarget; }

    public double getThrottleValue() { return throttleValue; }
    
    public double getTurnValue() { return horizontalTargetAngle; }

}