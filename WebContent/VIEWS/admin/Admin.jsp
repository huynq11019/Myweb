<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>danh sách</title>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">

		<a href="/Myweb/Regiter"><button
				class="btn btn-primary pull-right">thêm moi</button></a>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Number</th>
					<th scope="col">gender</th>
					<th scope="col">role</th>
					<th scope="col">action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listUser}" var="user">
					<tr>
						<th>${user.id }</th>
						<td>${user.name }</td>
						<td>${user.email}</td>
						<td>${user.number }</td>
						<td>${user.gender }</td>
						<td>${user.role }</td>
						<td><a href="user/UpdateUser?id=${user.id }">
								<button class="btn btn-primary">Chỉnh sửa</button>
						</a> <a href="user/deleteUser?id=${user.id }"><button
									class="btn btn-danger">Xóa</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<ul class="pagination">
		<li class="page-item"><a
			href="user?page=${ page - 1 }" class="page-link">Previous</a>
		</li>
		<li class="page-item"><a class="page-link">${page }</a></li>
		<li class="page-item"><a
			href="user?page=${ page + 1 }" class="page-link">Next</a>
		</li>
	</ul>

</body>
</html>