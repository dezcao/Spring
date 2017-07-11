<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- 
<link href="<c:url value="/resources/smarteditor2/css/ko_KR/*.css" />" rel="stylesheet" type="text/css">
 --%>
<script type="text/javascript" src="<c:url value="/resources/smarteditor2/js/service/HuskyEZCreator.js" />" charset="utf-8"></script>
<style>
.table .text {
	position: relative;
}

.table .text span {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
	position: absolute;
	left: 0;
	right: 0;
}

.text:before {
	content: '';
	display: inline-block;
}
</style>
<div class="jumbotron">
    <h1>Board</h1>
</div>
<!-- issue list table -->
<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading">Panel heading</div>
    <div class="panel-body">
        <h4>순서 조절 게시판</h4>
        <p>글작성하고 싶은곳을 클릭하고 저장하면 해당 위치(글 순서)로 작성 됩니다.</p>
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
            <tr>
                <th scope="row">1</th>
                <td class="text"><span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum lorem sem, pretium non vestibulum ut, pretium ac mauris. Etiam consectetur dolor
                        vehicula ligula semper, eget suscipit quam fringilla.<span></span></td>
                <td>Otto</td>
                <td>@mdo</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
            </tr>
        </tbody>
    </table>
</div>
<!-- pagenation -->
<div class="page-header">
    <nav>
        <ul class="pagination ">
            <li class="disabled"><a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a></li>
            <li class="active"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a></li>
        </ul>
    </nav>
</div>
<div class="page-header">
    <h4>- Naver smarteditor Version: 2.9.0.4a256db 적용.</h4>
    <textarea name="ir1" id="ir1" class="form-control" style='width: 100%; min-width: 260px; height: 30em; display: none;'></textarea>
</div>
<script>
	var oEditors = [];
	nhn.husky.EZCreator
			.createInIFrame({
				oAppRef : oEditors,
				elPlaceHolder : "ir1",
				sSkinURI : "${pageContext.request.contextPath}/resources/smarteditor2/SmartEditor2Skin.html",
				fCreator : "createSEditor2"
			});
</script>
