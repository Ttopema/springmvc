<%@page import="kr.multicampus.erp.user.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
ArrayList<EmpDTO> userlist = (ArrayList<EmpDTO>) request.getAttribute("userlist");
int size = userlist.size();
%>
</head>
<body>
	<jsp:include page="../top.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 sidenav">
				<jsp:include page="/layout/servlet_menu.jsp" />
			</div>
			<div class="col-lg-10">
				<table border="1" width="600">
					<tr>
						<th>부서코드</th>
						<th>성명</th>
						<th>아이디</th>
						<th>비밀번호</th>
						<th>주소</th>
						<th>포인트</th>
						<th>등급</th>
						<th>삭제</th>
					</tr>
					<%
					for (int i = 0; i < size; i++) {
						EmpDTO emp = userlist.get(i);
					%>
					<tr>
						<td><%=emp.getDeptno()%></td>
						<td><%=emp.getName()%></td>
						<td><a href="/serverweb/mvc/read.do?id=<%=emp.getId() %>"><%=emp.getId()%></a></td>
						<td><%=emp.getPass()%></td>
						<td><%=emp.getAddr()%></td>
						<td><%=emp.getPoint()%></td>
						<td><%=emp.getGrade()%></td>
						<td><a
							href="/serverweb/emp/delete.do?test=info&id=<%=emp.getId()%>">삭제</a></td>
					</tr>
					<%
					}
					%>
				</table>
			</div>
		</div>
	</div>
</body>
</html>