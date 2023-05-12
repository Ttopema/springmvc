<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>forTest</h1>
	<hr/>
	<table border="1">
	<% for(int i=1; i<=10; i++){ %>
		<tr>
			<td><h1><%= i %></h1></td>
		</tr>
	<%} %>
	</table>
</body>
</html>