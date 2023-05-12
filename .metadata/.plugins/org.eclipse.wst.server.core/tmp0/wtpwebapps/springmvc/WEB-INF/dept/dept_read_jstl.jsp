<%@page import="kr.multi.erp.dept.DeptDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<%-- <%
		DeptDTO dept = (DeptDTO)request.getAttribute("dept");
	%> --%>
	<c:set var="dept" value="${requestScope.dept}" />
	<jsp:include page="../main/top.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 sidenav">
				<jsp:include page="../layout/servlet_menu.jsp" />
			</div>
			<div class="col-lg-10">
				<form role="form" class="form-horizontal" action="" method="get">
					<fieldset>
						<div id="legend">
							<legend>아래 양식을 작성해주세요.(JSTL)</legend>
						</div>
						<div class="form-group">
							<!-- 부서코드 -->
							${dept.deptno}
							<label class="control-label col-sm-2" for="deptcode">부서코드</label>
							<div class="col-sm-3">
							</div>
						</div>



						<div class="form-group">
							<!-- 부서명-->
							<label class="control-label col-sm-2" for="name">부서명</label>
							<div class="col-sm-3">
								<!-- 부서명을 이곳에 출력하세요 -->
								${dept.deptname}
							</div>
						</div>
						<div class="form-group">
							<!-- 아이디-->
							<label class="control-label col-sm-2" for="id">부서생성일</label>
							<div class="col-sm-3">
								<!-- 부서생성일 이곳에 출력하세요 -->
								${dept.deptStartDay}
							</div>
						</div>
						<div class="form-group">
							<!-- 주소-->
							<label class="control-label col-sm-2" for="addr">부서레벨</label>
							<div class="col-sm-3">
								<!-- 부서레벨을 이곳에 출력하세요 -->
								${dept.deptlevel}
							</div>
						</div>

						<div class="form-group">
							<!-- 입사날짜-->
							<label class="control-label col-sm-2" for="hiredate">부서스텝</label>
							<div class="col-sm-3">
								<!-- 부서스텝를 이곳에 출력하세요 -->
								${dept.deptstep}
							</div>
						</div>
						<div class="form-group">
							<!-- 포인트-->
							<label class="control-label col-sm-2" for="point">상위부서번호</label>
							<div class="col-sm-3">
								<!-- 상위부서번호를 이곳에 출력하세요 -->
								${dept.deptuppercode}
							</div>
						</div>
						<div class="form-group">
							<!-- 등급-->
							<label class="control-label col-sm-2" for="grade">업무분류</label>
							<div class="col-sm-3">
								<!-- 업무분류를 이곳에 출력하세요 -->
								${dept.job_category}
							</div>
						</div>
						<div class="form-group">
							<!-- 등급-->
							<label class="control-label col-sm-2" for="grade">관리자</label>
							<div class="col-sm-3">
								<!-- 관리자를 이곳에 출력하세요 -->
								${dept.mgr_id}
							</div>
						</div>
						<div class="form-group">
							<!-- 등급-->
							<label class="control-label col-sm-2" for="grade">부서주소</label>
							<div class="col-sm-3">
								<!-- 부서주소를 이곳에 출력하세요 -->
								${dept.deptaddr}
							</div>
						</div>
						<div class="form-group">
							<!-- 등급-->
							<label class="control-label col-sm-2" for="grade">전화번호</label>
							<div class="col-sm-3">
								<!-- 전화번호를 이곳에 출력하세요 -->
								${dept.depttel}
							</div>
						</div>
						<div class="form-group">
							<!-- Button -->
							<div class="col-sm-3 col-sm-offset-2">
								<input type="button" value="수정" class="btn btn-success"
								  onclick="location.href='/springmvc/dept/read.do?deptno=${dept.deptno}&state=UPDATE'"/>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>