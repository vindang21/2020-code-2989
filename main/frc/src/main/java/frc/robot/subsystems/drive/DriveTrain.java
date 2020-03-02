package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.TeleopDriveCommand;
import frc.robot.model.StarSubsystem;
import frc.robot.model.StarTalonSRX;

public class DriveTrain extends StarSubsystem {

    private StarTalonSRX leftMotor1;
    private StarTalonSRX leftMotor2;
    private StarTalonSRX rightMotor1;
    private StarTalonSRX rightMotor2;
    private GTADrive drive;

    public DriveTrain() {
        loadSpeedControllers();
        applySpeedControllerPreferences();
        loadDrive();
    }

    private void loadSpeedControllers() {
        leftMotor1 = new StarTalonSRX(RobotMap.DRIVETRAIN_MOTOR_LEFT_1);
        leftMotor2 = new StarTalonSRX(RobotMap.DRIVETRAIN_MOTOR_LEFT_2);
        rightMotor1 = new StarTalonSRX(RobotMap.DRIVETRAIN_MOTOR_RIGHT_1);
        rightMotor2 = new StarTalonSRX(RobotMap.DRIVETRAIN_MOTOR_RIGHT_2);

    }

    private void loadDrive() {
        drive = new GTADrive(new DifferentialDrive(new SpeedControllerGroup(leftMotor1, leftMotor2), new SpeedControllerGroup(rightMotor1, rightMotor2)), Robot.oi.getPrimaryJoystick(), RobotMap.OI_JOYSTICK_PRIMARY_LEFT_TRIGGER_PORT, RobotMap.OI_JOYSTICK_PRIMARY_RIGHT_TRIGGER_PORT, RobotMap.OI_JOYSTICK_PRIMARY_LEFT_Y_AXIS_PORT, RobotMap.OI_JOYSTICK_PRIMARY_RIGHT_X_AXIS_PORT);
    }

    private void applySpeedControllerPreferences() {
        leftMotor1.setMaxOutputFunction(() -> RobotMap.LEFT_MAX_OUTPUT);
        leftMotor2.setMaxOutputFunction(() -> RobotMap.LEFT_MAX_OUTPUT);
        rightMotor1.setMaxOutputFunction(() -> RobotMap.RIGHT_MAX_OUTPUT);
        rightMotor2.setMaxOutputFunction(() -> RobotMap.RIGHT_MAX_OUTPUT);
    }


    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new TeleopDriveCommand());
    }

    public GTADrive getDrive() {
        return drive;
    }
}
