package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.subsystems.drive.DriveTrain;
import frc.robot.subsystems.drive.Intake;

public class SubsystemManager {

    private DriveTrain driveTrain;
    private IntakeSystem intake;
    private RampSystem ramp; 
    private LaunchSystem launcher;
    private LiftSystem lifter;
    private ColorWheelSystem colorWheel; 

    public SubsystemManager() {
        enableSubsystems();
    }

    private void enableSubsystems() {
        driveTrain = new DriveTrain();
        if(RobotMap.MODULES_INTAKE_ENABLED) {
            intake = new IntakeSystem();
        }
        ramp = new RampSystem(); 
        launcher = new LaunchSystem();
        lifter = new LiftSystem();
        colorWheel = new ColorWheelSystem(); 
    }

    public DriveTrain getDriveTrain() {
        return driveTrain;
    }

    public IntakeSystem getIntakeSystem() {
        return intake;
    }

    public RampSystem getRamp()
    {
        return ramp; 
    }

    public LiftSystem getLiftSystem()
    {
        return lifter;
    }

    public LaunchSystem getShootSystem()
    {
        return launcher; 
    }

    public ColorWheelSystem getColorWheelSystem()
    {
        return colorWheel;
    }

}
