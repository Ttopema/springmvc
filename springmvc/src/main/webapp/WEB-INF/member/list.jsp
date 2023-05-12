<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
%>
</head>
<body>
	<jsp:include page="../main/top.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 sidenav">
				<jsp:include page="../layout/servlet_menu.jsp" />
			</div>
			<div class="col-lg-10">
				<table border="1" width="600">
					<tr>
						<th>부서코드</th>
						<th>성명</th>
						<th>아이디</th>
						<th>패스워드</th>
						<th>주소</th>
						<th>포인트</th>
						<th>등급</th>
						<th>삭제</th>
					</tr>
					
				</table>
			</div>
		</div>
	</div>
</body>
</html>













