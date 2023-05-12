<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- String타입으로 id변수를 정의한 후 id가 "java"인지 확인 
		 if문을 이용해서...
		 id가 "java"이면 bts.jpg를 출력하고
		 id가 "java"가 아니면 bts2.jpg를 출력
	-->
	<%-- <%
		String id = new String("java");
		if(id.equals("java")){ %>
			<img src="/serverweb/images/m_garden01.jpg">
	<% } else { %>				
			<img src="/serverweb/images/m_garden02.jpg">
	<% } %> --%>
	<table>
		<tr>이미지</tr>
		<td><img src="/serverweb/images/m_garden01.jpg" width="100"></td>
	</table>
	<% for(int i =1; i<= 10; i++) {%>
		
	<%} %>
			
</body>
</html>