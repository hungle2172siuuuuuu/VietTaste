<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <title>Bài 2</title>
    <link rel="icon" type="image/x-icon" href="assets/img/anh.png.jpg" />
    <link rel="stylesheet" href="assets/css/styles.css" />
    <style>
    </style>
</head>

<body>
    <header class="d-flex align-items-center my-2">
        <div class="container px-4 px-lg-5 text-center">
            <a class="btn btn-primary btn-xl" href="bai3">BÁO CÁO TÀI CHÍNH</a>
        </div>
    </header>
    <div id="lab6" class="m-auto w-75">
		<div class="my-3">
			<h3>Báo Cáo Tài Chính</h3>
			<table class="table table-collapse table-bordered">
				<tr class="bg-success text-white">
					<th>Loại hàng</th>
					<th>Tổng giá</th>
					<th>Số sản phẩm</th>
				</tr>
				<c:forEach var="item" items="${items}">
					<tr>
						<td>${item.group.name}</td>
						<td>$ ${item.sum}</td>
						<td>${item.count}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
    <footer class="footer text-center m-auto w-75 py-3">
	<hr />
        <div class="container px-4 px-lg-5">
            <p class="text-muted mb-0">HUỲNH VĂN TIẾN<br>PS31912</p>
        </div>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>