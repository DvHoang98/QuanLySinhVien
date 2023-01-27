<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!--Content-->
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<br />
<h1>Thêm mới môn</h1>
<form action="/Lab4_hoangdvph18776/Mon/store" method="POST">
  <div class="row">
    <div class="col">
      <div>
        <label for="inputEmail4">Tên</label>
        <input
        name ="ten"
          type="text"
          class="form-control"
          id="inputEmail4"
          placeholder="Tên"
          required
        />
        <p style="color:red">${error }</p>
      </div>
      <br />
      <div>
        <label for="">Học kỳ</label>
        <select class="form-select" aria-label="Default select example" name="hocKy" required>
          <option value="" selected>Chọn học kỳ</option>
          <option value="1">Summer 2022</option>
          <option value="2">Spring 2023</option>
          <option value="3">Summer 2023</option>
        </select>
      </div>
    </div>

    <div class="col">
      <div>
        <label for="inputEmail4">Tín chỉ</label>
        <input
        name="soTinChi"
          type="text"
          class="form-control"
          id="inputEmail4"
          placeholder="Tín chỉ"
          required
        />
      </div>
      <br />
    </div>
  </div>
  <button class="btn btn-primary">Thêm</button>
</form>
<!--End Content-->
