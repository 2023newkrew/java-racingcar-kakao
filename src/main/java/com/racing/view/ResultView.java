package com.racing.view;

import com.racing.model.Car;
import com.racing.model.Game;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    /**
     * 게임의 결과를 출력하는 메서드
     */
    public void printWinner(List<Car> winners) {
        // 모든 승자의 이름을 출력
        winners.forEach(car -> System.out.print(car.getCarName() + ","));
        System.out.println("가 최종 우승했습니다.");
    }
}