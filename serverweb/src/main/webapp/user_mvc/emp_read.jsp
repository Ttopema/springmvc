<%@page import="kr.multicampus.erp.user.EmpDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		//서블릿에서 공유한 데이터 꺼내서 출력하기
		EmpDTO emp = (EmpDTO) request.getAttribute("emp");
	%>
	<jsp:include page="../top.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 sidenav">
				<jsp:include page="/layout/servlet_menu.jsp" />
			</div>
			<div class="col-lg-10">
				<div class="container-fluid">
					<form role="form" class="form-horizontal" action="" method="get">
						<fieldset>
							<div id="legend">
								<legend>아래 양식을 작성해주세요.</legend>
							</div>
							<div class="form-group">
								<!-- 부서코드 -->
								<%= emp.getDeptno() %>
								<label class="control-label col-sm-2" for="deptcode">부서코드</label>
								<div class="col-sm-3"></div>
							</div>



							<div class="form-group">
								<!-- 부서명-->
								<label class="control-label col-sm-2" for="name">성명</label>
								<div class="col-sm-3">
									<!-- 성명을 이곳에 출력하세요 -->
									<%= emp.getName() %>
								</div>
							</div>
							<div class="form-group">
								<!-- 아이디-->
								<label class="control-label col-sm-2" for="id">아이디</label>
								<div class="col-sm-3">
									<!-- 아이디를 이곳에 출력하세요 -->
									<%= emp.getId() %>
								</div>
							</div>
							<div class="form-group">
								<!-- 주소-->
								<label class="control-label col-sm-2" for="addr">주소</label>
								<div class="col-sm-3">
									<!-- 주소를 이곳에 출력하세요 -->
									<%= emp.getAddr() %>
								</div>
							</div>

							<div class="form-group">
								<!-- 입사날짜-->
								<label class="control-label col-sm-2" for="hiredate">입사날짜</label>
								<div class="col-sm-3">
									<!-- 입사날짜를 이곳에 출력하세요 -->
								</div>
							</div>
							<div class="form-group">
								<!-- 포인트-->
								<label class="control-label col-sm-2" for="point">포인트</label>
								<div class="col-sm-3">
									<!-- 포인트를 이곳에 출력하세요 -->
									<%= emp.getPoint() %>
								</div>
							</div>
							<div class="form-group">
								<!-- 등급-->
								<label class="control-label col-sm-2" for="grade">등급</label>
								<div class="col-sm-3">
									<!-- 등급을 이곳에 출력하세요 -->
									<%= emp.getGrade() %>
								</div>
							</div>
							<div class="form-group">
								<!-- Button -->
								<div class="col-sm-3 col-sm-offset-2">
									<input type="button" value="수정" class="btn btn-success" />
								</div>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
</body>
</html>