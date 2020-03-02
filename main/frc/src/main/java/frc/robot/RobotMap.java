/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    /**
     * Camera Toggles
     */
    public static int CAMERA_ELEVATOR_PORT = 12;
    public static int CAMERA_FIXED_PORT = 11;

    /**
     * Subsystem Toggles
     * (Enable and Disable on the fly)
     */
    public static boolean MODULES_PNEUMATICS_ENABLED = true;
    public static boolean MODULES_INTAKE_ENABLED = true;
    public static boolean MODULES_ELEVATOR_ENABLED = true;

    /**
     * DriveTrain
     * (Tolerance Values)
     */
    public static double LEFT_MAX_OUTPUT = 0.5;
    public static double RIGHT_MAX_OUTPUT = 0.5;

    /**
     * DriveTrain
     * (Motor Ports)
     */
    public static int DRIVETRAIN_MOTOR_LEFT_1 = 0;
    public static int DRIVETRAIN_MOTOR_LEFT_2 = 1;
    public static int DRIVETRAIN_MOTOR_RIGHT_1 = 2;
    public static int DRIVETRAIN_MOTOR_RIGHT_2 = 3;

    /**
     * DriveTrain
     * (Sensor Ports)
     */
    public static int DRIVETRAIN_SENSOR_ENCODER = 0;

    /**
     * Operator Interface
     * (Primary Joystick Ports)
     */
    public static int OI_JOYSTICK_PRIMARY_PORT = 0;
    public static int OI_JOYSTICK_PRIMARY_LEFT_TRIGGER_PORT = 3;
    public static int OI_JOYSTICK_PRIMARY_RIGHT_TRIGGER_PORT = 2;
    public static int OI_JOYSTICK_PRIMARY_LEFT_Y_AXIS_PORT = 1;
    public static int OI_JOYSTICK_PRIMARY_RIGHT_X_AXIS_PORT = 4;

    /**
     * Operator Interface
     * (Secondary Joystick Ports)
     */
    
    public static int OI_JOYSTICK_SECONDARY_PORT= 1;
    public static int OI_JOYSTICK_SECONDARY_INTAKE_PORT = 2;
    /*
    public static int OI_JOYSTICK_SECONDARY_SHOOT_PORT = 5;
    public static int OI_JOYSTICK_SECONDARY_TRIGGER_PORT = 1;
    public static int OI_JOYSTICK_SECONDARY_ELEVATOR_AXIS = 1;
    public static int OI_JOYSTICK_SECONDARY_HATCH_PORT = 7;
    */

    public static int logitechButtonA = 1; 
    public static int logitechButtonB = 2; 
    public static int logitechButtonX = 3; 
    public static int logitechButtonY = 4; 
    public static int logitechButtonStart = 8; 
    public static int logitechLeftBumper = 5; 
    
    /**
     * Intake
     * (Solenoid Ports)
     */
    public static int INTAKE_SOLENOID_LEFT_PORT = 0;

    /**
     * Ramp
     * (Motor Ports)
     */
    public static int RAMP_MOTOR_LEFT_PORT = 6;
    public static int RAMP_MOTOR_RIGHT_PORT = 7;
    public static double RAMP_MOTOR_SPEED = 1.0;
    public static double INTAKE_MOTOR_SPEED = 0.75;

    
    public static int ELEVATOR_ENCODER_PORT_1 = 0;
    public static int ELEVATOR_ENCODER_PORT_2 = 1;
    public static double ELEVATOR_PID_P = 2.0;
    public static double ELEVATOOR_PID_I = 0.0;
    public static double ELEVATOR_PID_D = 0.0;
    public static double ELEVATOR_PID_TOLERANCE = 0.05;
    public static boolean ELEVATOR_PID_CONTINOUS = false;
    public static int INTAKE_MOTOR_PORT = 8;
    
    public static double ELEVATOR_END_TO_END_ENCODER_COUNT = 0.0;

    public static int CLIMB_MOTOR_PORT = 9;
    public static double CLIMB_MOTOR_SPEED = 1.0; 

    public static int SHOOTER_MOTOR_LEFT_PORT = 4;
    public static int SHOOTER_MOTOR_RIGHT_PORT = 5;
    public static double SHOOTER_MOTOR_SPEED = 1.0;

    public static int COLOR_MOTOR_PORT; 
    public static double COLOR_MOTOR_SPEED = .25; 

}
