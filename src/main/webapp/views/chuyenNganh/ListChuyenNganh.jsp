<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!--Content -->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<br />
<h1>List Chuyên Ngành</h1>
<table class="table">
	<thead class="table-primary">
		<th>STT</th>
		<th>Tên Chuyên Ngành</th>
		<th>&nbsp;</th>
	</thead>
	<tbody>
		<c:forEach var="cn" items="${lst }">
			<tr>
				<td class='personid'>i</td>
				<td>${cn.ten }</td>
				<td><a class="btn btn-primary"
					href="/Lab4_hoangdvph18776/ChuyenNganh/edit?id=${cn.id}"> Cập
						nhật </a> <a class="btn btn-danger"
					href="/Lab4_hoangdvph18776/ChuyenNganh/delete?id=${cn.id}"> Xóa </a>
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
