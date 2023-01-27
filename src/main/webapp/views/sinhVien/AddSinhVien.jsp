<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!--Content-->
<br />
<h1>Thêm mới sinh viên</h1>
<form action="/Lab4_hoangdvph18776/SinhVien/store" method="POST">
  <div class="row">
    <div class="col">
      <div>
        <label for="inputEmail4">Họ tên</label>
        <input
        name="hoTen"
          type="text"
          class="form-control"
          id="inputEmail4"
          placeholder="Họ tên"
          required
        />
      </div>
      <br />
      <div>
        <label for="inputEmail4">Email</label>
        <input
        name="email"
          type="email"
          class="form-control"
          id="inputEmail4"
          placeholder="Email"
          required
        />
        <p style="color:red">${error }</p>
      </div>
      <br />
      <div>
        <label for="inputEmail4">SĐT</label>
        <input
        name="sdt"
          type="number"
          class="form-control"
          id="inputEmail4"
          placeholder="Số điện thoại"
          required
          pattern="84|0[3|5|7|8|9])+([0-9]{8}"
        />
      </div>
      <br />
      <div>
        <label for="exampleFormControlFile1">Avatar</label>
        <input
        name="avatar"
          type="file"
          class="form-control-file"
          id="exampleFormControlFile1"
          required
        />
      </div>
      <br />
    </div>

    <div class="col">
      <div>
        <label for="inputEmail4">Password</label>
        <input
        name="password"
          type="password"
          class="form-control"
          id="inputEmail4"
          placeholder="Số điện thoại"
          required
        />
      </div>
      <br />
      <div>
        <label for="inputEmail4">Địa chỉ</label>
        <input
        name="diaChi"
          type="text"
          class="form-control"
          id="inputEmail4"
          placeholder="Địa chỉ"
          required
        />
      </div>
      <br />
      <div>
        <label for="">Chuyên ngành</label>
        <select class="form-select" aria-label="Default select example" name="chuyenNganhId" required>
          <option value="" selected disabled="disabled">Chọn chuyên ngành</option>
          <c:forEach var ="cn" items="${lstCN }">
          <option value="${cn.id }">${cn.ten }</option>
			</c:forEach>
        </select>
      </div>
      <br />
      <div>
        <label for="inputEmail4">Giới tính</label>
        <br />
        <div>
          <input
            class="form-check-input"
            type="radio"
            name="gioiTinh"
            id="1"
            value="1"
            checked
          />
          <label class="form-check-label" for="gridRadios1"> Nam </label>
          <input
            class="form-check-input"
            type="radio"
            name="gioiTinh"
            id="gridRadio2"
            value="2"
          />
          <label class="form-check-label" for="gridRadios2"> Nữ </label>
        </div>
      </div>
    </div>
  </div>
  <button class="btn btn-primary">Thêm</button>
</form>
<!--End Content-->
