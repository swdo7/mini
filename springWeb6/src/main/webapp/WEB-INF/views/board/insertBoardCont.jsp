<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
<link href="../resources/css/listform.css" rel="stylesheet" type="text/css">
<script>
//글쓰기폼 확인
function formCheck() {
	var title = document.getElementById('title');
	var content = document.getElementById('content');
	
	if (title.value.length < 5) {
		alert("제목을 입력하세요.");
		title.focus();
		title.select();
		return false;
	}
	if (content.value.length < 5) {
		alert("내용을 입력하세요.");
		title.focus();
		title.select();
		return false;
	}
	return true;
}
</script>
</head>
<body>
<div class="d">
<h1 class="listtitle">[ 글쓰기 ]</h1>
<!-- 파일이 안올라가면 폼태그에 enctype추가했는지 확인 할 것. -->
<form action="saveCont" method="post" enctype="multipart/form-data"  onsubmit="return formCheck();">
 
<table class="t">
   <tr>
      <th></th><th>입력</th>
   </tr>
   <tr>
      <td>작성자 id</td>
      <td>&nbsp;${id}</td>
   </tr>
   <tr>
      <td>제목</td>
      <td>&nbsp;<input type="text" name="title"  id="title"></td>
   </tr>
   <tr>
      <td>내용</td>
      <td>&nbsp;<textarea rows="10" cols= "80" name="content" id="content"></textarea></td>
   </tr>
   <tr>
	<td>파일첨부</td> 
	<td>
		<input type="file" name="upload" size="30">
	</td>
</tr>
</table>
<br>
<p align="center">
   <input type="submit" value="글쓰기">
</p>
</form>
</div>

</body>
</html>