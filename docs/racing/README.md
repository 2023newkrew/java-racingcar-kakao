# java-racingcar-kakao

## 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.


## 기능 목록
1. 0에서 9 사이의 random 값을 생성한다.
2. 값이 4 이상인지 판정한다.
3. 값이 4 이상이면 자동차의 이동 거리를 1 증가시킨다.
4. 두 자동차의 이동 거리를 비교한다.
5. 게임 종료 시 누가 우승했는지 판단한다.
6. 이름이 6자 이상인 경우 IllegalArgumentException 예외가 발생해야 한다.
7. 게임 진행 횟수 입력이 정수가 아닌 경우 IllegalArgumentException 예외가 발생해야 한다. 
8. 게임 진행 횟수 입력이 0 이하인 경우 IllegalArgumentException 예외가 발생해야 한다.


## 프로그래밍 요구사항
- 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다.
  - depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- 규칙 2: else 예약어를 쓰지 않는다.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다. 
  - method가 한 가지 일만 하도록 최대한 작게 만들어라.

## 프로그램 설계
- Application
  - gameController

### Domain
- Car (implements Comparable)
  - 속성: name, distance
  - 메서드: validateName(), getName(), getDistance(), move(), equalsDistance(),toString()

- Cars
  - 속성: cars
  - 메서드: validateDuplicateCarNames(), getSplitNames(), play(), getWinners(), getMaxDistance(), getStatus()

### View
- OutputView
  - printResult()
  - printWinner()
- InputView
  - readCarNames()
  - readGameTurn()

### Controller
- GameController
  - inputView, outputView, game
  - play(), playGame()

### Service
- Game
  - 속성: cars, length, generator, gameTurn
  - 메서드: play(), isEnd(), getStatus(), getWinners()

### Utils
- InputValidator
  - validateGameTurn()
  - validatePositive()
- RandomNumberGenerator
  - generate()
