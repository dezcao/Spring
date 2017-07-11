<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="<c:url value="/resources/smarteditor2/css/ko_KR/*.css" />" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<c:url value="/resources/smarteditor2/js/service/HuskyEZCreator.js" />" charset="utf-8"></script>

<div class="jumbotron">
    <h1>Board</h1>
</div>
<div class="page-header">
    <h1>순서 조절 게시판</h1>
    <h4>- Naver smarteditor Version: 2.9.0.4a256db 적용.</h4>
    <textarea name="ir1" id="ir1" class="form-control" style='width:100%; min-width:260px; height:30em; display:none;'></textarea>
</div>
<div class="row"></div>

<script>
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors,
		elPlaceHolder : "ir1",
		sSkinURI : "${pageContext.request.contextPath}/resources/smarteditor2/SmartEditor2Skin.html",
		fCreator : "createSEditor2"
	});
</script>
