<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!--Content-->
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<br />
<h1>Sửa môn</h1>
<form  action="/Lab4_hoangdvph18776/Mon/update?id=${mon.id }" method="POST">
  <div class="row">
    <div class="col">
      <div>
        <label for="inputEmail4">Tên</label>
        <input
        name="ten"
          type="text"
          class="form-control"
          id="inputEmail4"
          placeholder="Tên"
          value="${mon.ten }"
          required
        />
        <p style="color:red">${error }</p>
      </div>
      <br />
      <div>
        <label for="">Học kỳ</label>
          <input
            type="number"
            class="form-control"
            name ="hocKy" required="required"
               value="${mon.hocKy }"
          />
      </div>
    </div>

    <div class="col">
      <div>
        <label for="inputEmail4">Tín chỉ</label>
        <input
        name="soTinChi"
          type="number"
          class="form-control"
          id="inputEmail4"
          placeholder="Tín chỉ"
          value="${mon.soTinChi }"
          required
        />
      </div>
      <br />
    </div>
  </div>
  <button class="btn btn-primary">Cập nhật</button>
</form>
<!--End Content-->
