package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Finger extends SubsystemBase {

    private VictorSPX finger;

    public Finger() {
        this.finger = new VictorSPX(Constants.CLIMBER_FINGER_PORT);
    }
    
    public void move(double power) {
        finger.set(ControlMode.PercentOutput, power); 
    }

} 