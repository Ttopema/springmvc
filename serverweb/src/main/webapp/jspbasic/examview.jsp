<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>티몬 회원가입</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#id').on('input', function() {
				var id = $(this).val();
				if (id.length < 4) {
					$('#result').text('아이디는 4글자 이상이어야 합니다.');
				} else if (id == 'java') {
					$('#result').text('이미 사용중인 아이디입니다.');
				} else {
					$('#result').text('사용 가능한 아이디입니다.');
				}
			});
		});
	</script>
</head>
<body>
	<h1>티몬 회원가입</h1>
	<h2>필수항목</h2>
	<form name="myform">
		아이디: <input type="text" id="id" />
	</form>
	<div id="result" style="color: red;"></div>
</body>
</html>
