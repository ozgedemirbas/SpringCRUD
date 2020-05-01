<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kurs Listesi</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Kurs Formu</h2>
		</div>
		<frm:form action="kurs-kaydet" modelAttribute="kurs" method="POST">
		<frm:hidden path="id"/>
			<table>

				<tr>
					<td><label>Kurs Adı</label></td>
					<td><frm:input path="kursAdi" /></td>
				</tr>
				<tr>
					<td><label>Saat</label></td>
					<td><frm:input path="saat" /></td>
				</tr>

			</table>
			<hr>
			<button value="submit" class="button">Kaydet</button>
			<a href="/SpringCRUDApp-OgrenciKayitLGN/user/endsession">ÇIKIŞ</a>
		</frm:form>

	</div>
</body>
</html>