<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_basic_foreach</title>
</head>
<body>
	<h2>1부터 10까지 출력하기</h2>
	<hr/>
	<c:forEach var="i" begin="1" end="10" step="1" varStatus="mystatus"> <!-- var="i"는 변수이다. -->
		<h2>
			${i }, current => ${mystatus.current}, index => ${mystatus.index}, first => ${mystatus.first},
			last => ${mystatus.last}, begin => ${mystatus.begin}, end => ${mystatus.end}, step => ${mystatus.step}
		
		</h2>
	</c:forEach>
</body>
</html>