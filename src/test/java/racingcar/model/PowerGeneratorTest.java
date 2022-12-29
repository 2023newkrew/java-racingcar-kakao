package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PowerGeneratorTest {

    @Test
    @DisplayName("can generate random power under given limit")
    public void can_generate_random_power_under_given_limit() {
        int power = -1;
        final int cycle = 10000;
        PowerGenerator powerGenerator = new PowerGenerator();
        for (int i = 0; i < cycle; i++)
            power = powerGenerator.getRandomPower();
        assertTrue(power >= 0);
        assertTrue(power < PowerGenerator.POWER_LIMIT);
    }
}