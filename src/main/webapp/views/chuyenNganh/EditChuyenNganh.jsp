<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!--Content-->
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<br />
<h1>Sửa chuyên ngành</h1>
<form action="/Lab4_hoangdvph18776/ChuyenNganh/update?id=${cn.id }" method="POST">
  <div class="row">
    <div class="col">
      <div>
        <label for="inputEmail4">Tên chuyên ngành</label>
        <input
        name="ten"
          type="text"
          class="form-control"
          id="inputEmail4"
          placeholder="Chuyên ngành"
          value ="${cn.ten }"
          required
        />
        <p style="color:red">${error }</p>
      </div>
      <br />
    </div>
  </div>
  <button class="btn btn-primary">Cập nhật</button>
</form>
<!--End Content-->
