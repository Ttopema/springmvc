<%@page import="kr.multi.erp.member.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>컬렉션에 저장된 데이터에 접근하기(가장 많이 사용된다.)</h1>
	<h2>jsp가 하는 일은 컨트롤러에서 공유한 attribute를 꺼내서 출력</h2>
	<h2>1. 배열데이터(jsp에서 만들어진 값(컨트롤러에서 공유된 값))</h2>
	<% String[] arr = {"jsp", "java", "spring", "servlet"}; %>
	<c:forEach var="data" items="<%=arr %>">
		<h3>${data }</h3>
	</c:forEach>
	<hr/>
	<h2>2. ArrayList(컨트롤러에서 공유된 데이터)</h2>
	<%
		ArrayList<String> list = new ArrayList<String>();
		list.add("하둡");
		list.add("몽고디비");
		list.add("스파크");
		list.add("피그");
		//데이터 공유
		request.setAttribute("list", list);
	%>
	<!-- current는 현재 값 -->
	<c:forEach varStatus="status" var="data" items="${list }">
		<h3>${data }, current => ${status.current }, index => ${status.index }</h3>
	</c:forEach>
	<hr/>
	<h3>3. ArrayList에 저장된 DTO제어</h3>
	<%
		ArrayList<EmpDTO> userlist = new ArrayList<EmpDTO>();
		userlist.add(new EmpDTO("001", "장동건", "", "", "", ""));
		userlist.add(new EmpDTO("001", "이민호", "", "", "", ""));
		userlist.add(new EmpDTO("001", "홍길동", "", "", "", ""));
		userlist.add(new EmpDTO("001", "방탄소년단", "", "", "", ""));
		//데이터 공유
		request.setAttribute("userlist", userlist); //컨트롤러에서 공유된 데이터라 가정하고 작업하는 것이다.
	%>
	<!-- 공유된 어트리뷰트 userlist에 저장된 dto에서 name꺼내서 출력하기 -->
	<%-- <%
		ArrayList<EmpDTO> userlist2 = (ArrayList<EmpDTO>)request.getAttribute("userlist");
		for(int i=0; i<userlist2.size(); i++){
			EmpDTO user = userlist2.get(i);
		}
	%> --%>
	<c:forEach var="user" items="${userlist }">
		<h3>${user.name }</h3> <!-- getter메소드의 get을 없애고 첫 글자를 소문자로 변경한 이름을 정의 
									DTO의 멤버변수명 -->
	</c:forEach>
</body>
</html>