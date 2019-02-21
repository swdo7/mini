<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>id 중복확인</title>
<script src="resources/js/idCheck.js"></script>
<script>
function selectedId(){
	var id = opener.document.getElementById('custid');
	id.value = '${searchId}';
	this.close();
}
</script>
</head>
<body>
<h1>[ 중복확인 ]</h1>
<form action="idCheck" method="post" onsubmit="return formCheck()">
검색할 id <input type="text" name="searchId" id="searchId" value="${searchId}">
		<input type="submit" value="검색">
</form>
<br>
<c:if test="${search}">
	<c:if test="${searchResult == null}">
		<p>사용할 수 있는 ID입니다.</p>
		<p><a href="javascript:selectedId()">사용하기</a></p>
	</c:if>	
	<c:if test="${searchResult != null}">
		<p>이미 사용중인 ID입니다.</p>
	</c:if>
</c:if>
	
</body>
</html>