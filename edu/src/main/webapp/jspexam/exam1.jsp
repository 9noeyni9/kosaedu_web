<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!-- 지시자 태그 /contentType필수-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 테스트</title>
</head>
<body>
<h1>첫 번째 JSP 태스트 예제</h1>
<hr>
<h3>오늘 날짜 : <%= java.time.LocalDate.now() %></h3><!-- 동적 컨텐츠: 식만 올 수 있음 ;오면 안돼 수행식은 out.print(arg); 의 arg인데 arg는 ;없음 -->
</body>
</html>