<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gugudan</title>
<style>
table {
	border-collapse: collapse;
}

td {
	border: 1px solid black;
	padding: 5px;
	text-align: center;
}


</style>
</head>
<body>
	<table>
		<%
		for (int i = 1; i <= 9; i++) {
			out.print("<tr>");
			for (int j = 1; j <= 9; j++) {
		%>
		<td>
			<%
			if (i == j) {
			%> <img src="/serverweb/images/jang1.jpg" width="100" height="100">
			<%=i + " x " + j + " = " + (i * j)%>
			</div> <%
 } else {
 %> <%=i + " x " + j + " = " + (i * j)%> <%
 }
 %>
		</td>
		<%
		}
		out.print("</tr>");
		}
		%>
	</table>
</body>
</html>