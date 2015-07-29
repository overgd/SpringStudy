<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>사용자 등록 확인 화면</title>
</head>
<body>
<div align="center" class="body">
	<h2>가입 확인</h2>
	<b><font color="red">가입을 축하합니다!</font></b>
	<table>
		<tr>
			<td>사용자ID</td>
			<td>${user.userId }</td>
		</tr>
		<tr>
			<td>암호</td>
			<td>${user.password }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${user.userName }</td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td>${user.postCode }</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>${user.address }</td>
		</tr>
		<tr>
			<td>E-Mail</td>
			<td>${user.email }</td>
		</tr>
		<tr>
			<td>직업</td>
			<td>${user.job }</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>${user.birthday }</td>
		</tr>
	</table>
</div>
</body>
</html>