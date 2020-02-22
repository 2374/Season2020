package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Finger extends SubsystemBase {

    private VictorSPX finger;
    private ColorSensorV3 colorSensor;

    public Finger() {
        this.finger = new VictorSPX(Constants.CLIMBER_FINGER_PORT);
        this.colorSensor = new ColorSensorV3(I2C.Port.kOnboard);
    }
    
    public void move(double power) {
        finger.set(ControlMode.PercentOutput, power); 
    }

} 