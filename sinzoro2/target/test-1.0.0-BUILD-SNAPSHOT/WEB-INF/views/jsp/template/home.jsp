<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  id is ${vo.id}. </P>
<P>  name is ${vo.name}. </P>

스프링 폼태그가 아닌경우는 다음과 같은 인풋태그를 삽입해야 한다. 스프링 폼태그이면 기본제공 되므로
백단에서의 처리만 하면 된다.

아작스시 csrf는 별도 작업이 있어야 한다.

<c:url var="logoutUrl" value="/logout" />

<form action="${logoutUrl }" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<input type="submit" value="Log out" />

</form>
</body>
</html>
