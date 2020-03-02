package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

public class GTADrive {

    private DifferentialDrive drive;
    private Joystick stick;
    private int leftTriggerPort;
    private int rightTriggerPort;
    private int leftYAxis;
    private int rightXAxis;

    /**
     * Construct a GTADrive. All of the parameters are based on the diagram in the README file using an xbox controller.
     * @param drive The DifferentialDrive to use
     * @param stick The Joystick that you will be getting your input from
     * @param leftTriggerPort The button number for the left trigger of the Joystick
     * @param rightTriggerPort The button number for the right trigger of the Joystick
     * @param leftYAxis The axis number for the left Y-axis of the Joystick
     * @param rightXAxis The axis number for the right X-axis of the Joystick
     */
    public GTADrive(DifferentialDrive drive, Joystick stick, int leftTriggerPort, int rightTriggerPort, int leftYAxis, int rightXAxis) {
        this.drive = drive;
        this.stick = stick;
        this.leftTriggerPort = leftTriggerPort;
        this.rightTriggerPort = rightTriggerPort;
        this.leftYAxis = leftYAxis;
        this.rightXAxis = rightXAxis;
    }

    /**
     * Drives the robot based on the GTADrive diagram (see README file)
     */
    public void driveRobot() { //Is this code good nor nah?
        double leftTrigger = stick.getRawAxis(leftTriggerPort);
        double rightTrigger = stick.getRawAxis(rightTriggerPort);
        if(isStopped(leftTrigger ,rightTrigger)) {
            drive.tankDrive(0, 0);
        } 
        else {
            double speed = stick.getRawAxis(leftYAxis);
            speed *= -.5;
            speed += .5;
            speed = applyDirection(Math.abs(speed), leftTrigger, rightTrigger);
            double turnRotation = stick.getRawAxis(rightXAxis) * -1;
            drive.arcadeDrive(speed, turnRotation);
        }
    }

    public void rampUp()
    {
        drive.tankDrive(RobotMap.RAMP_MOTOR_SPEED, RobotMap.RAMP_MOTOR_SPEED);
    }

    public void shooterMove()
    {
        drive.tankDrive(RobotMap.SHOOTER_MOTOR_SPEED, RobotMap.SHOOTER_MOTOR_SPEED);
    }

    

    /**
     * Check if the joystick is stopped based on trigger values (both or zero)
     * @param leftTrigger The value of the left trigger axis
     * @param rightTrigger The value of the right trigger axis
     * @return Whether the trigger values mean it is stopped
     */
    private boolean isStopped(double leftTrigger, double rightTrigger) {
        boolean isReverse = leftTrigger <= 0;
        boolean isForward = rightTrigger <= 0;
        return isReverse && isForward || (!isReverse && !isForward);
    }

    /**
     * Check if the trigger is going forward (not stopped & right trigger depressed)
     * @param leftTrigger The value of the left trigger axis
     * @param rightTrigger The value of the right trigger axis
     * @return Whether the trigger values mean it is going forward
     */
    private boolean isForward(double leftTrigger, double rightTrigger) {
        return !isStopped(leftTrigger, rightTrigger) && rightTrigger <= 0;
    }

    /**
     * Apply the direction to the the speed to make it either forward or reverse.
     * @param speed The speed given by the joystick
     * @param leftTrigger The value of the left trigger axis
     * @param rightTrigger The value of the right trigger axis
     * @return The value of the speed with the direction applied
     */
    private double applyDirection(double speed, double leftTrigger, double rightTrigger) {
        return (isForward(leftTrigger, rightTrigger)) ? speed * 1 : speed * -1;
    }

    public DifferentialDrive getDrive() {
        return drive;
    }
}