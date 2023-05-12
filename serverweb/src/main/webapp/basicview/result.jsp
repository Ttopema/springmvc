<%@page import="kr.multicampus.erp.user.EmpDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>요청재지정으로 실행되는 jsp - 서블릿이 공유해준 데이터 꺼내서 웹페이지에 출력하기</h2>
	<%
		//서블릿이 공유한 데이터 꺼내기
		EmpDTO data = (EmpDTO)request.getAttribute("mydata");
	%>
	<%= data.getId() %>
</body>
</html>