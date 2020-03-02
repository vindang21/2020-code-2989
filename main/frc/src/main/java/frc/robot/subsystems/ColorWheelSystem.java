/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.model.StarTalonSRX;
import frc.robot.subsystems.drive.GTADrive;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;  
import com.revrobotics.ColorMatch;


/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ColorWheelSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private StarTalonSRX motor;

  private GTADrive drive;
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    loadSpeedControllers();
    applySpeedControllerPreferences();
    loadDrive();
  }

  private void loadSpeedControllers()
  {
    motor = new StarTalonSRX(RobotMap.COLOR_MOTOR_PORT);
  }
  
  private void loadDrive() {
    drive = new GTADrive(new DifferentialDrive(new SpeedControllerGroup(motor), new SpeedControllerGroup(motor)), Robot.oi.getPrimaryJoystick(), RobotMap.OI_JOYSTICK_PRIMARY_LEFT_TRIGGER_PORT, RobotMap.OI_JOYSTICK_PRIMARY_RIGHT_TRIGGER_PORT, RobotMap.OI_JOYSTICK_PRIMARY_LEFT_Y_AXIS_PORT, RobotMap.OI_JOYSTICK_PRIMARY_RIGHT_X_AXIS_PORT);
  }
  
  private void applySpeedControllerPreferences() {
    motor.setMaxOutputFunction(() -> RobotMap.COLOR_MOTOR_SPEED);
  }
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch m_colorMatcher = new ColorMatch();
  //these will be used to match up the ccolors when used.
  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113); 


  /**
     * Spin the color wheel 3 times
     */
    
    public void spinColorWheel()
    {
        applySpeedControllerPreferences(); 
        int colorCount = 0; 
        Color detectedColor = m_colorSensor.getColor();
        ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
        while(colorCount < 25)
        {
         detectedColor = m_colorSensor.getColor();

         match = m_colorMatcher.matchClosestColor(detectedColor);
 
          //spin the wheel
          incrementColorWheel(); 
          final ColorMatchResult match2 = m_colorMatcher.matchClosestColor(detectedColor);
      if (match.color != match2.color) {
        colorCount++;
      }

      // check the color ????

      // if it's the same as the start color, increment color count
    }
  }// end moveIntakeWheel

  public void findGreenOnWheel() {
    Color detectedColor = m_colorSensor.getColor();
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    while (match.color != kGreenTarget) {
      incrementColorWheel();
      detectedColor = m_colorSensor.getColor();
      match = m_colorMatcher.matchClosestColor(detectedColor);
    }
  }

  public void findRedOnWheel() {
    Color detectedColor = m_colorSensor.getColor();
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    while (match.color != kRedTarget) {
      incrementColorWheel();
      detectedColor = m_colorSensor.getColor();
      match = m_colorMatcher.matchClosestColor(detectedColor);
    }
  }

  public void findBlueOnWheel() {
    Color detectedColor = m_colorSensor.getColor();
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    while (match.color != kBlueTarget) {
      incrementColorWheel();
      detectedColor = m_colorSensor.getColor();
      match = m_colorMatcher.matchClosestColor(detectedColor);
    }
  }

  public void findYellowOnWheel() {
    Color detectedColor = m_colorSensor.getColor();
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    while (match.color != kYellowTarget) {
      incrementColorWheel();
      detectedColor = m_colorSensor.getColor();
      match = m_colorMatcher.matchClosestColor(detectedColor);
    }
  }

  // this should spin the motor for a tenth of a second
  public void incrementColorWheel() {
    motor.feed();
    motor.set(RobotMap.COLOR_MOTOR_SPEED);
    try {
      Thread.sleep(100);
    } catch (final Exception e) {
    }
    }//end increment color wheel

}
