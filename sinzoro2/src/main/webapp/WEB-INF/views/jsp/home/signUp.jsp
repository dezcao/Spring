<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="jumbotron">
    <h1>Sign UP</h1>
    <p>
        You can "google login". <br>
        You can use next sample account (id/password).<br>
        But If you want to sing up. It's possible. Thank you.  
    </p>
    <ul>
        <li>id : aaa</li>
        <li>passsword : 1111</li>
    </ul>
</div>

<c:url var="signUpInsert" value="/signUpInsert" />
<form class="form-horizontal" action="${signUpInsert}" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <div class="form-group">
        <label class="control-label col-sm-2" for="name">Name:</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="name" placeholder="Enter username" name="name">
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="pwd">Password:</label>
        <div class="col-sm-10">          
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
        </div>
    </div>
    
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </div>
</form>
