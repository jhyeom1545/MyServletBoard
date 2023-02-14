<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="comment.vo.Comment, board.vo.Board" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>댓글 수정 페이지</h1>
<form action="updateComment?commentNum=<%=((Comment)request.getAttribute("comment")).getCommentNum() %>" method="POST">
<input type="hidden" value="<%= ((String)request.getAttribute("boardNum")) %>" name="boardNum">
댓글 내용: <input type="text" name="commentContent" value="<%= ((Comment)request.getAttribute("comment")).getCommentContent() %>">
<button type="submit">수정</button>
</form>
</body>
</html>