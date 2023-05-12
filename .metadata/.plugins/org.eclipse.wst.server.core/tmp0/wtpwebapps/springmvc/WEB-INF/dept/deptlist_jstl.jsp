<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="kr.multi.erp.dept.DeptDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>
	<%-- <%
	ArrayList<DeptDTO> deptlist = (ArrayList<DeptDTO>) request.getAttribute("deptlist");
	%> --%>
	<jsp:include page="../main/top.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 sidenav">
				<jsp:include page="../layout/servlet_menu.jsp" />
			</div>
			<div class="col-lg-10">
				<h3>부서목록(JSTL)</h3>
				<div style="padding-top: 30px">
					
					<table class="table">
						<thead>
							<tr>
								<th>부서번호</th>
								<th>부서명</th>
								<th>부서생성일</th>
								<th>부서레벨</th>
								<th>부서스텝</th>
								<th>상위부서번호</th>
								<th>업무분류</th>
								<th>관리자</th>
								<th>부서주소</th>
								<th>전화번호</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody>
							<%-- <%
							int size = deptlist.size();
							for(int i=0; i<size; i++){
								DeptDTO dept = deptlist.get(i);
								
							%> --%>
								<c:forEach var="deptdata" items="${deptlist }">
									<tr>
										<td><a href="/springmvc/dept/read.do?deptno=${deptdata.deptno }&state=READ">${deptdata.deptno }</a></td>
											<td>${deptdata.deptname }</td>
											<td>${deptdata.deptStartDay }</td>
											<td>${deptdata.deptlevel }</td>
											<td>${deptdata.deptstep }</td>
											<td>${deptdata.job_category }</td>
											<td>${deptdata.mgr_id }</td>
											<td>${deptdata.deptaddr }</td>
											<td>${deptdata.depttel }</td>
										<td><a href="/springmvc/dept/delete.do?deptno= ${deptdata.deptno }">삭제</a></td>
									</tr>
								</c:forEach>
								<%-- <td><%=dept.getDeptname() %></td>
								<td><%=dept.getDeptStartDay() %></td>
								<td><%=dept.getDeptlevel() %></td>
								<td><%=dept.getDeptstep() %></td>
								<td><%=dept.getJob_category() %></td>
								<td><%=dept.getMgr_id() %></td>
								<td><%=dept.getDeptaddr() %></td>
								<td><%=dept.getDepttel() %></td> --%>
							<%-- <%} %> --%>
						</tbody>
					</table>
				</div>
			
			</div>
		</div>
	</div>
</body>
</html>
