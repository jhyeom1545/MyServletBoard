<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member, board.vo.Board, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- JSP에서는 나에게 할당된 session객체를 그냥 사ㅏ용할 수 있어요! 
	 	 어떤 이름을 사용해야 할까요? => session-->
	<h1><%= ((Member)session.getAttribute("member")).getMemberName() %>님 환영합니다.</h1>
	<h3>게시글 목록</h3>
	
	<a href="createBoard"><button>글 작성하기</button></a> <a href="updateMember">회원정보 수정</a>
	<br><br>
	<table border="1">
		<thaed>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자 이름</th>
			<th>작성일</th>
			<th>댓글 개수</th>
			<th>좋아요</th>
		</thaed>
		<tbody>
		<% 
			List<Board> list = ((List<Board>)request.getAttribute("boardList"));
			for(Board board: list){
		%>
		<tr>
			<td><%= board.getBoardNum() %></td>
			<td><a href="boardDescription?boardNum=<%= board.getBoardNum()%>"><%= board.getBoardTitle() %></a></td>
			<td><%= board.getBoardAuthor() %></td>
			<td><%= board.getBoardDate() %></td>
			<td><%= board.getCommentCount() %></td>
			<td><%= board.getBoardLike() %></td>
		</tr>
		<% } %>
		</tbody>
		
	</table>
	
</body>
</html>