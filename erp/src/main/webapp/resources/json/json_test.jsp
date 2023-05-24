<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		//자바스크립트에서 json객체를 표현 (자바스크립트의 사용자정의 객체와 유사)
		var person = {
				"name" : "park",
				"age" : "27",
				"subject" : ["자바", "하둡", "스프링"],
				"addr" : {
					"zip" : "111-222",
					"addr1" : "서울시"
				},
				"history" : [
					{
						"subjcet" : "java",
						"month" : "11"
					},
					{
						"subjcet" : "자바스크립",
						"month" : "12"
					}
				]
				
		}
		//person이 json오브젝트
		//json objcet의 속성은 객체.속성명
		//json arry는 배열처럼
		alert(person);
		document.write("<h3>" + person.name + "<h3>");
		document.write("<h3>" + person.age + "<h3>");
		document.write("<h3>" + person.addr + "<h3>");
		document.write("<h3>" + person.addr.zip + "<h3>");
		document.write("<h3>" + person.addr.addr1 + "<h3>");
		document.write("<h3>" + person.addr.subject[0] + "<h3>");
		document.write("<h3>" + person.addr.subject[1] + "<h3>");
		document.write("<h3>" + person.addr.subject[0].subject + "<h3>");
		document.write("<h3>" + person.addr.subject[1].subject + "<h3>");
	</script>
</body>
</html>