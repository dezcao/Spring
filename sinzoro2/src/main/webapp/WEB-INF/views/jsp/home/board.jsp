<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
/* http://craziers.com/%EB%A7%90%EC%A4%84%EC%9E%84-ellipsis-css/ */
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
            <div class="row">
                <div class="col-md-8">
                    <p>
                              자바지기 님께 답메일을 받았다. 보낸메일을 삭제하려고 했는데 이미 답메일이 도착해 있었다. 으앜~
                        <br>진로, security, social 구현 등 어려움을 토로했더니, 몇가지 사이트를 알려주셨다. 친절한 분이다.
                        <br>spring-boot 프로젝트로된 사이트라서 spring-legacy 프로젝트에서 진행하려던 학습 계획을 잠시 중단했다. 
                    </p>
                    <p>
                              현재는, spring-boot로 프로젝트를 다시 시작할지 node.js나 python으로 해볼지 고민중이다. 
                        <br>Java도 갈길이 먼데 한눈을 파는것 같아서, 마음이 불안하다.
                    </p>
                </div>
                <div class="col-md-4">
                    <figure class="figure">
                        <img src="https://upload.wikimedia.org/wikipedia/en/c/ca/Interstellar_soundtrack_album_cover.jpg" 
                            class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption">Interstellar OST 코딩하면서 계속 듣는다.</figcaption>
                    </figure>
                </div>
            </div>
        </div>
    </div>
    
    <table class="table table-hover">
        <thead>
            <tr>
                <th class="col-xs-1">#</th>
                <th class="col-xs-7 text-overflow">content</th>
                <th class="col-xs-2">writer</th>
                <th class="col-xs-2">date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${BoardList}" var="boardVO" varStatus="status">
                <tr>
                    <th scope="row">${status.count}</th>
                    <td class="text" onclick="findOne('${boardVO.id}')">
                        <div class="p_text">
                            <input type="hidden" id="content_${boardVO.id }" value="${boardVO.board_content}">
                            <script>
                            	document.write(document.getElementById( "content_" + ${ boardVO.id } ).value);
                    		</script>
                        </div>
                    </td>
                    <td>${boardVO.writer}</td>
                    <td><fmt:formatDate value="${boardVO.insDate}" type="date" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<form action="<c:url value='/home/boardContent'/>" method="post">
    <button type="submit" class="btn btn-default" id="writeButton">글쓰기</button>
</form>

<div class="paging text-center">
	<nav aria-label="...">
	  <ul class="pagination" >
	    <li class="${PageVO.beginPage == 1 ? 'disabled' : '' }"><a href="<c:url value='/home/board?requirePage=${PageVO.beginPage == 1 ? PageVO.requirePage : PageVO.beginPage - PageVO.perPage}'/>" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
	        <c:forEach begin="${PageVO.beginPage }" end = "${PageVO.endPage }" varStatus="status">
	            <li class='${PageVO.requirePage==status.index?"active":""}' ><a href="<c:url value='/home/board?requirePage=${status.index}'/>"> ${status.index} <span class="sr-only"> </span></a></li>
	        </c:forEach>
	    <li class="${PageVO.endPage == PageVO.totalPage ? 'disabled' : '' }"><a href="<c:url value='/home/board?requirePage=${PageVO.endPage < PageVO.totalPage ? PageVO.endPage + 1 : PageVO.requirePage}'/>" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
	  </ul>
	</nav>
</div>

<form id="findForm" action="<c:url value="/home/findOneBoard" />" method="post" style="display: none;">
    <input type="number" id="find_id" name="id">
</form>

<script>
	function findOne(id) {
		document.getElementById("find_id").value = id;
		$("#findForm").submit();
	}
</script>
