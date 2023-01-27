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
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <link
      rel="stylesheet"
      href="/Lab4_hoangdvph18776/bootstrap/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="/Lab4_hoangdvph18776/css/style.css" />
</head>
<body>
    <header>
      <nav>
        <div>
          <img src="/Lab4_hoangdvph18776/img/logo.png" alt="" class="brand" style="" />
        </div>
        <ul>
          <li>
            <a href="/Lab4_hoangdvph18776/SinhVien"
              ><i class="fa fa-home" aria-hidden="true"></i> Sinh Viên</a
            >
          </li>
          <li>
            <a href="/Lab4_hoangdvph18776/ChuyenNganh"
              ><i class="fa fa-info" aria-hidden="true"></i> Chuyên Ngành</a
            >
          </li>
          <li>
            <a href="/Lab4_hoangdvph18776/Lop"
              ><i class="fa fa-truck" aria-hidden="true"></i> Lớp</a
            >
          </li>
          <li>
            <a href="/Lab4_hoangdvph18776/Mon"
              ><i class="fa fa-telegram" aria-hidden="true"></i> Môn</a
            >
          </li>
        </ul>
      </nav>
    </header>
    <section class="section1"></section>
    <div class="container">
      <div class="row">
        <div class="col-2">
          <div class="b-example-divider"></div>

          <div class="d-flex flex-column flex-shrink-0 p-3 bg-light">
            <a
              href="/"
              class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none"
            >
              <svg class="bi me-2" width="40" height="32">
              </svg>
              <span class="fs-4">Menu</span>
            </a>
            <hr />
            <ul class="nav nav-pills flex-column mb-auto">
              <li class="nav-item">
                <a href="/Lab4_hoangdvph18776/${type }/index" class="nav-link link-dark">
                  <svg class="bi me-2" width="16" height="16">
                  </svg>
                  List
                </a>
              </li>
              <li>
                <a href="/Lab4_hoangdvph18776/${type }/create" class="nav-link link-dark">
                  <svg class="bi me-2" width="16" height="16">
                  </svg>
                  AddNew
                </a>
              </li>
            </ul>
            <hr />
          </div>
        </div>
        <div class="col-10">
          <div>
			<jsp:include page="${views }"></jsp:include>
          </div>
        </div>
      </div>
    </div>

    <footer>
      <div class="container">
        <div class="row">
          <div class="col-3">
            <h3>Thông tin liên hệ</h3>
            <p><a href="" class="coSo">Cơ sở Hà Nội</a></p>
            <p>Phố Trịnh Văn Bô, Nam Từ Liêm, Hà Nội</p>
            <p>(024) 7300 1955</p>
            <br />
            <p><a href="" class="coSo">Cơ sở Cần Thơ</a></p>
            <p>Nguyễn Văn Linh, phường An Khánh, quận Ninh Kiều</p>
            <p>(0292) 7300 468</p>
          </div>
          <div class="col-3">
            <h3>&nbsp;</h3>
            <p><a href="" class="coSo">Cơ sở HCM</a></p>
            <p>Phố Trịnh Văn Bô, Nam Từ Liêm, Hà Nội</p>
            <p>(024) 7300 1955</p>
            <br />
            <p><a href="" class="coSo">Cơ sở Cần Thơ</a></p>
            <p>Nguyễn Văn Linh, phường An Khánh, quận Ninh Kiều</p>
            <p>(0292) 7300 468</p>
          </div>
          <div class="col-6">
            <h4>Đăng ký để nhận tư vấn</h4>
            <p>Đăng ký để tư vấn viên có thể gọi điện tư vấn</p>
            <br />
            <div class="row">
              <div class="form-group mx-sm-3 mb-2 col-6">
                <input
                  type="password"
                  class="form-control"
                  id="inputPassword2"
                  placeholder="Nhập số điện thoại"
                />
              </div>
              <div class="col-5">
                <button type="submit" class="btn btn-success mb-2">
                  Đăng ký
                </button>
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
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>