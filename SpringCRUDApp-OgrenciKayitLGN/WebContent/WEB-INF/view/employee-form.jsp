<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
<div id="wrapper">
		<div id="header">
			<h2>Çalışan Formu</h2>
			</div>
			<frm:form action="employee-kaydet" modelAttribute="employee" method="POST">
				<frm:hidden path="employeeId"/>
				<table>
					<tr>
						<td><label>First Name</label></td>
						<td><frm:input path="firstName" /></td>
						<td class="white"><frm:errors class="error" path="firstName"/></td>
						
					</tr>
					<tr>
						<td><label>Last Name</label></td>
						<td><frm:input path="lastName" /></td>
						<td class="white"><frm:errors class="error" path="lastName"/></td>
					</tr>
					<tr>
						<td><label>E-mail</label></td>
						<td><frm:input path="email" /></td>
						<td class="white"><frm:errors class="error" path="email"/></td>
					</tr>
					<tr>
						<td><label>Phone Number</label></td>
						<td><frm:input path="phoneNumber" /></td>
						<td class="white"><frm:errors class="error" path="phoneNumber"/></td>
						
					</tr>
					<tr>
						<td><label>Hire Date</label></td>
						<td><frm:input path="hireDate" /></td>
						<td><frm:errors class="error" path="hireDate"/></td>
					</tr>
					<tr>
						<td><label>Job</label></td>
						<td><frm:select path="job.jobId">
							<frm:options items="${jobs}"/> 
							</frm:select>
						</td>
					</tr>
					<tr>
						<td><label>Salary</label></td>
						<td><frm:input path="salary" /></td>
						<frm:errors class="error" path="salary"/>
					</tr>
					<tr>
						<td><label>Department</label></td>
						<td><frm:select path="department.departmentId">
							<frm:options items="${departments}"/> 
							</frm:select>
						</td>
					</tr>
					<tr>
						<td><label>Manager</label></td>
						<td><frm:select path="manager.employeeId">
							<frm:options items="${employeeList}"/> 
							</frm:select>
						</td>
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