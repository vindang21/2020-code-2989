package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.RobotMap;
import frc.robot.model.SolenoidGroup;
import frc.robot.model.StarSubsystem;

import java.util.stream.Stream;

public class Intake extends StarSubsystem {

    private Solenoid hatchPistons;
    private SpeedControllerGroup intakeMotors;

    public Intake() {                  
        if(RobotMap.MODULES_PNEUMATICS_ENABLED && RobotMap.MODULES_INTAKE_ENABLED) {               
            loadPistons();
        }
        if(RobotMap.MODULES_INTAKE_ENABLED) {
            loadMotors();
        }
    }

    private void loadPistons() {
        hatchPistons = new Solenoid(RobotMap.INTAKE_SOLENOID_LEFT_PORT);
    }

    private void loadMotors() {
        SpeedController left = new PWMTalonSRX(RobotMap.RAMP_MOTOR_LEFT_PORT);
        SpeedController right =  new PWMTalonSRX((RobotMap.RAMP_MOTOR_RIGHT_PORT)); // better than left
        intakeMotors = new SpeedControllerGroup(left, right);
    }

    public void setHatchPistons(boolean state) {
        if(hatchPistons != null && RobotMap.MODULES_PNEUMATICS_ENABLED) {
            hatchPistons.set(state);
        }
    }

    public void setIntakeMotors(double value) {
        if(intakeMotors != null && RobotMap.MODULES_INTAKE_ENABLED) {
            intakeMotors.set(value);
        }
    }

    @Override
    protected void initDefaultCommand() {}

    public Solenoid getHatchPistons() {
        return hatchPistons;
    }

    public double getLoopPressure() {
        return 0.0;
    }
}
