<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��ǰ �� ����</title>
</head>
<body>
<div align="center">
<h2>��ǰ �� ����</h2>
<table>
	<tr>
		<td><img src="img/${item.pictureUrl }"></td>
		<td>
			<table>
				<tr height="50">
					<td width="80">��ǰ�̸�</td>
					<td width="100">${item.itemName }</td>
				</tr>
				<tr height="50">
					<td width="80">����</td>				
					<td width="100">${item.price }</td>
				</tr>
				<tr height="50">
					<td width="80">���</td>
					<td width="100">${item.description }</td>
				</tr>
				<tr>
					<td colspan="2" align="center" width="240">
						<a href="index.html">������� ���ư���</a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</div>
</body>
</html>