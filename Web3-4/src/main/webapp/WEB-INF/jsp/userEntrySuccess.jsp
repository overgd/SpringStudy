<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����� ��� Ȯ�� ȭ��</title>
</head>
<body>
<div align="center" class="body">
	<h2>���� Ȯ��</h2>
	<b><font color="red">������ �����մϴ�!</font></b>
	<table>
		<tr>
			<td>�����ID</td>
			<td>${user.userId }</td>
		</tr>
		<tr>
			<td>��ȣ</td>
			<td>${user.password }</td>
		</tr>
		<tr>
			<td>�̸�</td>
			<td>${user.userName }</td>
		</tr>
		<tr>
			<td>�����ȣ</td>
			<td>${user.postCode }</td>
		</tr>
		<tr>
			<td>�ּ�</td>
			<td>${user.address }</td>
		</tr>
		<tr>
			<td>E-Mail</td>
			<td>${user.email }</td>
		</tr>
		<tr>
			<td>����</td>
			<td>${user.job }</td>
		</tr>
		<tr>
			<td>�������</td>
			<td>${user.birthday }</td>
		</tr>
	</table>
</div>
</body>
</html>