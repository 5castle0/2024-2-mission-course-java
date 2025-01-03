# 3주차 미션코스

## 학습목표
* DB 와 연결해보기
* 리팩토링 해보기 -> [1주차 공통 피드백 참고하기](./articles/feedback.md)

## 진행방식
* [기존에 포크한 레포지토리](https://github.com/GDSC-Hongik/2024-2-mission-course-java)를 pull 을 통해 업데이트하여 진행한다.
* 포크한 레포지토리에서 자신의 깃허브 이름으로 된 브렌치를 만들어서 진행한다.
* 아래 주어진 명세에 맞게 구현한다.
* 주어지지 않은 내용은 스스로 판단하여 구현한다.

## 제출 방법
* 자신의 이름으로 된 브렌치를 포크한 레포지토리의 main 브렌치에 PR을 날린다.

## 턴제 게임
### 진행 요구 사항
* 기능 목록에 따라 커밋 혹은 브렌치를 나눈다.
    * 한번에 `git add .` 을 통해 커밋하는 것은 금지한다.
* 이번 과제부터는 `JPA` 을 사용한다.
    * `build.gradle` 을 수정하여 `JPA` 의존성을 설치하고 시작한다.
* 2주차 미션코스의 코드를 재활용하여 진행한다.(코드 수정은 허용한다.)
* 게임 진행 중 서비스가 꺼지더라도, 재부팅시 이어서 진행가능해야 한다.
  * 즉, DB 에 필요한 정보들을 저장해두고, 게임이 종료시에만, 데이터가 리셋된다.

### 기능 요구 사항
* 기존 2주차 까지의 명세를 따르나, 아래의 변경 사항이 추가된다.
* 캐릭터의 정보에 `job` 이 추가된다.
  * `job` 에 따라 사용가능한 스킬들이 고정된다.
* `job` 에 따라, 기본 체력, 기본 마나가 주어진다.
* 사용자로부터 `레벨`을 입력받아 다음과 같은 수식으로 체력과 마나가 결정된다.
  * 체력 = 기본체력 + 레벨 * 10
  * 마나 = 기본 마나 + 마나 * 5
* 사용자가 지정된 형식을 지키지 않은 입력을 했을 경우, `400 Bad Request` 에러를 반환한다.
* 존재하지 않는 직업을 골랐을 경우, `404 Not Found` 에러를 반환한다.

### 입력
설계와 구현에 따라 엔드포인트, 경로 매개변수, request body, query string 등 다양하게 활용한다.  
단, 캐릭터의 정보를 입력 받을 때는, `이름`, `직업`, `레벨` 을 입력받아야한다.
> 예시 (1주차 과제의 형식을 이용할 경우)  
> `알파카,기사,10`
>   
> 예시(json 형식일 경우)
> ```json
> {
>   "name": "알파카",
>   "job": "기사",
>   "level": 10
> }
> ```
 

### 출력
구현에 따라 response body 에 표현한다.