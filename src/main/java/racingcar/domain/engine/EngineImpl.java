package racingcar.domain.engine;

import racingcar.domain.engine.powerstrategy.PowerStrategy;
import racingcar.domain.engine.powerstrategy.RandomPowerStrategy;

import java.util.Objects;

public class EngineImpl implements Engine {

    private final PowerStrategy powerStrategy;

    private static final int MAX_POWER = 10;

    private static final int POWER_THRESHOLD = 4;

    private static final Engine randomEngine = new EngineImpl(RandomPowerStrategy.from(MAX_POWER));


    public static Engine getRandomEngine() {
        return randomEngine;
    }

    public static Engine from(PowerStrategy powerStrategy) {
        checkPowerStrategyValidation(powerStrategy);
        return new EngineImpl(powerStrategy);
    }

    private static void checkPowerStrategyValidation(PowerStrategy powerStrategy) {
        if (Objects.isNull(powerStrategy)) {
            throw new RuntimeException("Power strategy should be not null.");
        }
    }

    private EngineImpl(PowerStrategy powerStrategy) {
        this.powerStrategy = powerStrategy;
    }

    @Override
    public boolean movable() {
        return powerStrategy.getPower() >= POWER_THRESHOLD;
    }
}
