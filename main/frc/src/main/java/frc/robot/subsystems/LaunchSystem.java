/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.model.StarTalonSRX;
import frc.robot.subsystems.drive.GTADrive;

/**
 * Launch Subsystem - handles the motors for launch
 */
public class LaunchSystem extends Subsystem {
  private StarTalonSRX leftMotor; //left launcher motor
  private StarTalonSRX rightMotor; //right launcher motor

  private GTADrive drive;   //drive gives us access to drive methods for a drive system
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    loadSpeedControllers();
    applySpeedControllerPreferences();
    loadDrive();
  }

  /*
  * Initializes motors using appropriate ports from RobotMap
  */
  private void loadSpeedControllers()
  {
    leftMotor = new StarTalonSRX(RobotMap.SHOOTER_MOTOR_LEFT_PORT);
    rightMotor = new StarTalonSRX(RobotMap.SHOOTER_MOTOR_RIGHT_PORT);
  }

  /*
  * Initializes drive system - allows use of drive methods
  */
  
  private void loadDrive() {
    drive = new GTADrive(new DifferentialDrive(new SpeedControllerGroup(leftMotor), new SpeedControllerGroup(rightMotor)), Robot.oi.getPrimaryJoystick(), RobotMap.OI_JOYSTICK_PRIMARY_LEFT_TRIGGER_PORT, RobotMap.OI_JOYSTICK_PRIMARY_RIGHT_TRIGGER_PORT, RobotMap.OI_JOYSTICK_PRIMARY_LEFT_Y_AXIS_PORT, RobotMap.OI_JOYSTICK_PRIMARY_RIGHT_X_AXIS_PORT);
  }
  

  /*
  * Applies speed settings specified 
  */
  private void applySpeedControllerPreferences() {
    leftMotor.setMaxOutputFunction(() -> RobotMap.SHOOTER_MOTOR_SPEED);
    rightMotor.setMaxOutputFunction(() -> RobotMap.SHOOTER_MOTOR_SPEED);
  }

  /**
     * moves the motor to launch the ball
     */
    public void launch()
    {
        leftMotor.feed(); 
        rightMotor.feed();
        leftMotor.set(RobotMap.SHOOTER_MOTOR_SPEED);
        rightMotor.set(RobotMap.SHOOTER_MOTOR_SPEED);
  }//end launch
}
