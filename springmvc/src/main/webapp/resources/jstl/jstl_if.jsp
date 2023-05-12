<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 외부에서 제공되는 라이브러리를 JSP에서 사용하기 위해서는 taglib지시자를 이용해서 jsp문서에 추가하고 작업해야 한다. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- JSTL(자바표준태그 라이브러리) 
		core : 일반적으로 jsp에서 많이 사용하는 문법을 태그로 표현(prefix="c")
		JSTL내부에서 EL을 사용하는 경우가 대부분이다.(조건식)
		
		[EL]
		1) parameter 접근 방법
		   param.파라미터명
	-->
	<h3>c:if의 사용 - 자바의 if문(true인 경우에만 체크)</h3>
	1. 전송된 파라미터의 name을 체크하기(name이 홍길동이면 "홍길동님 환영합니다." 메시지를 출력하기)
	<h2>${param.name }</h2>
	<h2>${param.addr }</h2>
	<!-- name속성이 prameter명이다. -->
	<c:if test="${param.name == '홍길동' }">
		<h3>${param.name}님 환영합니다.</h3>
	</c:if>
	
	<!-- JSTL로 어트리뷰트 정의하기 -->
	<c:set var="mydata" value="park" scope="session"/>
	<!-- session.setAttribute("mydata", bts) -->
	<h3>JSTL에서 정의한 변수는 컨트롤러에서 공유한 데이터와 동일한 종류의 데이터 즉, Attribute:${mydata} </h3>
</body>
</html>