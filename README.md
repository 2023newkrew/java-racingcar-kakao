# java-racingcar-kakao

## 자동차 경주 구현

### 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 or 멈춤 할 수 있다
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때, 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표를 기준으로 구분하고, 이름은 5자 이하만 가능하다
- 사용자는 몇 번의 이동을 할 것인지 입력할 수 있다
- 전진하는 조건은 0~9 사이 random 값을 구한후, random 값이 4 이상일 경우 전진, 3 이하일 경우 멈춤
- 자동차 경주 게임 완료 후, 누가 우승했는지 알려준다

### 구현할 기능 목록
- **UI 로직**
  - [x] 자동차 이름을 사용자로부터 입력받는다
    - [x] 자동차 이름은 쉼표를 기준으로 구분한다
  - [x] 몇 번의 자동차 이동을 할 것인지 입력받는다
  - [x] 각 이동 횟수 마다 자동차 전진 상태를 출력해야 한다
    - ex) pobi: 2, crong: 1, honux: 2 *(car.name: car.position)*
      ```
      실행 결과
      pobi : --
      crong : -
      honux : --
      ```
  - [x] 최종 우승자를 출력해야 한다

- **핵심 게임 로직**
  - Car
    - [x] 자동차 이름을 저장한다
      - [x] 자동차 이름은 5자 이하만 가능하다
    - [x] 자동차 위치를 저장한다
    - [x] 자동차 위치는 Referee의 지시에 따라 전진/멈춤이 결정된다
  - Referee
    - [x] 경주의 주어진 횟수를 저장한다
      - [x] 주어진 횟수는 양수여야 한다
    - [x] 현재 진행된 횟수를 저장한다
    - [x] 게임에 참여한 List<Car\>를 저장한다
    - 각 횟수마다 해야할 행동들
      - [x] 경주에 참여한 모든 자동차의 전진/멈춤 여부를 결정한다
        - [x] random 값을 받아와 4 이상이라면 전진
        - [x] 3 이하일 경우 멈춤을 결정한다
        - [x] 각 횟수의 결과를 발표한다
    - 게임 종료 후 해야할 행동
      - [x] 게임이 종료가 되었는지 확인한다
      - [x] 모든 자동차의 position을 검토하여 최종 우승자를 결정한다
  - RacingGame
    - [x] input을 기반으로 List<Car\>와 Referee를 생성한다
    - [x] 게임이 종료되었는지 Referee에게 물어본다
      - [x] 게임이 종료되었다면 Referee에게 게임 우승자를 물어본다
    - [x] Referee에게 각 횟수의 결과를 물어본다

### 리팩터링 중점 사안
- [x] 생성 조건에 대한 validation을 더 추가하기
- [x] 리턴 타입을 예상할 수 있는 메서드 네이밍을 작성하기
- [x] 불필요한 인스턴스 변수를 제거하기 (RandomNumberSelector)
- [x] 아무런 행위를 하지 않는 메서드 제거
- [x] Map<Key, Value\> 사용에 대한 재고
- [x] Optional.isPresent() / Optional.isEmpty() => boolean으로 리팩터링
- [x] 유지 보수에 용이한 테스트 코드를 고민해보기
- [x] 유지 보수에 용이한 테스트 코드로 변경해보기
- [x] View에 알맞지 않은 Input에 대해 다시 입력받는 로직 구현
- [x] Controller에 DTO를 도입하여 도메인 보호
- [x] 생성자 주입을 통해 final 처리할 수 있는 인스턴스 변수라면 리팩터링하기
- [x] MoveThreshold를 자동차가 자체적으로 가지도록 수정
- [x] 무의미한 Wrapping Method에 대한 사용 재고
- [x] 매 Round마다 결과를 리턴받아 출력하는 함수를 전달하는 방법 생각해보기
- [x] StringBuilder/String.repeat() 도입을 통한 View단 IO 최소화
- [x] DTO로 변환은 Controller Layer에서 하기
- [x] Domain Layer는 Domain 객체를 리턴하기
