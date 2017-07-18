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
                Naver smarteditor2를 사용했다. 
                <br> bootstrap과 css 충돌이 일어나고, 반응형 동작을 위해 스타일을 추가했으나 이상 현상이 있다.
                <br> 현재는 글 지우기 밸리데이션과 페이지 같은건 없고, 그냥 읽고 쓰고 지운다.
            </p>
            <p>
                    자바지기(박재성)님에게 메일을 받고 legacy프로젝트에서 진행하려던 개발 계획을 중단했다.
                <br>spring-boot프로젝트로 심화 학습을 하며 결제모듈이나 다른 기능들을 붙여볼지 
                <br>node.js나 파이썬으로 새 프로젝트를 해볼지 고민중이다. 
                <br>불안하다, Java도 모르는데 다른데 눈돌리는게 맞는건지... 
                
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
