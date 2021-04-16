<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

</head>
<body>
	<div>

		<form class="col-6 offset-3 mt-5" method="POST"
			action="/Myweb/LoginServlet">

			<div class="mb-3">

				<label for="email" class="form-label">Email address</label> <input
					type="email" class="form-control" id="email" name="email">

			</div>

			<div class="mb-3">

				<label for="password" class="form-label">Password</label> <input
					type="password" class="form-control" id="password" name="password">

			</div>

			<button type="submit" class="btn btn-primary">Submit</button>

		</form>

	</div>
</body>
</html>