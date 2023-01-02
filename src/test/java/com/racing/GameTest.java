package com.racing;

import com.racing.model.Car;
import com.racing.model.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    @DisplayName("게임 시작시 자동차는 전부 시작 위치에 있어야 한다.")
    void initTest(){
        Game game = new Game();
        game.gameInit("car1,car2,car3");
        List<Car> cars = game.getCars();
        // init에서 3개의 자동차를 선언했으므로 길이가 3이여야 함
        assertThat(cars).hasSize(3);
        // 각 자동차는 이동거리가 0인 자동차이고 각각의 이름은 car1, car2, car3 이므로 아래와 같은 출력값을 가져야 한다.
        assertThat(cars.get(0).toStringLocation()).isEqualTo("car1 : ");
        assertThat(cars.get(1).toStringLocation()).isEqualTo("car2 : ");
        assertThat(cars.get(2).toStringLocation()).isEqualTo("car3 : ");
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15})
    @DisplayName("자동차들이 이동한 위치의 최대값은 자동차들의 위치를 비교하여 알 수 있다.")
    void maxLocationTest(int turn){
        Game game = new Game();
        game.gameInit("car1,car2");
        game.run(turn);
        List<Car> cars = game.getCars();

        // 자동차 location의 max 값 직접 구함
        int findMax = Math.max(cars.get(0).getLocation(), cars.get(1).getLocation());
        assertThat(findMax).isEqualTo(game.getMaxLocation());
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15})
    @DisplayName("이번 게임의 승자를 알 수 있다.")
    void getWinnerTest(int turn){
        Game game = new Game();
        game.gameInit("car1,car2");
        game.run(turn);

        List<Car> winners = game.getWinner();

        List<Car> cmpWinners = makeCmpWinners(game);

        assertThat(winners).isEqualTo(cmpWinners);
    }

    public List<Car> makeCmpWinners(Game game){
        List<Car> cmpWinners = new ArrayList<>();
        int maxLocation = game.getMaxLocation();
        List<Car> cars = game.getCars();
        if(cars.get(0).getLocation() == maxLocation){
            cmpWinners.add(cars.get(0));
        }
        if(cars.get(1).getLocation() == maxLocation){
            cmpWinners.add(cars.get(1));
        }
        return cmpWinners;
    }
}
