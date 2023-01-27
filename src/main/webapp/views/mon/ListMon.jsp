<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!--Content -->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<br />
<h1>List môn</h1>
<table>
  <table class="table">
    <thead class="table-primary">
      <th>ID</th>
      <th>Tên</th>
      <th>Học Kỳ</th>
      <th>Số tín chỉ</th>
      <th>&nbsp;</th>
    </thead>
    <tbody>
    <c:forEach var="mon" items="${ lstMon}">
      <tr>
        <td class='personid'>i</td>
        <td>${mon.ten }</td>
		<td>${mon.hocKy }</td>
        <td>${mon.soTinChi }</td>
        <td><a class="btn btn-primary"
					href="/Lab4_hoangdvph18776/Mon/edit?id=${mon.id}"> Cập
						nhật </a> <a class="btn btn-danger"
					href="/Lab4_hoangdvph18776/Mon/delete?id=${mon.id}"> Xóa </a>
				</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</table>
<script>
var count =1;
var list = document.getElementsByClassName("personid");
for (var i = 0; i <= list.length; i++) {
    list[i].innerHTML = count;
    count++;
}
</script>
<!--End Content -->
