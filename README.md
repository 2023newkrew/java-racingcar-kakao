# java-racingcar-kakao

## 기능 요구사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 제약 사항

- 자동차
    - 자동차의 이름은 전후 공백을 제거한 뒤 사용한다.
    - 자동차의 이름은 1~5글자이다.
    - 자동차의 이름은 중복을 허용하지 않는다.
    - 자동차의 갯수의 범위는 [1,100]이다.
- 반복 횟수의 범위는 [1,100]이다.

## 기능 명세

### 1. 문자열의 유효성을 확인한 다음 각각의 이름으로 구분하는 기능
- 이름의 갯수가 많을 경우 예외 발생 
- ",abc"일 경우 ["", "abc"]

### 2. 자동차의 이름이 유효한지 확인하는 기능
- ""일 경우 예외 발생
- "123456"일 경우 예외 발생
- "abc"일 경우 "abc"
- " abc"일 경우 "abc"
- " abc "일 경우 "abc"
- " a bc "일 경우 "a bc"
- "  12345  "일 경우 "12345"
- "a"일 경우 "a"

### 3. 자동차를 움직이거나 멈추는 기능
- engine이 null일 경우 예외
- engine의 getPower가 [4,9]일 경우 getCarInfo().getPosition() = 1
- engine의 getPower가 [0,3]일 경우 getCarInfo().getPosition() = 0

### 4. 자동차가 없거나 자동차의 이름에 중복이 있는지 확인하는 기능
- null 일 경우 예외 발생
- [] 일 경우 예외 발생
- [{"abc",0},{"abc",0}]일 경우 예외 발생
- [{"abc",0},{"abcd",0}]일 경우 성공

### 5. 경주의 승자를 찾아내는 기능
- [{"car1", 1}, {"car2", 2}, {"car3", 3}]일 경우 [{"car3", 3}]
- [{"car1", 1}, {"car2", 1}, {"car3", 1}]일 경우 [{"car1", 1}, {"car2", 1}, {"car3", 1}]
- [{"car1", 1}]일 경우 [{"car1", 1}]

### 6. 게임을 진행하는 기능

### 7. UI 

## 객체 설계

### RacingCarController

- racingCarView : RacingCarView
- racingCarModel : RacingCarModel
- static RacingCarController create()
- void start()[6]

### RacingCarModel

- cars : Car[]
- static String[] parseNames(nameLine:String)[1]
- static RacingCarModel : from(cars: Car[])[4]
- void progress()
- CarInfo[] getCarInfos()
- CarInfo[] getWinners()[5]

### Car

- name : String
- position : int
- engine : Engine
- static Car from(name:String,engine:Engine)[2]
- void moveOrStop()[3]
- CarInfo getCarInfo()

### Engine
- static Engine create(maxPower:int)
- int getPower()

### CarInfo

- name : String
- position : int
- static CarInfo from(name:String,position:int)
- String getName()
- int getPosition()

### RacingCarView[7]

- String inputNameLine()
- int inputCount()
- void printResultText()
- void printProgressResult(result:CarInfo[])
- void printWinners(winners:CarInfo[])

# java-string-accumulator-kakao

## 기능 요구사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이
  값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## 기능 명세

### 1. 커스텀 구분자와 본문을 구분하는 기능

- "//.\n123"일 경우 "//.\n", "123"
- "//\n//\n"일 경우 "//\n", "//\n"
- "////\n\n"일 경우 "////\n", "\n"
- "//.\123"일 경우 예외 발생

### 2. 커스텀 구분자를 추출하는 기능

- ""일 경우 예외 발생
- "/.\n"일 경우 예외 발생
- "//.\"일 경우 예외 발생
- "//.\n"일 경우 "." 반환
- "//. \n"일 경우 ". " 반환
- "///.\n"일 경우 "/." 반환
- "//.\n\n"일 경우 ".\n" 반환
- "//123\n"일 경우 "123" 반환
- "//\n"일 경우 null 반환
- null일 경우 null 반환

### 3. 구분자를 기준으로 문자열을 구분하는 기능

- 구분자 null, 문자열 ""일 경우 [""]
- 구분자 null, 문자열 "1,2,3" 일 경우 ["1", "2", "3"]
- 구분자 null, 문자열 "1, 2, 3"일 경우 ["1", " 2", " 3"]
- 구분자 " ", 문자열 "1, 2, 3"일 경우 ["1", "", "2", "", "3"]
- 구분자 "  ", 문자열 "1, 2, 3"일 경우 ["1", "", "2", " 3"]
- 구분자 "11" 문자열 "1112111"일 경우 ["", "12", "1"]
- 구분자 ",1" 문자열 "2,1,3"일 경우 ["2","","3"]

### 4. 문자열 목록을 숫자로 변환해서 더하는 기능

- [""]일 경우 0
- ["1", "2", "3"]일 경우 6
- ["1", " 2", " 3"]일 경우 6
- ["1", "2 ", "3 "]일 경우 6
- ["1", "", "2", "3"] 일 경우 6
- ["-1", "1"]일 경우 예외 발생
- ["1 2", "3"]일 경우 예외 발생
- ["asd"]일 경우 예외 발생
- ["($롱보다 큰수)"]일 경우 예외 발생

## 제약 사항

- 커스텀 구분자에 빈문자열이 들어오면 커스텀 구분자를 추가하지 않는다.
- 매칭은 앞에서부터 한다.
    - Ex) 11이 구분자일 경우 1112111 -> 0 + 12 + 1 이 된다.
- 구분된 문자열을 숫자로 변환할 때 각각의 문자열 앞 뒤 공백을 제거한다.
- Long을 넘는 값은 예외를 발생시킨다.
- 커스텀 구분자에 기본 구분자가 포함 될 경우 커스텀 구분자를 먼저 사용한다.

## 클래스

- StringAccumulator
    - separator : String
    - content : String
    - StringAccumulator(String)[1]
    - long accumulate()[4]
- StringSplitter
    - separators : String[]
    - StringSplitter(String)[2]
    - String[] split(String)[3]