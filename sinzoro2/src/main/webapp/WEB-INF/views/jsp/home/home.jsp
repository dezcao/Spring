<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>Spring4.0 Sample</h1>
			<p>	
				https://github.com/dezcao/Spring.git
			</p>
				<ul>
					<li>Java 1.8</li>
					<li>MariaDB, H2DB</li>
					<li>Tomcat 8.5</li>
				</ul>
				
		    <img src="${sessionScope.imageUrl }">
		    <br>${sessionScope.displayName }
		    
		</div>

		<div class="embed-responsive embed-responsive-16by9">
		  <iframe class="embed-responsive-item"
		    src="https://www.youtube.com/embed/mX9L8IuiwJA" frameborder="0" allowfullscreen></iframe>
		</div>
		
        <script>
        /* 
            (function() {
				//window.location.replace("/home#");
           	})();
             */
        </script>
