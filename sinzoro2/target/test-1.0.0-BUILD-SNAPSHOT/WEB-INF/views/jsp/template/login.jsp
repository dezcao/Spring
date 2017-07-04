<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${not empty param.error }">
		<h2>${SPRING_SECURITY_LAST_EXCEPTION.message }</h2>
	</c:if>

	<c:url var="loginUrl" value="/login" />

	<form id="loginForm" action="${loginUrl }" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

		<table>
			<tr>
				<td style="width: 200px;">name</td>
				<td style="width: 390px"><input type="text" name="username"
					placeholder="NAME" required /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" style="width: 99%;"
					placeholder="PASSWORD" required /></td>
			</tr>
		</table>

		<input type="submit" value="Log in" />
	</form>

	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>




</body>
</html>