# java-racingcar-kakao

## 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.


## 기능 목록
1. 0에서 9 사이의 random __정수__ 값을 생성한다.
2. 값이 4 이상인지 판정한다.
3. 값이 4 이상이면 자동차의 이동 거리를 1 증가시킨다.
4. 두 자동차의 이동 거리를 비교한다.
5. 게임 종료 시 누가 우승했는지 판단한다.
6. __이름의 앞 뒤 공백은 제거한다.__
7. 이름이 __1자 미만이거나__ 6자 이상인 경우 IllegalArgumentException 예외가 발생해야 한다.
8. 이름이 중복되는 경우 IllegalArgumentException 예외가 발생해야 한다.
9. 게임 진행 횟수 입력이 정수가 아닌 경우 IllegalArgumentException 예외가 발생해야 한다. 
10. 게임 진행 횟수 입력이 1 미만인 경우 IllegalArgumentException 예외가 발생해야 한다. 
11. __게임 진행 횟수 입력이 100 초과인 경우 IllegalArgumentException 예외가 발생해야 한다.__

<br>

## step2 주요 변경
1. 규칙 수정
   1. 수정한 규칙을 위 기능 목록에서 bold 처리하였습니다.
2. random 값을 정수로 변경 
   1. 기능 요구 사항의 `3 이하면 멈춘다`를 고려하여 double이 아닌 int로 변경 
   2. Math.Random() -> Random.nextInt()
3. static, final 추가, 상수 접근제어자 수정
   1. static, final 각각을 붙여야 할 곳에 누락된 것들을 수정
   2. 일부 클래스 내에서만 쓰이는 상수가 public으로 되어있던 것을 private으로 수정
4. Functional Interface - Movable 추가
   1. 이동 여부는 Movable을 통해 결정
   2. 게임 규칙을 반영한 RandomlyMovable 구현
5. Car의 toString() 메서드 오버라이딩, getName() 메서드 제거 및 DTO 생성
   1. CarDTO로 전달하도록 수정, Outputview에는 CarDTO, CarName의 형태로 전달
   2. CarDTO의 거리를 비교하는 Comparator 구현
6. 자동차 이름, 게임 반복 횟수에 대한 일급 컬렉션 생성 / 생성 시 검증 로직 구현
   1. CarName, GameRepeat 클래스 생성, 생성 시 바로 검증
   2. InputValidator 클래스 삭제
   3. view에서는 검증 로직 삭제
7. 반복 횟수 관리 주체를 GameController에서 Game 내부로 변경

   

## 프로그램 설계
- Application
  - 메서드: main()
    - 지역 변수: GameController gameController

### Utils
- ~~InputValidator~~
  - ~~validateCarNames()~~
  - ~~validateSingleCarName()~~
  - ~~validateGameRepeat()~~
  - ~~validatePositive()~~
- RandomNumberGenerator
  - 클래스 변수: Random random
  - 메서드: generate()

### Domain
- Car (implements Comparable)
  - 객체 변수: CarName name, Movable movable, Position position
  - 메서드: move(), increaseDistance(), toDTO()

- Cars
  - 객체 변수: List<Car> cars
  - 메서드: play(), getWinners(), getCarDtoList(), selectWinners()

- CarName
  - 객체 변수: String name
  - 메서드: validateLength(), toString(), equals(), hashCode()

- GameRepeat
  - 객체 변수: int remaining
  - 메서드: validateRange(), reduce(), hasRemaining()

- Position
  - 객체 변수: int position
  - 메서드: validateNonNegative(), increase(), compareTo(), getPosition()

### DTO
- CarDTO
  - 객체 변수: Carname name, Position position
  - 메서드: getName(), getPosition()
- CarDtoDistanceComparator (implements Comparator<CarDTO>)
  - 메서드: compare()

### Service
- Game 
  - 객체 변수: List<Car> cars, GameRepeat gameRepeat, Comparator<CarDTO> distanceComparator
  - 메서드: validateUniqueness(), getDistinctNameCount(), wrapCarNames(), setRepeat(), isOver(), play(), getStatus(), getWinners()

### View
- OutputView
  - boolean isFirstCall
  - printResult(), printSingleResult(), printWinners()
- InputView
  - readCarNames(), splitInputCarNames(), readGameRepeat()
  
### Controller
- GameController
  - 객체 변수: InputView inputView, OutputView outputView, Game game
  - 메서드: run(), initialize(), setGameRepeat(), playSingleTurn(), wrapUp()

### Movable
- Movable (Interface)
  - 메서드: isMoving()
- RandomlyMovable
  - 메서드: isMoving(), generateRandomNumber()
