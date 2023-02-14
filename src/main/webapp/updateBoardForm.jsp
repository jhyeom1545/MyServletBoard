<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.vo.Board" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시글 수정 페이지</h1>
<form action="updateBoard?boardNum=<%= ((Board)request.getAttribute("board")).getBoardNum() %>" method="POST">
<input type="hidden" value="<%= ((Board)request.getAttribute("board")).getBoardNum() %>" name="boardNum">
제목: <input type="text" name="boardTitle" value="<%= ((Board)request.getAttribute("board")).getBoardTitle() %>" style="width:300px"><br>
내용: <input type="text" name="boardContent" value="<%= ((Board)request.getAttribute("board")).getBoardContent() %>" style="height:100px; width:300px"><br>
<button type="submit">수정하기</button>
</form>
</body>
</html>