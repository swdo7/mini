<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가입하기</title>
<link href="resources/css/kkyjoinform.css" rel="stylesheet" type="text/css">
<script src="resources/js/joinScript.js">
</script>

</head>
<body>
<div class="d">
<h1 class="jointitle">[ 회원 가입 ]</h1>
<form action="join" method="post" onsubmit="return check()">
 
<table class="t">
   <tr>
      <th>정보</th><th>입력</th>
   </tr>
   <tr>
      <td>ID</td>
      <td>&nbsp;<input type="text" name="custid" id="custid" 
      					readonly="readonly" placeholder="ID중복확인을 이용하세요">
         &nbsp;<input type="button" value="[ID중복검사]" onclick="idCheckOpen()">
      </td>
   </tr>
   <tr>
      <td>비밀번호</td>
      <td>&nbsp;<input type="password" name="password" id="pw1"></td>
   </tr>
   <tr>
      <td>비밀번호 확인</td>
      <td>&nbsp;<input type="password" id="pw2">
         <!-- &nbsp;<input type="button" value="[비밀번호 확인]" onclick="return pwCheck()"> -->
      </td>
   </tr>
   <tr>
      <td>이름</td>
      <td>&nbsp;<input type="text" name="name"></td>
   </tr>
   <tr>
      <td>E-mail</td>
      <td>
         &nbsp;<input type="text" name="email">&nbsp;@
         <input type="text" name="email2">
         <select name="emailname">
            <option value="1">naver.com</option>
            <option value="2">daum.net</option>
         </select>
      </td>
   </tr>
   <tr>
      <td>고객구분</td>
      <td>
      	&nbsp;<input type="radio" name="division" value="personal" checked >개인회원
      	&nbsp;<input type="radio" name="division" value="company">기업회원
      </td>
   </tr>
   <tr>
      <td>식별번호</td>
      <td>&nbsp;<input type="tel" name="idno" size= "35" placeholder="개인 : 주민번호, 기업 : 사업자번호"></td>
   </tr>
   <tr>
      <td>주소</td>
      <td>&nbsp;<input type="text" name="address">
      </td>
   </tr>
</table>
<br>
<p align="center"><input type="submit" value="가입"></p>
</form>
</div>

</body>
</html>