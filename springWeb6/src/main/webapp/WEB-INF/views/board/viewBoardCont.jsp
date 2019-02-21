<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세보기</title>
<link href="../resources/css/listform.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="d">
<h1 class="listtitle"><pre><xmp>[ ${selectedVO.getTitle()} ]</xmp></pre></h1>
 
<table class="t">
   <tr>
      <th></th><th>입력</th>
   </tr>
   <tr>
      <td>작성자 id</td>
      <td>&nbsp;<pre><c:out value="${selectedVO.getId()}"/></pre></td>
   </tr>
   <tr>
      <td>제목</td>
      <td>&nbsp;<pre><xmp>${selectedVO.getTitle()}</xmp></pre></td>
   </tr>
   <tr>
      <td>내용</td>
      <td>&nbsp;<pre><xmp>${selectedVO.getContent()}</xmp></pre></td>
   </tr>
   
</table>
<br>
<!-- 리플 출력 -->
<table class="t">
   <tr>
	<c:if test="${replyList.size() > 0}">
   	<c:forEach var="i" begin="0" end="${replyList.size() -1}">
   	<tr>
      <td>&nbsp;${replyList.get(i).getId()}</td>
      <td>&nbsp;<pre><xmp>${replyList.get(i).getText()}</xmp></pre></td>
      <td>&nbsp;${replyList.get(i).getInputdate()}</td>
      <tr>
	</c:forEach>
	</c:if>
	<c:if test="${replyList.size() == 0}">
	<tr>
		<td colspan = "3" text-align = "center">댓글을 작성해 주세요.</td>
	<tr>
	</c:if>
   </tr>
 
</table>

<br>
<!-- 리플 작성 폼 시작 -->
<div align= "center">
<c:if test="${sessionScope.id != null}">
<form id="replyForm" action="insertReply" method="post">
리플내용
	<input type="hidden" name="boardnum" value="${selectedVO.boardnum}"/>
	<input type="text" name = "text" id="retext" style="width:500px;"/>
	<input type="submit" value="확인"/>
</form>
</c:if>
<br>

</div>
	<p align= "center"><a href="<c:url value="/"/>">홈으로</a></p>
	<p align= "center"><a href="<c:url value="/board/list"/>">목록보기</a></p>
	<c:if test="${sessionScope.id == null}">
	<p align= "center"><a href="<c:url value="/"/>">글 수정</a></p>
	</c:if>
<br>
</div>

</body>
</html>