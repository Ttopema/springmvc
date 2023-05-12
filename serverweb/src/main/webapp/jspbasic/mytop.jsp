<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Bootstrap Example</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
		<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<!-- Brand -->
		<a class="navbar-brand" href="#">자바나라</a>

		<!-- Links -->
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="#">사원관리</a></li>
			<li class="nav-item"><a class="nav-link" href="#">부서관리</a></li>

			<!-- Dropdown -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbardrop"
				data-toggle="dropdown"> Dropdown link </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">프로젝트 설계</a> <a
						class="dropdown-item" href="#">개발</a> <a class="dropdown-item"
						href="#">테스트</a>
				</div></li>
		</ul>
	</nav>
	<br>

	<div class="container">
		<h3>Navbar With Dropdown</h3>
		<p>This example adds a dropdown menu in the navbar.</p>
	</div>

</body>
</html>
