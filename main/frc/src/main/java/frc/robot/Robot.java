/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.model.CameraManager;
import frc.robot.oi.OI;
import frc.robot.subsystems.SubsystemManager;

import java.util.Optional;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  public static OI oi;
  public static SubsystemManager subsystemManager;
  public static Optional<Command> autonomousCommand;
  public static CameraManager cameraManager;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    PowerDistributionPanel panel = new PowerDistributionPanel(); 
    panel.clearStickyFaults();
    panel.close();
    oi = new OI();
    subsystemManager = new SubsystemManager();
    oi.assignCommands();
    autonomousCommand = Optional.empty();
    cameraManager = new CameraManager(this);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items likPreview of uBlock Origin diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *Preview of uBlock Origin        SmartDashboard.putBoolean("Intake Pistons", status);

   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    autonomousCommand = Optional.empty(); // TODO: Get this from chooser?

    autonomousCommand.ifPresent(command -> {
      command.start();
      SmartDashboard.putBoolean("Autonomous Enabled", true);
      SmartDashboard.putString("Autonomous Command", command.getName());
    });
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    autonomousCommand.ifPresent(command -> {
      command.cancel();
      SmartDashboard.putBoolean("Autonomous Enabled", false);
      SmartDashboard.putString("Autonomous Command", "N/A");
    });
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
