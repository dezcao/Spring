<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@page import="java.util.*"%>
<%
    request.setCharacterEncoding("UTF-8");
%>

<div class="navbar-header">
	<button type="button" 
		class="navbar-toggle collapsed"
		data-toggle="collapse"	data-target="#navbar" aria-expanded="false"	aria-controls="navbar">
		<span class="sr-only">Toggle navigation</span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
	</button>
	<a class="navbar-brand" href="<c:url value="/home/home" />">Spring4.0</a>
</div>
<div id="navbar" class="navbar-collapse collapse">
	<ul class="nav navbar-nav">
		<li id="home_li"><a href="<c:url value="/home/home" />">Home</a></li>
		<li id="board_li"><a href="<c:url value="/home/board" />">Board</a></li>
		<li id="contact_li"><a href="<c:url value="/home/contact" />">Contact</a></li>
		<li id="dropdown_li" class="dropdown">
			<a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button" aria-haspopup="true"
				aria-expanded="false">
				Dropdown<span class="caret"></span>
			</a>
			<ul class="dropdown-menu">
				<li><a href="#">Action</a></li>
				<li><a href="#">Another action</a></li>
				<li><a href="#">Something else here</a></li>
				<li role="separator" class="divider"></li>
				<li class="dropdown-header">Nav header</li>
				<li><a href="#">Separated link</a></li>
				<li><a href="#">One more separated link</a></li>
			</ul>
		</li>
		<li id="signUp_li"><a href="<c:url value="/signUp" />">Sign Up</a></li>
		<li id="admin_li"><a href="<c:url value="/admin" />">Admin</a></li>
	</ul>
		<form class="form-inline navbar-form navbar-right">
            <input type="text" class="form-control " placeholder="Search...">
        </form>
		<form class="form-inline navbar-form navbar-right" action="<c:url value="/logout" />" method="post">
			 <button type="submit" class="btn btn-primary ">Log out</button>
		</form>
        
	<!-- metohd=get -->
	<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
</div>

<input type="hidden" value="${active_li }" id="active_li">

<script>
(function(){
	var id = document.getElementById("active_li").value;
	var active_li = document.getElementById(id);
	active_li.className = "active";
})();
</script>