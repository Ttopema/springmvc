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
	<h2>c:choose가 if ~ else를 표현할 수 있다.</h2>
	<h3>age변수 20세 미만:xxx님 청소년입니다., 20세이상 xxx님 성인입니다.</h3>
	if문, else if문 -> c:when
	else -> c:otherwise
	<c:choose>
		<c:when test="${param.age < 20 }">
			<h3>${param.name }님은 청소년입니다.</h3>
		</c:when>
		<c:otherwise>
			<h3>${param.name }님은 성인입니다.</h3>
		</c:otherwise>
	</c:choose>
	<hr/>
	<!-- grade파라미터가 A이면 <h3>A등급</h3>,B면 B등급, C면 C등급 -->
	<c:choose>
		<c:when test="${param.grade.equals('A') || param.grade.equals('a') }">
			<h3>A등급</h3>
		</c:when>
		<c:when test="${param.grade.equals('B') || param.grade.equals('b') }">
			<h3>B등급</h3>
		</c:when>
		<c:when test="${param.grade.equals('C') }">
			<h3>C등급</h3>
		</c:when>
		<c:otherwise>
			<h3>기타</h3>
		</c:otherwise>
	</c:choose>
	<hr/>
	<h2>null체크(컨트롤러에서 공유된 user어트리뷰트가 널인지 체크해보기)</h2>
	<c:choose>
		<c:when test="${user==null }">
			<h3>null이다.</h3>
		</c:when>
		<c:otherwise>
			<h3>null이 아니다.</h3>
		</c:otherwise>
	
	</c:choose>
</body>
</html>