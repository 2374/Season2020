package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Indexer extends SubsystemBase {

    private TalonSRX stage1;
    private TalonSRX stage2;
    private TalonSRX stage3;
    private TalonSRX stage4;
    private DigitalInput stage1Sensor;
    private DigitalInput stage2Sensor;
    private DigitalInput stage3Sensor;
    private DigitalInput stage4Sensor;

    public Indexer() {
        this.stage1 = new TalonSRX(Constants.INDEXER_UPPER_MOTOR_1_PORT);
        this.stage2 = new TalonSRX(Constants.INDEXER_LOWER_MOTOR_1_PORT);
        this.stage3 = new TalonSRX(Constants.INDEXER_UPPER_MOTOR_2_PORT);
        this.stage4 = new TalonSRX(Constants.INDEXER_LOWER_MOTOR_2_PORT);

        this.stage1Sensor = new DigitalInput(Constants.SENSOR_STAGE_1_PORT);
        this.stage2Sensor = new DigitalInput(Constants.SENSOR_STAGE_2_PORT);
        this.stage3Sensor = new DigitalInput(Constants.SENSOR_STAGE_3_PORT);
        this.stage4Sensor = new DigitalInput(Constants.SENSOR_STAGE_4_PORT);

        stage4.setInverted(true);
    }

    public void move(int stage, double power, int direction) {
        switch (stage) {
            case 1:
                stage1.set(ControlMode.PercentOutput, power * direction);
                break;
            case 2:
                stage2.set(ControlMode.PercentOutput, power * direction);
                break;
            case 3:
                stage3.set(ControlMode.PercentOutput, power * direction);
                break;
            case 4:
                stage4.set(ControlMode.PercentOutput, power * direction);
                break;
        }
    }

    public void move(double power, int direction, int... stages) {
        for (int stage : stages) {
            move(stage, power, direction);
        }
    }

    public void moveAll(double power, int direction) {
        move(1, power, direction);
        move(2, power, direction);
        move(3, power, direction);
        move(4, power, direction);
    }

    public boolean isEmpty(int... stages) {
        for (int stage : stages) {
            if (isOccupied(stage)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty(int stage) {
        switch (stage) {
            case 1: return stage1Sensor.get();
            case 2: return stage2Sensor.get();
            case 3: return stage3Sensor.get();
            case 4: return stage4Sensor.get();
        }
        return true;
    }

    public boolean isOccupied(int stage) {
        switch (stage) {
            case 1: return !stage1Sensor.get();
            case 2: return !stage2Sensor.get();
            case 3: return !stage3Sensor.get();
            case 4: return !stage4Sensor.get();
        }
        return false;
    }

    public boolean isOccupied(int... stages) {
        for (int stage : stages) {
            if (isEmpty(stage)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return isEmpty(1) && isEmpty(2) && isEmpty(3) && isEmpty(4);
    }

    public boolean isFull() {
        return isOccupied(1) && isOccupied(2) && isOccupied(3) && isOccupied(4);
    }

    public int getBallCount() {
        int count = 0;
        for (int i = 1; i <= 4; i++) {
            if (!isEmpty(i)) {
                count++;
            }
        }
        return count;
    }

}