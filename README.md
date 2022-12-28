# java-racingcar-kakao

# 자동차 경주
### 구현할 기능 목록
- 자동차
  - [x] 4 이상일 경우 전진, 미만일 경우 정지하는 기능
- 게임
  - [x] 0~9의 수를 Random generate하는 기능
  - [x] 문자열 리스트를 받고 자동차들의 이름과 대수를 파악하여 생성하는 기능 (Cars 생성)
  - [x] 한 턴을 플레이하는 기능
  - [x] 주어진 수 만큼 턴을 반복하는 기능
  - [x] 게임 종료 후 우승자들을 판별해서 반환하는 기능
- UI
  - [x] 자동차들의 이름을 입력받고 리스트를 반환하는 기능 (5자 이내)
  - [x] 시도할 횟수를 입력하는 기능 (0이상의 정수)
  - [x] 턴 실행 결과를 출력하는 기능
  - [x] 최종 우승자를 출력하는 기능

# 문자열 계산기 
### 구현할 기능 목록
- [x] 문자열을 분리 후 더하는 기능
  - [x] 문자열을 숫자 리스트로 변환하는 기능
    - [x] 문자열을 split하는 기능
    - [x] 문자열을 숫자로 변환하는 기능
      - 빈 문자열 또는 null 값일 때 0 반환
      - 숫자 하나 입력시 해당 숫자 반환
      - 음수일 때 혹은 숫자가 아닐 때 RuntimeException
  - [x] 분리된 숫자들을 더해서 출력하는 기능
- [x] 커스텀 구분자를 추가하는 기능
  - [x] 문자열에서 커스텀 구분자를 추출하는 기능
- [x] 문자열 입출력 기능
- [x] 계산기 Controller