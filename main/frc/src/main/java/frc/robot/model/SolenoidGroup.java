package frc.robot.model;

import edu.wpi.first.wpilibj.Solenoid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SolenoidGroup {

    private List<Solenoid> solenoids;

    public SolenoidGroup(Solenoid firstSolenoid, Solenoid... additionalSolenoids) {
        this.solenoids = new ArrayList<>();
        solenoids.add(firstSolenoid);
        solenoids.addAll(Arrays.asList(additionalSolenoids));
    }

    public void execute(Consumer<Solenoid> action) {
        solenoids.forEach(action);
    }

    public Stream<Solenoid> stream() {
        return solenoids.stream();
    }

    public static class SolenoidGroupBuilder {

        private Solenoid firstSolenoid;
        private List<Solenoid> additionalSolenoids;

        public SolenoidGroupBuilder() {
            firstSolenoid = null;
            additionalSolenoids = new ArrayList<>();
        }

        public SolenoidGroupBuilder(Solenoid solenoid) {
            super();
            firstSolenoid = solenoid;
        }

        public SolenoidGroupBuilder(int solenoidPort) {
            this(new Solenoid(solenoidPort));
        }

        public SolenoidGroupBuilder add(Solenoid solenoid) {
            if(firstSolenoid == null) {
                firstSolenoid = solenoid;
            }  else {
                additionalSolenoids.add(solenoid);
            }
            return this;
        }

        public SolenoidGroupBuilder add(int solenoidPort) {
            return add(new Solenoid(solenoidPort));
        }

        public SolenoidGroup create() {
            return new SolenoidGroup(firstSolenoid, additionalSolenoids.toArray(new Solenoid[0]));
        }
    }
}
