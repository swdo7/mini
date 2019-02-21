<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>정보수정 (결과창)</title>
<link href="resources/css/kkyjoinform.css" rel="stylesheet" type="text/css">
<script src="resources/js/updateScript.js">
</script>

</head>
<body>
<div class="d">
<h1 class="jointitle">[ 정보 수정 ]</h1>
<form action="update" method="post" onsubmit="return formCheck()">
 
<table class="t">
   <tr>
      <th>정보</th><th>입력</th>
   </tr>
   <tr>
      <td>ID</td>
      <td>&nbsp;${logCustomer.custid}
   </tr>
   <tr>
      <td>비밀번호</td>
      <td>&nbsp;<input type="password" name="password" id="pw1"></td>
   </tr>
   <tr>
      <td>비밀번호 확인</td>
      <td>&nbsp;<input type="password" id="pw2">
      </td>
   </tr>
   <tr>
      <td>이름</td>
      <td>&nbsp;<input type="text" name="name" value="${logCustomer.name}"></td>
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
      <c:if test="${logCustomer.division == 'personal'}">
      	개인
      </c:if>
      <c:if test="${logCustomer.division == 'company'}">
      	기업
      </c:if>
      </td>
   </tr>
   <tr>
      <td>식별번호</td>
      <td>&nbsp;<input type="tel" name="idno" size= "35" value="${logCustomer.idno}"></td>
   </tr>
   <tr>
      <td>주소</td>
      <td>&nbsp;<input type="text" name="address" value="${logCustomer.address}">
      </td>
   </tr>
</table>
<br>
<p align="center"><input type="submit" value="가입"></p>
</form>
</div>

</body>

</html>