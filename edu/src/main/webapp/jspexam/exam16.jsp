<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 테스트</title>
</head>
<body>
<h2>EL의 연산자들</h2>
<hr>
\${200+100} :  ${200+100} <br>
\${200-100} :  ${200-100} <br>
\${200/100} :  ${200/100} <br>
\${200>100} :  ${200>100} <br>
\${200==100} :  ${200==100} <br>
\${200!=100} :  ${200==100} <br>
\${ 10 eq 10 } : ${ 10 eq 10 }<br> 
\${ 10 lt 10 } : ${ 10 lt 10 }<br> 
\${ 10 gt 10 } : ${ 10 gt 10 }<br>
\${ 10 le 10 } : ${ 10 le 10 }<br>
\${ 10 ge 10 } : ${ 10 ge 10 }<br>
\${10 > 5?'A':'B'} : ${10 > 5?'A':'B'}<br>
\${100 + 200 + 300 } : ${100 + 200 + 300 }<br>
\${100 += 200 += 300 } : ${100 += 200 += 300 }<br>
\${"EL" += 12 += 34 += "-문자열 결합연산" } : ${"EL" += 12 += 34 += "-문자열 결합연산" }
</body>
</html>