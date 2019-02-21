<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 검색하기</title>
</head>
<body>
<h1>[ 글 검색 ]</h1>
<form action="board/selectOne" method="post">
검색할 ID	<input type="text" name="id">
		<input type="submit" value="검색">
</form>
</body>
</html>