<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!--Content-->
<br />
<h1>Sửa thông tin sinh viên <span>${sv.hoTen }</span></h1>
<form action="/Lab4_hoangdvph18776/SinhVien/update?id=${sv.id }" method="POST">
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
          value= ${sv.hoTen }
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
          value= ${sv.email }
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
          value= ${sv.sdt }
          required
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
          value= ${sv.avatar }
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
          value= ${sv.password }
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
          value= ${sv.diaChi }
          required
        />
      </div>
      <br />
      <div>
        <label for="">Chuyên ngành</label>
        <select class="form-select" aria-label="Default select example" name="chuyenNganhId" required>
          <c:forEach var ="cn" items="${lstCN }">
          <option value="${cn.id }" ${sv.chuyenNganh.id == cn.id ? "selected" : "" } >${cn.ten }</option>
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
            ${sv.gioiTinh ==1? "checked" :"" }
          />
          <label class="form-check-label" for="gridRadios1"> Nam </label>
          <input
            class="form-check-input"
            type="radio"
            name="gioiTinh"
            id="gridRadio2"
            value="0"
            ${sv.gioiTinh ==0? "checked" :"" }
          />
          <label class="form-check-label" for="gridRadios2"> Nữ </label>
        </div>
      </div>
    </div>
  </div>
  <button class="btn btn-primary">Cập nhật</button>
</form>
<br/>
<!--End Content-->
