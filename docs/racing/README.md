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


## step2 주요 변경 계획
1. random 값을 정수로 변경 
   1. 기능 요구 사항의 `3 이하면 멈춘다`를 고려하여 double이 아닌 int로 변경 
   2. Math.Random() -> Random.nextInt()
2. static, final 추가
   1. static, final 각각을 붙여야 할 곳에 누락된 것들을 수정
3. Functional Interface인 Movable 추가
   1. 이동 여부는 Movable을 통해 결정
   2. 게임 규칙을 반영한 RandomlyMovable 구현
4. Car의 toString() 메서드 오버라이딩, getName() 메서드 제거
   1. DTO로 전달하도록 수정
5. Validation의 위치 변경 및 일급 클래스 생성
   1. CarName, GameRepeat 클래스 생성, 생성 시 바로 검증
   2. Validator 클래스 삭제
   

## 프로그램 설계
- Application
  - gameController

### Utils
- ~~InputValidator~~
  - ~~validateCarNames()~~
  - ~~validateSingleCarName()~~
  - ~~validateGameRepeat()~~
  - ~~validatePositive()~~
- RandomNumberGenerator
  - generate()

### Domain
- Car (implements Comparable)
  - 속성: name, distance
  - 메서드: ~~toString()~~, compareTo(), move(), increaseDistance(), getDifference(), ~~isMoving()~~

- Cars
  - 속성: cars, length
  - 메서드: play(), getWinners(), getStatus()

### DTO
- CarDTO
- CarDtoDistanceComparator

### Service
- Game 
  - 속성: cars, length, ~~generator~~
  - 메서드: play(), getStatus(), getWinners()

### View
- OutputView
  - printResult()
  - printWinner()
- InputView
  - readCarNames()
  - readGameRepeat()
  
### Controller
- GameController
  - inputView, outputView, game
  - play()

### Movable
- Movable
  - isMoving()
- RandomlyMovable
  - isMoving()
  - RandomNumberGenerator

