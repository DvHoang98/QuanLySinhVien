<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!--Content -->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<br />
<h1>List lớp</h1>
<table class="table">
	<thead class="table-primary">
		<th>STT</th>
		<th>Tên Lớp</th>
		<th>Môn</th>
		<th>Chuyên ngành</th>
		<th>Khóa</th>
		<th>&nbsp;</th>
	</thead>
	<tbody>
		<c:forEach var="lop" items="${ lst}">
			<tr>
				<th class='classid'></th>
				<td>${lop.ten }</td>
				<td>${lop.mon.ten }</td>
				<td>${lop.chuyenNganh.ten }</td>
				<th>${lop.khoa }</th>
				<td><a class="btn btn-primary"
					href="/Lab4_hoangdvph18776/Lop/edit?id=${lop.id}"> Cập nhật </a> <a
					class="btn btn-danger"
					href="/Lab4_hoangdvph18776/Lop/delete?id=${lop.id}"> Xóa </a> <a
					class="btn btn-danger"
					href="/Lab4_hoangdvph18776/SinhVienLop/detail?id=${lop.id}"> Thông tin </a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script>
var count =1;
var list = document.getElementsByClassName("classid");
for (var i = 0; i <= list.length; i++) {
    list[i].innerHTML = count;
    count++;
}
</script>
<!--End Content -->
