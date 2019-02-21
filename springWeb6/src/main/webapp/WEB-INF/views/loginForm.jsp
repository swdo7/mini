<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginForm</title>
<script src="resources/js/loginScript.js"></script>
<script>
	<c:if test="${requestScope.msg != null}"> 
		alert('${msg}');
	</c:if>
</script>

</head>
<body>
<h1>[ 로그인 화면입니다 ]</h1>
<form name="" id="login" action="login" method="post" onsubmit="return check()">
아이디:	<input type = "text" name = "id" id = "id"><br>
비밀번호:	<input type = "password" name = "password" id="password"><br>
			<input type="submit" value="Login">
</form>

</body>
</html>