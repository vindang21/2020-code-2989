package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.model.StarCommand;

public class TeleopDriveCommand extends StarCommand {

    public TeleopDriveCommand() {
        requires(Robot.subsystemManager.getDriveTrain());
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        SmartDashboard.putBoolean("Teleop Driving", true);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.subsystemManager.getDriveTrain().getDrive().driveRobot();
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void terminate() {
        SmartDashboard.putBoolean("Teleop Driving", false);
    }
}
