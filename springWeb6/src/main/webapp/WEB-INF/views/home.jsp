<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
<head>
	<title>Home</title>
	<script type="text/javascript">
	function logout(){
			alert('로그아웃하고 홈으로 돌아갑니다.');
	}
	</script>
</head>
<body>
<h1>[ 희연이의 게시판 (회원관리기능, 댓글기능 포함)]</h1>

<!-- 쿠키를 이용한 방문 횟수 카운트 -->
<p>${cnt}번째 방문입니다. </p>
<P>
	<c:if test="${sessionScope.id != null}">
	<b>${sessionScope.id}님 로그인 중 입니다.</b>
	</c:if>
 </P>



//로그인상태에 따라서 표시 바꾸기
<c:if test="${sessionScope.id == null}">
<p><a href="join">회원가입</a></p>
<p><a href="login">로그인</a></p>
</c:if>
<p><a href="board/list">게시판</a></p>
<c:if test="${sessionScope.id != null}">
<p><a href="logout" onclick= "logout()">로그아웃</a></p>
<p><a href="updateForm">정보수정</a></p>
</c:if>

<!-- <p><a href="list">모든 회원정보 보기</a></p>
<p><a href="view">1명의 회원 정보 검색</a></p> -->
</body>
</html>
