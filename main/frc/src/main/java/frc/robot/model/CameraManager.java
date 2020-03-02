package frc.robot.model;

import edu.wpi.cscore.CameraServerJNI;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class CameraManager {

    private Robot robot;
    private UsbCamera elevatorCamera;
    private UsbCamera fixedCamera;

    public CameraManager(Robot robot) {
        this.robot = robot;
        setupCamera();
    }

    public void setupCamera() {
        fixedCamera = CameraServer.getInstance().startAutomaticCapture(RobotMap.CAMERA_FIXED_PORT);
        elevatorCamera = CameraServer.getInstance().startAutomaticCapture(RobotMap.CAMERA_ELEVATOR_PORT);
    }
}
