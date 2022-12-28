# java-racingcar-kakao

### 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다. 
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

### 기능 목록
자동차
- 5자 이하로 이루어진 이름
- 현재 자동차의 위치 정보

레이싱
- 여러대의 자동차 정보
- 각 이동 마다, 각 자동차에 대해 0~9사이 난수값을 구한 후 4 이상이면 자동차 위치 이동

사용자입력
- 쉼표로 구분된 이름 목록 입력
- 몇 번 이동할 것인지 입력
- 예외처리:
  - 5자 초과로 이루어진 입력
  - 정수가 아닌 이동 횟수 입력

출력
- 각 이동마다 현재 진행 상황 출력
- 경주가 종료 된 후 우승자 출력
