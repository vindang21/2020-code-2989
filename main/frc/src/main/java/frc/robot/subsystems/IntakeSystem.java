/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.model.StarTalonSRX;
//import frc.robot.subsystems.drive.GTADrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class IntakeSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private StarTalonSRX motor;

  //private GTADrive drive;
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    loadSpeedControllers();
    applySpeedControllerPreferences();
   // loadDrive();
  }

  private void loadSpeedControllers()
  {
    motor = new StarTalonSRX(RobotMap.INTAKE_MOTOR_PORT);
  }
  /*
  private void loadDrive() {
    drive = new GTADrive(new DifferentialDrive(new SpeedControllerGroup(motor), new SpeedControllerGroup(null)), Robot.oi.getPrimaryJoystick(), RobotMap.OI_JOYSTICK_PRIMARY_LEFT_TRIGGER_PORT, RobotMap.OI_JOYSTICK_PRIMARY_RIGHT_TRIGGER_PORT, RobotMap.OI_JOYSTICK_PRIMARY_LEFT_Y_AXIS_PORT, RobotMap.OI_JOYSTICK_PRIMARY_RIGHT_X_AXIS_PORT);
  }
  */
  private void applySpeedControllerPreferences() {
    motor.setMaxOutputFunction(() -> RobotMap.INTAKE_MOTOR_SPEED);
  }

  /**
     * Ball/Ramp mover
     */
    public void moveIntakeWheel()
    {
        motor.feed(); 
        motor.set(RobotMap.INTAKE_MOTOR_SPEED);
        try{Thread.sleep(99);}
        catch(Exception e){}
        motor.feed(); 
        motor.set(0);
    }//end moveIntakeWheel
}
