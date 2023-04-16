<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 테스트</title>
</head>
<body>
<h2>EL의 Query 문자열 추출</h2>
<hr>
전달된 메시지의 존재 여부 : ${ !empty param.message }<hr><!-- el에선 empty연산자가 중요(자바에는 X) -->
전달된 메시지의 내용은 ${param.message} 입니다.<br>
전달된 메시지의 내용은 ${param["message"]} 입니다.<br><!-- param은 el의 내장 객체 -->
<hr>
전달된 메시지의 내용은 <%= request.getParameter("message") %> 입니다.<br>
</body>
</html>