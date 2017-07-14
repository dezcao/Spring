<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <link href="<c:url value="/resources/smarteditor2/css/ko_KR/smart_editor2.css" />" rel="stylesheet" type="text/css"> --%>
<script type="text/javascript" src="<c:url value="/resources/smarteditor2/js/service/HuskyEZCreator.js" />" charset="utf-8"></script>
<style>
.p_text {
    display: -webkit-box;
    display: -ms-flexbox;
    display: box;
    margin-top:1px;
    max-height:60px;
    overflow:hidden;
    vertical-align:top;
    text-overflow: ellipsis;
    word-break:break-all;
    -webkit-box-orient:vertical;
    -webkit-line-clamp:3
}
/* http://craziers.com/%EB%A7%90%EC%A4%84%EC%9E%84-ellipsis-css/ */
</style>
<div class="jumbotron">
    <h1>Board</h1>
</div>
<!-- issue list table -->
<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading">일반 게시판</div>
    <div class="panel-body">
        <div class="clearfix">
            <img src="https://c1.staticflickr.com/4/3207/2726134661_12e3494fe5_b.jpg" alt="gaver" class="pull-right col-sm-4 col-md-4 img-responsive">
            <p>
                Naver smarteditor2를 사용했다. 쓰레기다... 
                <br> bootstrap과 css 충돌이 일어나고, 반응형 동작을 위해 스타일을 추가했으나 하단의 조절레버 부분이 사라지는 현상이 있다. 
                <br> F5를 눌러 갱신하면 다시 나오는데 완전히 해결해보려고 오랜 시간을 썼지만 화만 났다.
            </p>
            <p>
                <b> 더 좋은 해결책은, 그냥 이걸 안쓰는 거다.</b> <br> 모바일에 적합한 smarteditor3를 내놓았단다. <b>안쓸거다.</b> 
                <br> smarteditor가 처음 개발된 시점이 좀 되었기 때문에 css가 반응형이지 못하다고? 
                <br> bootstrap은 그때도 있지 않았나? 그때도 반응형은 일반적이지 않았냐는 물음이다. 
                <br> 앞으로 네이버가 제공하는 API는 로그인을 제외하고는 모두 후순위로 생각할 것이다. 
                <br> spring-boot 프로젝트를 진행할 때는, summernote를 사용해 봐야겠다. 
                <br> "자비지기님은 말씀하셨지, 코드는 계속 가꾸어 가는 거라고" - 맥가이버. 
                <br> 네이버는 자기가 만든 코드를 버렸다. 그리고 새로운 것을 선보였다. <b>크아아악~~~</b>
            </p>
        </div>
    </div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th class="col-xs-1">#</th>
                <th class="col-xs-7 text-overflow">content</th>
                <th class="col-xs-2">info</th>
                <th class="col-xs-2">control</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${boardList}" var="boardVO" varStatus="status">
                <tr>
                    <th scope="row">${status.count}</th>
                    <td class="text" onclick="findOne('${boardVO.id}')">
                        <div class="p_text">
                            <input type="hidden" id="content_${boardVO.id }" value="${boardVO.board_content}">
                            <script>
                            	document.write(document.getElementById("content_"+${boardVO.id}).value);
                    		</script>
                        </div>
                    </td>
                    <td><fmt:formatDate value="${boardVO.insDate}" type="date" />, ${boardVO.writer}</td>
                    <td>a heng heng</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<div class="page-header">
    <h4>- Naver smarteditor Version: 2.9.0.4a256db 적용.</h4>
    <form class="form-inline" action="<c:url value="/home/insBoard" />" method="post" id="insBoardForm">
        <textarea name="board_content" id="board_content" class="form-control" style='width: 100%; min-width: 150px; height: 30em; display: none;'>
            ${getBoardVO.board_content}
        </textarea>
        <div class="form-group">
            <label for="InputName1">Writer</label> <input type="text" class="form-control" id="InputName1" placeholder="Jane Doe" name="writer">
        </div>
        <div class="form-group">
            <label for="InputPassword1">Password</label> <input type="password" class="form-control" id="InputPassword1" name="password">
        </div>
        <button type="button" class="btn btn-default" id="savebutton">Save</button>
        <button type="button" class="btn btn-default" id="deletebutton" onclick="deleteOne('${getBoardVO.id}')">Delete</button>
    </form>
</div>

<form id="findForm" action="<c:url value="/home/findOne" />" method="post" style="display: none;">
    <input type="number" id="find_id" name="id">
</form>

<form id="deleteForm" action="<c:url value="/home/delete" />" method="post" style="display: none;">
    <input type="number" id="delete_id" name="id">
</form>


<script>
	var oEditors = [];
	nhn.husky.EZCreator
			.createInIFrame({
				oAppRef : oEditors,
				elPlaceHolder : "board_content",
				sSkinURI : "${pageContext.request.contextPath}/resources/smarteditor2/SmartEditor2Skin.html",
				fCreator : "createSEditor2"
			});
	
	$("#savebutton").click(function() {
		oEditors.getById["board_content"].exec("UPDATE_CONTENTS_FIELD", []);
		$("#insBoardForm").submit();
	});
	
	function deleteOne(id) {
		document.getElementById("delete_id").value = id;
		$("#deleteForm").submit();
	}

	function findOne(id) {
		document.getElementById("find_id").value = id;
		$("#findForm").submit();
	}
</script>
