<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>스프링이 공유해준 데이터</h1>
	<hr/>
	<h2>jsp코드로 출력하기:<%= request.getAttribute("msg") %></h2>
	<h2>EL로 출력(공유명을 정의) : ${msg}</h2> <!-- %{}는 컨트롤러가 공유한 데이터(데이터의 이름)를 꺼내서 출력  ==> 즉, Attribute명-->
	<!-- EL은 null이나 exception에 관대하다. 그냥 값이 없으면 안띄움, -->
	<h3>EL은 공유명을 명시하면 page scope에서 공유명으로 공유된 데이터를 찾는다.
	    없으면 request scope에서 또 없으면 session scope에서 application scope에서 찾는다.
	    없으면 출력하지 않는다.
	</h3>
</body>
</html>