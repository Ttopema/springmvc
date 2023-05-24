<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {
		// id가 testbtn인 버튼을 눌렀을 때 /erp/ajax/exam01을 요청
		// ==> json object가 response돼서 옴.
		$("#testbtn").on("click", function() {
			var querydata = {"boardno" : $("#boardno").val()
			};
			$.ajax({
				url : "/erp/ajax/exam01",
				type : "get",
				data : querydata, //클라이언트에서 서버로 넘기는 파라미터
				dataType : "json", // 응답되는 데이터의 종류
				success : function(data) { //변수명 - 서버와 통신하고 서버가 보내준 결과를 저장하는 변수 ==> 변수명이기 때문에 아무렇게나 해도 된다. 
					// alert(data);
					// alert(data.title + data.content);
					$("#no").text(data.board_no);
					$("#title").text(data.title);
					$("#writer").text(data.writer);
					$("#content").text(data.content);
				},
				error : error_run
			});
		});
		// id가 testjsonbtn인 버튼을 눌렀을 때 /erp/ajax/exam02/getjsondata를 요청
        // ==> json array가 response되면 id가 printarr인 div에 내용을 출력할 수 있도록 정의
		$("#testjsonbtn").on("click", function() {
			var printdata = ""; // printdata 변수 선언 및 초기화
			$.ajax({
				url : "/erp/ajax/exam02/getjsondata",
				type : "get",
				dataType : "json", // 응답되는 데이터의 종류
				success : function(data) {
					//alert(data.length + "========" + data[0].title);
					// alert(data.title + data.content);
					for(i=0; i<data.length; i++){
						printdata = printdata + data[i].id + "," + data[i].title + "</br>";
					}
					$("#printarr").html(printdata);
				},
				error : function(obj, msg, statusMsg) {
					// ajax요청이 실패하는 경우
					// 화면을 비워둘 수 없으므로 요청이 실패한 경우 만들어질 페이지를 출력하기 위한 목적으로 사용
					alert("실패");
				}
			});
		});

		// 에러가 발생하면 호출되는 메소드
		// obj - XMLHttpRequest객체가 전달되고, msg - 응답메시지 전달, statusMsg - 에러메시지 전달
		function error_run(obj, msg, statusMsg) {
			alert("오류발생====>" + obj + "," + msg + "," + statusMsg);
		}
	});
</script>
</head>
<body>
	<form>
		글번호:<input type="text" name="boardno" id="boardno" /> <input
			type="button" value="ajax테스트" id="testbtn" /> <input type="button"
			value="ajaxjson테스트" id="testjsonbtn" />
	</form>
	<div id="result">
		<h4>
			글번호:<span id="no"></span>
		</h4>
		<h4>
			제목:<span id="title"></span>
		</h4>
		<h4>
			작성자:<span id="writer"></span>
		</h4>
		<h4>
			내용:<span id="content"></span>
		</h4>
	</div>
	<div id="printarr"></div>
</body>
</html>