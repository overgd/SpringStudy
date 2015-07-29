<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����� ��� ȭ��</title>
</head>
<body>
<div align="center" class="body">
	<h2>����� ��� ȭ��</h2>
	<form:form modelAttribute="user" method="post" action="userEntry.html">
		<spring:hasBindErrors name="user">
			<font color="red">
				<c:forEach var="error" items="${errors.globalErrors }">
					<spring:message code="${error.code }"/>
				</c:forEach>
			</font>
		</spring:hasBindErrors>
		<table>
			<tr height="40px">
				<td>�����</td>
				<td><form:input path="userId" maxlength="20" cssClass="userId"/>
				<font color="red"><form:errors path="userId"></form:errors> </font>
				</td>
			</tr>
			<tr height="40px">
				<td>�н�����</td>
				<td><form:input path="password" maxlength="20" cssClass="userId"/>
				<font color="red"><form:errors path="password"></form:errors> </font>
				</td>
			</tr>
			<tr height="40px">
				<td>�̸�</td>
				<td><form:input path="userName" maxlength="20" cssClass="userId"/>
				<font color="red"><form:errors path="userName"></form:errors> </font>
				</td>
			</tr>
			<tr height="40px">
				<td>������ȣ</td>
				<td><form:input path="postCode" maxlength="20" cssClass="userId"/>
				<font color="red"><form:errors path="postCode"></form:errors> </font>
				</td>
			</tr>
			<tr height="40px">
				<td>�ּ�</td>
				<td><form:input path="address" maxlength="20" cssClass="userId"/>
				<font color="red"><form:errors path="address"></form:errors> </font>
				</td>
			</tr>
			<tr height="40px">
				<td>Email</td>
				<td><form:input path="email" maxlength="20" cssClass="userId"/>
				<font color="red"><form:errors path="email"></form:errors> </font>
				</td>
			</tr>
			<tr height="40px">
				<td>����</td>
				<td>
					<form:select path="job" cssClass="jobs">
					<form:option value="��ȸ��" label="��ȸ��"/>
					<form:option value="�����ֹ�" label="�����ֹ�"/>
					<form:option value="��Ÿ" label="��Ÿ"/>
					</form:select>
				</td>
			</tr>
			<tr height="40px">
				<td>�������</td>
				<form:input path="birthday" maxlength="10" cssClass="birthday"/>
				<font color="red"><form:errors path="birthday"></form:errors> </font>
			</tr>
		</table>
		<table>
			<tr>
				<td height="40px" align="center">
				<input type="submit" name="btnSubmit" value="Ȯ��"/>
				</td>
				<td height="40px" align="center">
				<input type="reset" name="btnReset" value="���"/>
				</td>
			</tr>
		</table>
	</form:form>
</div>
</body>
</html>