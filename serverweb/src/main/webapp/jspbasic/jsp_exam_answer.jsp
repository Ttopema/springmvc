<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 요소를 이용한 구구단 만들기</title>
<style type="text/css">
	table {
		width: 600px;
		height: 500px;
	}
</style>
</head>
<body>
	<table border="1">
		<% for(int i = 1; i <=9; i++) {%>
		<tr>
			<% for(int j=1; j<=9; j++) { %>
				<%if(i==j){ %>
					<td><img src="/serverweb/images/jang1.jpg" width="50"/></td>
				<%}else{ %>
			<td><%= i + "*" + j + "=" + (i*j)%></td>
			<%} %>
		<%} %>
		</tr>
	<%} %>
	</table>
</body>
</html>