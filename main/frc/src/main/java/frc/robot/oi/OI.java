/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.oi;

import frc.robot.RobotMap;
import frc.robot.commands.LaunchCommand;
import frc.robot.commands.LiftCommand;
import frc.robot.commands.RampCommand;
import frc.robot.commands.ColorWheelIncrementCommand;
import frc.robot.commands.ColorWheelSpinCommand;
import frc.robot.commands.FindBlueOnWheel;
import frc.robot.commands.FindGreenOnWheel;
import frc.robot.commands.FindRedOnWheel;
import frc.robot.commands.FindYellowOnWheel;
import frc.robot.commands.IntakeWheelCommand;
import frc.robot.model.StarJoystick;

import java.util.stream.Stream;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    private StarJoystick primaryJoystick;
    private StarJoystick secondaryJoystick;

    public OI() {
        loadPrimaryJoystick();
        //loadSecondaryJoystick();
    }

    private void loadPrimaryJoystick() {
        primaryJoystick = new StarJoystick(RobotMap.OI_JOYSTICK_PRIMARY_PORT);
        Stream.of(
                RobotMap.logitechButtonA,
                RobotMap.logitechButtonB,
                RobotMap.logitechButtonX,
                RobotMap.logitechButtonY, 
                RobotMap.logitechButtonStart,
                RobotMap.logitechLeftBumper
        ).forEach(primaryJoystick::addButton);
    }

    private void loadSecondaryJoystick() {
        secondaryJoystick = new StarJoystick(RobotMap.OI_JOYSTICK_SECONDARY_PORT);
        

    }

    public void assignCommands() {
        primaryJoystick.getButton(RobotMap.logitechButtonA).ifPresent(button -> button.whenPressed(new FindGreenOnWheel()));
        primaryJoystick.getButton(RobotMap.logitechButtonB).ifPresent(button -> button.whenPressed(new FindRedOnWheel()));
        primaryJoystick.getButton(RobotMap.logitechButtonX).ifPresent(button -> button.whenPressed(new FindBlueOnWheel()));
        primaryJoystick.getButton(RobotMap.logitechButtonY).ifPresent(button -> button.whenPressed(new FindYellowOnWheel()));
        primaryJoystick.getButton(RobotMap.logitechButtonStart).ifPresent(button -> button.whenPressed(new ColorWheelSpinCommand()));
        primaryJoystick.getButton(RobotMap.logitechLeftBumper).ifPresent(button -> button.whileHeld(new LiftCommand()));
    }

    public StarJoystick getPrimaryJoystick() {
        return primaryJoystick;
    }

    public StarJoystick getSecondaryJoystick() {
        return secondaryJoystick;
    }
}
