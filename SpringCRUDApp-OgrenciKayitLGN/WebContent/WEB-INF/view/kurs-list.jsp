<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<h2>Kurs Listeleme</h2>
		</div>

	</div>

	<div id="conteiner">
		<div id="content">
			<table>
				<thead>

				</thead>
				<tr>
					<th>Kurs Adı</th>
					<th>Saat</th>
					<th>İşlemler</th>
				</tr>
				<tbody>
					<c:forEach items="${kurslar}" var="kr">
						<c:url var="updateLink" value="/kurs/kurs-guncelle">
							<c:param name="kursId" value="${kr.id}"></c:param>
						</c:url>

						<c:url var="deleteLink" value="/kurs/kurs-sil">
							<c:param name="kursId" value="${kr.id}"></c:param>
						</c:url>
						<tr>
							<!--  <td>${kr.id}</td>-->
							<td>${kr.kursAdi}</td>
							<td>${kr.saat}</td>
							<td>
								<button onclick="window.location.href='${updateLink}'"
									class="update-button">Güncelle</button>

								<button
									onclick="if(confirm('Silinecek, Emin Misin?'))window.location.href='${deleteLink}'"
									class="delete-button">Sil</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
			<hr>
			<button class="button" onclick="window.location.href='kurs-ekle'" class="button">Kurs
				Ekle</button>
				<a href="/SpringCRUDApp-OgrenciKayitLGN/user/endsession">ÇIKIŞ</a>
		</div>

	</div>
</body>
</html>