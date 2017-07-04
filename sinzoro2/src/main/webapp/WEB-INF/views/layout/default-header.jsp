<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<c:url var="logoutUrl" value="/logout" />
		<form action="${logoutUrl }" method="post">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> <input type="submit"
				class="btn btn-default pull-right" value="Log out" />
		</form>
		</div>
	</div>
</div>


