<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body class="box">
<h1>Giriş Başarili</h1>
<h6> Ooo hoşgeldin ${sessionScope.oturum} :) </h6>

	

	<ul>
<li><a href="/SpringCRUDApp-OgrenciKayitLGN/ogrenci/list">ÖĞRENCİ</a></li>

<li><a href="/SpringCRUDApp-OgrenciKayitLGN/kurs/list">KURS</a></li>

<li><a href="/SpringCRUDApp-OgrenciKayitLGN/employee/list">EMPLOYEE</a></li>


</ul>
<a href="/SpringCRUDApp-OgrenciKayitLGN/user/endsession">ÇIKIŞ</a>

</body>
</html>