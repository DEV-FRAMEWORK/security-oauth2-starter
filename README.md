# README #
## Spring OAuth2.0
### AuthorizationServer(권한관리서버)
### Descrition: Token 생성 서버
### 수정일 : 2019.08.26
@EnableAuthorizationServer

This README would normally document whatever steps are necessary to get your application up and running.

# 테스트 방법

### 1. 앱 실행
$ ./mvnw spring-boot:run

### 2. 앱 빌드&패키징
$ ./mvnw clean package 

### 3. Java Run Test
$ java -jar ./target/*.jar 

### 4. Postman 활용한 테스트 방법
1) Authorization Server 테스트 방법
> - 전송방식 "POST" 선택 후 Authorization 입력값<p>
> 1) URL : http://localhost:8080/oauth/token
> 2) Type : Basic Auth 
> 3) Username: client_id  
> 4) password : client_pw
> - Body 입력값
> 1) grant_type : password
> 2) username : user_id 
> 3) password : user_pw  

2) 입력 후 SEND <p>

### 5. Key 생성방법 

> [여기 Click](Create.Key.md)
