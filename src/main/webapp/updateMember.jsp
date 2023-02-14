<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원정보 수정</h1>
<h1><%= ((Member)session.getAttribute("member")).getMemberName() %>님 환영합니다.</h1>
아이디: <%= ((Member)session.getAttribute("member")).getMemberId() %>
<form action="updateMember" method="POST">
이름: <input type="text" value="<%= ((Member)session.getAttribute("member")).getMemberName() %>" name="memberName"> 
<br>
비밀번호: <input type="password" name="memberPw1"><br>
비밀번호 확인: <input type="password" name="memberPw2"><br><br>
<button type="submit">수정하기</button>
</form>
</body>
</html>