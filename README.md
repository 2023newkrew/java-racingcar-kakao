# java-racingcar-kakao

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이
  값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

---

- 입력 검증
- 커스텀 구분자 나중에
- 계산 따로
- 리스트 받아서 결과

---

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

---

- 횟수 입력
- 자동차 이름 입력
- 전진 여부 처리
- 우승자 선정

--- 

- 주어진 값에 따라서 전진 혹은 정지 테스트 moveTest
- parser 테스트
- 이름 5자 이하 validation 테스트
- 우승 테스트

---

## 2차 과제를 위한 TODO 리스트

- [x] 확장성 문제 해결
    - [x] 현재 CarAction이 두 가지 밖에 존재하지 않음 -> Strategy 패턴을 통해 할 수 있도록 해결
    - [x] 우승자의 이름만 출력하도록 짜여져 있음(이동 거리 혹은 이런 것이 추가될 가능성).
- [x] MVC 패턴에 따라서 프로젝트를 구현할 수 있도록 한다.
    - [x] Model 에 핵심 로직을 넣어둔다.
    - [x] Controller 가 View 와 Model 을 연결할 수 있도록 한다.
- [x] Setter 를 사용하지 않고 생성자를 통해 초기화할 수 있도록 한다.
- [x] `RacingService` 의 책임을 분리한다.
    - [x] 검증의 책임을 각 객체에게 부여한다.
    - [x] Winner 결정 룰을 `Car` 의 일급 컬렉션에 위임하는 것을 어떨까.
