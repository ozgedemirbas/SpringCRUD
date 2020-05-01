<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="wrapper">
		<div id="header">
			<h2>Employee Listeleme</h2>
		</div>

	</div>


	<div id="conteiner">
		<div id="content">
			<table>
				<thead>
					<tr>
						<th>Employee Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Phone Number</th>
						<th>Hire Date</th>
						<th>Job</th>
						<th>Salary</th>
						<th>Commission Percent</th>
							<th>Department</th>
						<th>Manager</th>
					
					</tr>
					
					<tr>
					<frm:form action="search" modelAttribute="ara" method="POST">
						<td></td>
					<td><frm:input path="firstName" placeholder="ARA"/>
					<td><frm:input path="lastName" placeholder="ARA"/></td>
					<td></td>
					<td><frm:input path="phoneNumber" placeholder="ARA"/></td>
					<td></td>
					<td></td>
					<td></td>
					<td><frm:input path="manager.firstName" placeholder="ARA"/></td>
					<td><frm:input path="job.jobTitle" placeholder="ARA"/></td>
					<td></td>
					<td><frm:button type="submit" class="button">ARA</frm:button>
					</frm:form>
					</tr>
					
					
					
					
					
					
					
					
					
					
					
					
					
				</thead>
				<tbody>
					<c:forEach items="${employee}" var="dp">
					
					<c:url var="updateLink" value="/employee/employee-guncelle">
							<c:param name="employeeId" value="${dp.employeeId}" />
						</c:url>

						<c:url var="deleteLink" value="/employee/employee-sil">
							<c:param name="employeeId" value="${dp.employeeId}" />
						</c:url>

						<tr>
							<td>${dp.employeeId}</td>
							<td>${dp.firstName}</td>
							<td>${dp.lastName}</td>
							<td>${dp.email}</td>
							<td>${dp.phoneNumber}</td>
							<td>${dp.hireDate}</td>
								<td>${dp.job.jobTitle}</td>
							<td>${dp.salary}</td>
							<td>${dp.commissionPercent}</td>
							<td>${dp.department.departmentName}</td>
							<td>${dp.manager.firstName}</td>
							
			
				<td>
								<!--<a href="${updatelink}"> Güncelle </a>-->
								<button onclick="window.location.href='${updateLink}'"
									class="update-button">Güncelle</button>
									<br>
										<button onclick="if (confirm('Siliyoruz, Emin misin?'))window.location.href='${deleteLink}'"
									class="delete-button">Sil</button>

							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<hr>
			<hr>
			<button class="button" onclick="window.location.href='calisan-ekle'">Çalışan
				Ekle</button>
				<hr>
				<a href="/SpringCRUDApp-OgrenciKayitLGN/user/endsession">ÇIKIŞ</a>
				
				
		</div>

	</div>
</body>
</html>