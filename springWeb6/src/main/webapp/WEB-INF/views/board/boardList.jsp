<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>

<script src="../resources/js/boardList.js"></script>
<link href="../resources/css/listform.css" rel="stylesheet" type="text/css">

</head>
<body>
<div class="d">
<h1 class="listtitle">[ 글 목록 ]</h1>
<table class="t">
	<tr>
		<td class="">
			총${navi.totalRecordsCount}개의 글
		</td>
		<td class="">
			${navi.currentPage}번째 페이지
		</td>
		<td colspan="4"></td>
		<td>
			<input type="button" value="글쓰기" onclick="location.href='newCont';">
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>작성일</th>
		<th>조회수</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	<c:if test="${boardList.size() > 0}">
	<c:forEach var="i" begin="0" end="${boardList.size() -1}">
		<tr>
			<td>${boardList.get(i).getBoardnum()}</td>
			<td>${boardList.get(i).getId()}</td>
			<td>
				<a href="viewCont?number=${boardList.get(i).getBoardnum()}">
				<c:out value="${boardList.get(i).getTitle()}"></c:out>
				</a>
				(${boardList.get(i).getRepcnt()})
			</td>
			<td>${boardList.get(i).getInputdate()}</td>
			<td>${boardList.get(i).getHits()}</td>
			<td>
				<form action="board/deleteCont" method="get">
					<input type="hidden" name="boardnum" value="${boardList.get(i).getBoardnum()}">
					<c:if test="${boardList.get(i).getId() == 'il03219'}">
					<input type="button" value = "삭제하기" onclick= "checkDelete()">
					</c:if>
				</form>
			</td>
			<!-- 수정기능  -->
			<td>
				<form action="board/updateCont" method="get">
					<input type="hidden" name="boardnum" value="${boardList.get(i).getBoardnum()}">
					<c:if test="${boardList.get(i).getId() == 'il03219'}">
					<input type="button" value = "수정하기">
					</c:if>
				</form>
			</td>
	</c:forEach>
	</c:if>
	
	<c:if test= "${boardList.size() == 0}">
		<tr>
		<td colspan = "5" text-align = "center">게시글이 존재하지 않습니다.</td>
		</tr>
	</c:if>
</table>
	<div id="navigator" align = "center">
	<!-- 페이지 이동 부분 -->                      
		<a href="javascript:formSubmit(${navi.currentPage - navi.pagePerGroup})">◁◁ </a> &nbsp;&nbsp;
		<a href="javascript:formSubmit(${navi.currentPage - 1})">◀</a> &nbsp;&nbsp;
		
		<c:forEach var="counter" begin="${navi.startPageGroup}" end="${navi.endPageGroup}"> 
			<c:if test="${counter == navi.currentPage}"></c:if>
				<a href="javascript:formSubmit(${counter})">${counter}</a>&nbsp;
			<c:if test="${counter == navi.currentPage}"></c:if>
		</c:forEach>
		&nbsp;&nbsp;
		<a href="javascript:formSubmit(${navi.currentPage + 1})">▶</a> &nbsp;&nbsp;
		<a href="javascript:formSubmit(${navi.currentPage + navi.pagePerGroup})">▷▷</a>
	
		
		
		
		
		
		
		
		<%-- list?page=${navi.currentPage - navi.pagePerGroup}&searchText=${searchText} --%>
		<%-- list?page=${navi.currentPage - 1}&searchText=${searchText} --%>
				<%-- "list?page=${counter}&searchText=${searchText}" --%>
		<%-- "list?page=${navi.currentPage + 1}&searchText=${searchText}" --%>
		
		<%-- "list?page=${navi.currentPage + navi.pagePerGroup}&searchText=${searchText}" --%>
	<!-- /페이지 이동 끝 -->                      
	
	<br><br>
	
	<!-- 검색폼 -->
	<form id="pagingForm" method="get" action="list">
				<input type="hidden" name="page" id="page" value="1">
		검색 : 	<input type="text"  name="searchText" id="searchText" value="${searchText}">
				<input type="button" onclick="formSubmit(1)" value="검색">
	</form>
	<!-- /검색폼 --> 
	</div>


</div>

</body>
</html>