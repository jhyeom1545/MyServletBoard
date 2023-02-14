<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	font-size: 16px;
	font-family: Consolas, sans-serif;
}
</style>
</head>
<body>
	<h1>새로운 글 작성하기</h1>
	<form action="createBoard" method="POST">
		작성자 이름:
		<div><%=((Member) session.getAttribute("member")).getMemberName()%><br></div>
		<br> 글제목: <input type="text" name="boardTitle"><br>
		<br> 내용<br>
		<textarea cols="50" rows="10" name="boardContent">
		</textarea>
		<br>
		<button type="submit">작성하기</button>
	</form>
</body>
</html>