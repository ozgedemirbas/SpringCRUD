<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Öğrenciler</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Öğrenci Formu</h2>
		</div>
		<frm:form action="ogrenci-kaydet" modelAttribute="ogrenci"
			method="POST">
			<frm:hidden path="id" />
			<table>
				<tr>
					<td><label>Isim</label></td>
					<td><frm:input path="isim" /></td>
				</tr>
				<tr>
					<td><label>Soyisim</label></td>
					<td><frm:input path="soyisim" /></td>
				</tr>
				<tr>
					<td><label>Öğrenci No</label></td>
					<td><frm:input path="ogrenciNo" /></td>
				</tr>

				<tr>
					<td></td>
					<td><frm:button value="save" name="save" class="button">Kaydet</frm:button></td>

				</tr>

			</table>
			<a href="/SpringCRUDApp-OgrenciKayitLGN/user/endsession">ÇIKIŞ</a>
		</frm:form>

	</div>

	<div id="container">
		<div id="content"></div>



	</div>


</body>
</html>