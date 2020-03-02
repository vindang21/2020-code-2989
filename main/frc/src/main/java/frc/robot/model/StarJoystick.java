package frc.robot.model;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class StarJoystick extends Joystick {

    private Map<Integer, Button> buttons;

    /**
     * Construct an instance of a joystick. The joystick index is the USB port on the drivers
     * station.
     *
     * @param port The port on the Driver Station that the joystick is plugged into.
     */
    public StarJoystick(int port) {
        super(port);
        buttons = new HashMap<>();
    }

    public void addButton(int port) {
        buttons.put(port, new JoystickButton(this, port));
    }

    public Optional<Button> getButton(int port) {
        return Optional.ofNullable(buttons.get(port));
    }

}
