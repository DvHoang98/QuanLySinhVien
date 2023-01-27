<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FPT Poly</title>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="/Lab4_hoangdvph18776/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet" href="/Lab4_hoangdvph18776/css/style.css" />
</head>
<body>
	<header>
		<nav>
			<div>
				<img src="/Lab4_hoangdvph18776/img/logo.png" alt="" class="brand"
					style="" />
			</div>
			<ul>
				<li><a href="/Lab4_hoangdvph18776/SinhVien"><i
						class="fa fa-home" aria-hidden="true"></i> Sinh Viên</a></li>
				<li><a href="/Lab4_hoangdvph18776/ChuyenNganh"><i
						class="fa fa-info" aria-hidden="true"></i> Chuyên Ngành</a></li>
				<li><a href="/Lab4_hoangdvph18776/Lop"><i
						class="fa fa-truck" aria-hidden="true"></i> Lớp</a></li>
				<li><a href="/Lab4_hoangdvph18776/Mon"><i
						class="fa fa-telegram" aria-hidden="true"></i> Môn</a></li>
			</ul>
		</nav>
	</header>
	<section class="section1"></section>
	<br/>
	<div class="container" style="text-align: left">
	<form action="/Lab4_hoangdvph18776/login" method="POST">

		<div class="form-outline mb-4"  style="width: 400px">
			<input type="email" id="form2Example1" class="form-control" name="email"/> <label
				class="form-label" for="form2Example1">Email address</label>
		</div>

		<div class="form-outline mb-4"  style="width: 400px">
			<input type="password" id="form2Example2" class="form-control" name="password"/> <label
				class="form-label" for="form2Example2" style="width: 400px">Password</label>
		</div>
		<p style="color:red">${error }</p>
		<div class="row mb-4">

			<div class="col">
				<a href="#!">Forgot password?</a>
			</div>
		</div>

		<button type="submit" class="btn btn-primary btn-block mb-4">Sign
			in</button>

		<div class="text-center">
			<p>Sign up with:</p>
			<button type="button" class="btn btn-link btn-floating mx-1">
				<i class="fab fa-facebook-f"></i>
			</button>

			<button type="button" class="btn btn-link btn-floating mx-1">
				<i class="fab fa-google"></i>
			</button>

			<button type="button" class="btn btn-link btn-floating mx-1">
				<i class="fab fa-twitter"></i>
			</button>

			<button type="button" class="btn btn-link btn-floating mx-1">
				<i class="fab fa-github"></i>
			</button>
		</div>
	</form>
	</div>

	<footer>
		<div class="container">
			<div class="row">
				<div class="col-3">
					<h3>Thông tin liên hệ</h3>
					<p>
						<a href="" class="coSo">Cơ sở Hà Nội</a>
					</p>
					<p>Phố Trịnh Văn Bô, Nam Từ Liêm, Hà Nội</p>
					<p>(024) 7300 1955</p>
					<br />
					<p>
						<a href="" class="coSo">Cơ sở Cần Thơ</a>
					</p>
					<p>Nguyễn Văn Linh, phường An Khánh, quận Ninh Kiều</p>
					<p>(0292) 7300 468</p>
				</div>
				<div class="col-3">
					<h3>&nbsp;</h3>
					<p>
						<a href="" class="coSo">Cơ sở HCM</a>
					</p>
					<p>Phố Trịnh Văn Bô, Nam Từ Liêm, Hà Nội</p>
					<p>(024) 7300 1955</p>
					<br />
					<p>
						<a href="" class="coSo">Cơ sở Cần Thơ</a>
					</p>
					<p>Nguyễn Văn Linh, phường An Khánh, quận Ninh Kiều</p>
					<p>(0292) 7300 468</p>
				</div>
				<div class="col-6">
					<h4>Đăng ký để nhận tư vấn</h4>
					<p>Đăng ký để tư vấn viên có thể gọi điện tư vấn</p>
					<br />
					<div class="row">
						<div class="form-group mx-sm-3 mb-2 col-6">
							<input type="password" class="form-control" id="inputPassword2"
								placeholder="Nhập số điện thoại" />
						</div>
						<div class="col-5">
							<button  class="btn btn-success mb-2">Đăng
								ký</button>
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-1">
							<i class="fa fa-facebook-f"></i>
						</div>
						<div class="col-1">
							<i class="fa fa-instagram"></i>
						</div>
						<div class="col-1">
							<i class="fa fa-twitter" aria-hidden="true"></i>
						</div>
						<div class="col-1">
							<i class="fa fa-google" aria-hidden="true"></i>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>