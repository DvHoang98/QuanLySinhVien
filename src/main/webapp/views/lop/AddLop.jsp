<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!--Content-->
        <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<br />
<h1>Thêm mới lớp</h1>
<form  action="/Lab4_hoangdvph18776/Lop/store" method="POST">
  <div class="row">
    <div class="col">
    <div>
        <label for="inputEmail4">Tên lớp</label>
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
        <label for="">Khóa</label>
        <select class="form-select" aria-label="Default select example" name ="khoa" required>
          <option value="" disable selected>Chọn Khóa</option>
          <option value="11">11</option>
          <option value="12">12</option>
          <option value="13">13</option>
          <option value="14">14</option>
        </select>
      </div>
    </div>

    <div class="col">
      <div>
        <label for="">Chuyên ngành</label>
        <select class="form-select" aria-label="Default select example" name ="chuyenNganhId" required>
          <option value="" disable selected>Chọn chuyên ngành</option>
          <c:forEach var ="cn" items="${lstCN }">
          <option value="${cn.id }">${cn.ten }</option>
			</c:forEach>
        </select>
      </div>
      <br />
      <div>
        <label for="">Môn</label>
        <select class="form-select" aria-label="Default select example" name ="monId" required>
          <option value="" disable selected >Chọn Môn</option>
          <c:forEach var ="mon" items="${lstMon }">
          <option value="${mon.id }">${mon.ten }</option>
			</c:forEach>
        </select>
      </div>
    </div>
  </div>
  <button class="btn btn-primary">Thêm</button>
</form>
<!--End Content-->
