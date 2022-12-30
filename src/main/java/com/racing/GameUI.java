package com.racing;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameUI {
    private final Scanner scanner;
    private final PrintStream printer;
    private Game game = null;
    private int loopMaxCount = -1;
    private int counter = -1;

    public GameUI(InputStream inputStream, OutputStream outputStream) {
        this.scanner = new Scanner(inputStream);
        this.printer = new PrintStream(outputStream);
    }

    /**
     * 해당 메서드는 GameUI가 상호작용할 스트림을 통해 사용자로부터 자동차 이름 목록과 게임 진행 횟수를 얻어오는 역활을 한다.
     */
    public void init() {
        // 초기화 여부를 검증함
        if (game != null) {
            throw new RuntimeException("이미 초기화가 끝났습니다.");
        }
        // 사용자 입력과 검증을 함
        String rawCars = getRawCars();
        int rawCount = getRawCount();
        // 초기화 수행
        this.game = Game.factory()
                .withCarsRawString(rawCars)
                .build();
        this.loopMaxCount = rawCount;
        this.counter = 0;
    }

    private String getRawCars() {
        printer.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String rawCars = scanner.nextLine();
        if (rawCars.isEmpty()) {
            throw new RuntimeException("빈 문자열을 입력하지 마세요.");
        }
        return rawCars;
    }

    private int getRawCount() {
        printer.println("시도할 횟수는 몇회인가요?");
        int rawCount = scanner.nextInt();
        if (rawCount < 0) {
            throw new RuntimeException("시도 횟수는 1회 이상이여야 합니다.");
        }
        return rawCount;
    }

    /**
     * 해당 메서드는 초기화 당시에 지정된 횟수만큼 반복적으로 게임을 진행한다.
     */
    public void run() {
        // 초기화 여부를 검증함
        if (game == null) {
            throw new RuntimeException("초기화를 먼저 진행하세요.");
        }
        printCars();
        for (; counter < loopMaxCount; counter += 1) {
            game.run();
            printCars();
        }
        printWinner();
    }

    private void printWinner() {
        printer.printf(
                "승자는 %s 입니다!",
                game.winners()
                        .stream()
                        .map(Car::name)
                        .collect(Collectors.joining(","))
        );
    }

    private void printCars() {
        game.carStream()
                .forEach(car -> printer.printf("%s : %s\n", car.name(), "-".repeat(car.location())));
        printer.println();
    }
}
