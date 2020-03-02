package frc.robot.model;

import edu.wpi.first.wpilibj.PWMTalonSRX;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class StarTalonSRX extends PWMTalonSRX {

    private Supplier<Double> maxOutputFunction;

    /**
     * Constructor for a StarTalonSRX - PWMTalonSRX but with the ability to auto scale inputs
     *
     * <p>Note that the PWMTalonSRX uses the following bounds for PWM values. These values should work
     * reasonably well for most controllers, but if users experience issues such as asymmetric
     * behavior around the deadband or inability to saturate the controller in either direction,
     * calibration is recommended. The calibration procedure can be found in the TalonSRX User Manual
     * available from CTRE.
     * 
     * <p>- 2.0004ms = full "forward" - 1.52ms = the "high end" of the deadband range - 1.50ms =
     * center
     * of the deadband range (off) - 1.48ms = the "low end" of the deadband range - .997ms = full
     * "reverse"
     * 
     *  @param channel;
     * 
     * The PWM channel that the PWMTalonSRX is attached to. 0-9 are on-board, 10-19 are
     *                on the MXP port
     */


    public StarTalonSRX(int channel) {
        super(channel);
        this.maxOutputFunction = null;
    }

    @Override
    public void set(double speed) {
        if (maxOutputFunction == null) {
            super.set(speed);

        } else {
            super.set(speed * maxOutputFunction.get());
        }
    }

    public void setMaxOutputFunction(Supplier<Double> maxOutputFunction) {
        this.maxOutputFunction = maxOutputFunction;
    }
}