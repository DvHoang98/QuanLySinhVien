<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!--Content-->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<br />
<h1>Thông tin lớp</h1>

<div class="row">
	<div class="col">
		<div>
			<label for="inputEmail4">Tên lớp</label> <input name="ten"
				type="text" class="form-control" id="inputEmail4" placeholder="Tên"
				value="${lop.ten }" disabled />
		</div>
		<br />
		<div>
			<label for="">Khóa</label> <select class="form-select"
				aria-label="Default select example" name="khoa">
				<option disabled selected>${lop.khoa }</option>
			</select>
		</div>
		<div>
		<form method="post" action="/Lab4_hoangdvph18776/SinhVienLop/import?idLop=${lop.id}" enctype="multipart/form-data">
    <input type="file" name="multiPartServlet" accept=".xlsx"> 
    			<button type="submit" class="btn btn-primary"
							
							  value="Upload"> Import </button>
</form>
			

			<a type="button" class="btn btn-primary"
							href="/Lab4_hoangdvph18776/SinhVienLop/export?idLop=${lop.id}"
							method="POST"> Export </a>
		</div>
	</div>

	<div class="col">
		<div>
			<label for="">Chuyên ngành</label> <select class="form-select"
				aria-label="Default select example" name="chuyenNganhId">
				<option disabled selected>${lop.chuyenNganh.ten }</option>
				<%-- <c:forEach var="cn" items="${lstCN }">
					<option value="${cn.id }">${cn.ten }</option>
				</c:forEach> --%>
			</select>
		</div>
		<br />
		<div>
			<label for="">Môn</label> <select class="form-select"
				aria-label="Default select example" name="monId">
				<option disabled selected>${lop.mon.ten }</option>
				<%-- <c:forEach var="mon" items="${lstMon }">
					<option value="${mon.id }">${mon.ten }</option>
				</c:forEach> --%>
			</select>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-6">
		<h2>Sinh Viên ngoài lớp</h2>
		<table class="table">
			<thead class="table-primary">
				<th>STT</th>
				<th>Họ tên</th>
				<th>Email</th>
				<th>Giới tính</th>
				<th>&nbsp;</th>
			</thead>
			<tbody>
				<c:forEach var="sv" items="${svOutLop}">
					<tr>
						<th  class='personid'></th>
						<td>${sv.hoTen }</td>
						<td>${sv.email }</td>
						<th>${ sv.gioiTinh ==1?"Nam":"Nữ"}</th>
						<td><a type="button" class="btn btn-primary"
							href="/Lab4_hoangdvph18776/SinhVienLop/store?idSv=${sv.id}&idLop=${lop.id}"
							method="POST"> + </a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="col-6">
		<h2>Sinh Viên trong lớp</h2>
		<table class="table">
			<thead class="table-primary">
				<th>STT</th>
				<th>Họ tên</th>
				<th>Email</th>
				<th>Điểm trung bình</th>
				<th>Giới tính</th>
				<th>&nbsp;</th>
			</thead>
			<tbody>
				<c:forEach var="svl" items="${svInLop}">
					<tr>
						<th  class='personid2'></th>
						<td>${svl.sinhVien.hoTen }</td>
						<td>${svl.sinhVien.email }</td>
						<td>${svl.diemTb }</td>
						<th>${ svl.sinhVien.gioiTinh ==1?"Nam":"Nữ"}</th>
						<td><a type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal"> Điểm </a>
							<a class="btn btn-danger"
							href="/Lab4_hoangdvph18776/SinhVienLop/delete?idSv=${svl.sinhVien.id}&idLop=${lop.id}">
								-</a></td>
					</tr>
					<!-- The Modal -->
					<div class="modal fade" id="myModal">
						<div class="modal-dialog modal-dialog-centered">
							<div class="modal-content">
								<!-- Modal Header -->
								<div class="modal-header">
									<h4 class="modal-title">Sửa ĐTB</h4>
									<button type="button" class="close" data-dismiss="modal">
										&times;</button>
								</div>

								<!-- Modal body -->
								<form name="myForm" action="/Lab4_hoangdvph18776/SinhVienLop/update?idsvl=${svl.id }"
									method="post" onsubmit="return validateDiem()">
									<div class="modal-body">

										<label for="" class="form-label">Điểm TB: </label> <input
											type="number" class="form-control" name="diemTb"
											value="${svl.diemTb}
											" 
											inputmode="numeric" pattern="\d*"/>
									</div>
										<p class="errorDiem"></p>
									<!-- Modal footer -->
									<div class="modal-footer">
										<button type="submit" class="btn btn-success">
											Sửa</button>

									</div>
								</form>
							</div>
						</div>
					</div>
					<!-- End modal -->
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<script>
	function validateDiem() {
		let x = document.forms["myForm"]["diemTb"].value;
		if(x>=10||x<=0){
			alert("Nhập sai điểm rồi");
			return false;
		}
	}
</script>
<script>
var count =1;
var list = document.getElementsByClassName("personid");
for (var i = 0; i <= list.length; i++) {
    list[i].innerHTML = count;
    count++;
}
</script>
<script>
var count =1;
var list = document.getElementsByClassName("personid2");
for (var i = 0; i <= list.length; i++) {
    list[i].innerHTML = count;
    count++;
}
</script>
<!--End Content-->
