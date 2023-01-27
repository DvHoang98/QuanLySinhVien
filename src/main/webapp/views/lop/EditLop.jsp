<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!--Content-->
        <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<br />
<h1>Sửa lớp</h1>
<form  action="/Lab4_hoangdvph18776/Lop/update?id=${lop.id }" method="POST">
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
          value="${lop.ten }"
        />
        <p style="color:red">${error }</p>
      </div>
      <br />
      <div>
        <label for="">Khóa</label>
        <input type="number"
			class="form-control"  name ="khoa" required="required" value="${ lop.khoa}"/>
      </div>
    </div>

    <div class="col">
      <div>
        <label for="">Chuyên ngành</label>
        <select class="form-select" aria-label="Default select example"name ="chuyenNganhId" required>
          <c:forEach var ="cn" items="${lstCN }">
          <option value="${cn.id }">${cn.ten }</option>
			</c:forEach>
        </select>
      </div>
      <br />
      <div>
        <label for="">Môn</label>
        <select class="form-select" aria-label="Default select example"name ="monId" required>
          <c:forEach var ="mon" items="${lstMon }">
          <option value="${mon.id }">${mon.ten }</option>
			</c:forEach>
        </select>
      </div>
    </div>
  </div>
  <button class="btn btn-primary">Cập nhật</button>
</form>
<!--End Content-->
