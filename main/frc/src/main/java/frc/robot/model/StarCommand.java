package frc.robot.model;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class StarCommand extends Command {

    // Called once after isFinished returns true
    @Override
    protected void end() {
        terminate();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        terminate();
    }

    /**
     * Called when the robot terminates, either by end or interrupt. Override end() or interrupted() to restore previous functionality.
     */
    protected abstract void terminate();
}
