# java-racingcar-kakao
## Model

### InvalidInputException
* `racingcar.view.InputView`및 하위 클래스, `racingcar.domain.Car`에서 입력이 잘못 된 경우 생성하는 예외
* `에러코드 : 에러설명`으로 구성되어 있음


|에러코드|에러내용|
|------|---|
|1|Name should be between 1 and 5.|
|2|Cars must be over 2|
|3|Duplicated car names.|
|4|Trial count must be over 0.|



### InvalidRacingConditionException
* `racingcar.domain.Racing`에서 잘못된 차 이름 / 잘못된 조건이 주어진 경우 생성하는 예외
* 메시지는 `"에러코드 : 에러설명"`으로 구성되어 있음

|에러코드|에러내용|
|------|---|
|1|racing is already over|
|2|Not yet race ended.|
|3|Round should be positive|
|4|Too few Cars(need 2)|
|5|Duplicated car exist!|




### RandomGenerator, RandomGeneratorImpl
* 람다 함수를 위한 인터페이스 및 구체 클래스이며, Car에서 랜덤한 확률으로 이동하는 로직에서 쓰임.


### Position
* 생성자로 위치값에 해당하는 `val` 값을 받음(아무것도 넘기지 않으면 기본값으로 1)
* `val`값을 기준으로 `equals`, `compareTo` 등을 재정의하였다.
* `toString`의 경우 val값 만큼 "-"를 출력하도록 오버라이딩
* _추상화하고 싶었으나 2D(x,y), 3D(x,y,z)값을 포괄하는 메소드가 있을까 의문이 들어서 하지 않음, 설계 때 조금 더 고민했으면 어땠을까 아쉬움이 남음._

### Car
* `name`, `RandomGenerator rg`를 입력값으로 받음
* `name`의 경우 길이가 1~5 사이가 아니면 `InvalidInputException`을 발생시킴.
* `rg`의 경우 0~9 사이의 값 중 하나를 반환하는 람다 함수
* `move()` 메서드는 rg의 반환값에 따라 1 이동하거나 이동하지 않음
* `toString()`, `compareTo()`, `equals()` 재정의
* `toStringOnlyName()`, `equalsPosition()`또한 정의
* _추상화하고 싶었으나 어떤 것을 추상화할지 애매했고, 설계 때 부터 추상화를 했다면 하는 아쉬움이 남음_

### Racing
* 생성자가 아닌 `Builder`로 객체 생성
* `Builder`에서는 차가 너무 적은지, 중복된 차가 있는지, round회수가 올바른지(양수) 검증하며 통과하지 못하면 `InvalidRacingCondition` 예외를 던진다.
* `proceedRound()`에서는 `remainingRound`를 하나 줄이고 각 `car`에 대해 `car.move()`를 실행시킨다. 이 때, `remainingRound`가 0 이하이면 `InvalidRacingCondition` 예외를 던진다.
* `getCars()`에서는 경주에 참여하는 `cars`를 Array형태로 반환한다.
* `isEnd()`는 `remainingRound`가 0 이하라면 `true`, 아니면 `false`를 반환한다.
* `getWinners()`는 경기가 끝났을 때(`isEnd() == true`일 때) 승리를 한 `car`를 `Car[]` 형태로 반환한다.
* _round를 진행하는 방식의 경우 클래스를 하나 더 만들면 어떨까 싶었다. 공짜 턴이 하나 생기거나 하는 등 확장성을 고려하면 만드는 게 좋다고 생각한다._

## View

### ExceptionView 및 ExceptionViewKorean
* 생성자에서 `errorStream`(PrintStream 값)을 주입받는다.
* `errorHandling(Exception e)`으로 모든 에러를 handle하도록 만들었다.
* 구체 클래스인 `ExceptionViewKorean`에서는 각각의 에러 타입, 메시지(에러코드 : 에러상황 => 특히 에러코드)로 구분하여 한국어로 에러를 출력하도록 한다.

### InputView 및 InputViewKorean
* 생성자에서 `inputStream`, `printStream`을 주입받는다.
* `InputView`에서는 `String[] scanNames()`, `int scanTrialCount()`의 구현을 요구한다.
* `InputViewKorean` 클래스에서는 위를 구현하고 추가적으로 입력 조건에 맞지 않으면 `InvalidInputException`을 발생시킨다.

### PrintView 및 PrintViewKorean
* 생성자에서 `printStream`을 주입받는다.
* `PrintView`에서는 `void printStart()`, `printCars(Car[] cars)`, `printWinners(Car[] winners)`의 구현을 요구한다.
* `PrintViewKorean` 클래스에서는 위를 구체적으로 구현하였다.
