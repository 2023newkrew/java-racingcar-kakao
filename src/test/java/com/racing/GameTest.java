package com.racing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class GameTest {

    @Test
    void initTest(){
        Game game = new Game();
        game.init("car1,car2,car3");
        List<Car> cars = game.getCars();
        // init에서 3개의 자동차를 선언했으므로 길이가 3이여야 함
        assertThat(cars).hasSize(3);
        // 각 자동차는 이동거리가 0인 자동차이고 각각의 이름은 car1, car2, car3 이므로 아래와 같은 출력값을 가져야 한다.
        assertThat(cars.get(0).printLocation()).isEqualTo("car1 : ");
        assertThat(cars.get(1).printLocation()).isEqualTo("car2 : ");
        assertThat(cars.get(2).printLocation()).isEqualTo("car3 : ");
    }

    @Test
    void maxLocationTest(){
        Game game = new Game();
        game.init("car1,car2");
        game.run(5);
        List<Car> cars = game.getCars();

        // 자동차 location의 max 값 직접 구함
        int findMax = Math.max(cars.get(0).getLocation(), cars.get(1).getLocation());
        assertThat(findMax).isEqualTo(game.maxLocation());
    }

    @Test
    void getWinnerTest(){
        Game game = new Game();
        game.init("car1,car2");
        game.run(5);

        ArrayList<Car> winners = game.getWinner();

        ArrayList<Car> cmpWinners = makeCmpWinners(game);

        assertThat(winners).isEqualTo(cmpWinners);
    }

    public ArrayList<Car> makeCmpWinners(Game game){
        ArrayList<Car> cmpWinners = new ArrayList<>();
        int maxLocation = game.maxLocation();
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
