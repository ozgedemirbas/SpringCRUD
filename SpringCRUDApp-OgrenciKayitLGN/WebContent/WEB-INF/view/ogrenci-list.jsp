<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
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
			<h2>Öğrenci Listeleme</h2>
		</div>
		<hr>
	</div>
	<div id="container">
		<div id="content">
			<br>
			<table class="tab">
				<thead>
					<tr>
						<th>ID</th>
						<th>ISIM</th>
						<th>SOYISIM</th>
						<th>OGRENCİ NO</th>
						<th>İslem</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${ogrenciler}" var="ogrenci">
						<c:url var="updateLink" value="/ogrenci/ogrenci-guncelle">
							<c:param name="ogrenciId" value="${ogrenci.id}" />
						</c:url>

						<c:url var="deleteLink" value="/ogrenci/ogrenci-sil">
							<c:param name="ogrenciId" value="${ogrenci.id}" />
						</c:url>


						<tr>
							<td>${ogrenci.id}</td>
							<td>${ogrenci.isim}</td>
							<td>${ogrenci.soyisim}</td>
							<td>${ogrenci.ogrenciNo}</td>
							<td>
								<!--<a href="${updatelink}"> Güncelle </a>-->
								<button onclick="window.location.href='${updateLink}'"
									class="update-button">Güncelle</button>
									
										<button onclick="if (confirm('Siliyoruz, Emin misin?'))window.location.href='${deleteLink}'"
									class="delete-button">Sil</button>

							</td>
						</tr>

					</c:forEach>

				</tbody>

			</table>
			<hr>
			<button class="button" onclick="window.location.href='ogrenci-ekle'">Öğrenci
				Ekle</button>
				<a href="/SpringCRUDApp-OgrenciKayitLGN/user/endsession">ÇIKIŞ</a>
		</div>
	</div>
</body>
</html>