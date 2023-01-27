<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%!int stt = 0;%>
<!--Content -->
<br>
<h1>List sinh viên</h1>
<table class="table">
	<thead class="table-primary">
		<th>STT</th>
		<th>Họ tên</th>
		<th>Email</th>
		<th>Địa Chỉ</th>
		<th>SĐT</th>
		<th>Giới tính</th>
		<th>Chuyên ngành</th>
		<th>Avatar</th>
		<th>&nbsp;</th>
	</thead>
	<tbody>
		<c:forEach var="sv" items="${ds }">
			<tr>
				<td class='personid'>i</td>
				<td>${sv.hoTen }</td>
				<td>${sv.email }</td>
				<td>${ sv.diaChi}</td>
				<td>${ sv.sdt}</td>
				<td>${ sv.gioiTinh ==1?"Nam":"Nữ"}</td>
				<td>${ sv.chuyenNganh.ten}</td>
				<td></td>
				<td><a class="btn btn-primary"
					href="/Lab4_hoangdvph18776/SinhVien/edit?id=${sv.id}"> Cập
						nhật </a> <a class="btn btn-danger"
					href="/Lab4_hoangdvph18776/SinhVien/delete?id=${sv.id}"> Xóa </a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
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