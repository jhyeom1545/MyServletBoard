<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.vo.Board, comment.vo.Comment, java.util.List, member.vo.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<!-- <script
      src="https://code.jquery.com/jquery-3.6.3.min.js"
      integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
      crossorigin="anonymous"
    ></script> -->
<script src="./boardDescription.js"></script>
<title>Insert title here</title>
<% 
	int boardNum = ((Board)request.getAttribute("board")).getBoardNum();
	String boardAuthor = ((Board)request.getAttribute("board")).getBoardAuthor();
	String boardTitle = ((Board)request.getAttribute("board")).getBoardTitle();
    String boardDate = ((Board)request.getAttribute("board")).getBoardDate();
    String boardContent = ((Board)request.getAttribute("board")).getBoardContent();
    int boardLike = ((Board)request.getAttribute("board")).getBoardLike();
    String memberId = ((Member)session.getAttribute("member")).getMemberId();
%>
</head>
<body>
<a href="login">이전페이지로 가기</a>
<h1>제목: <%= boardTitle %></h1>
<h3>작성자: <%= boardAuthor %> 님</h3>
<%
	if(memberId.equals(boardAuthor)){
%> 
<a href="updateBoard?boardNum=<%= boardNum %>">게시글 수정</a>
<a href="deleteBoard?boardNum=<%= boardNum %>" >게시글 삭제</a>
<%
	}
%>
날짜: <%= boardDate %><br>
내용:<%= boardContent %><br>
좋아요: <%= boardLike %><br>
<button id="likeButton">좋아요 누르기</button>

<!-- 댓글 영역 -->
<h3>댓글</h3>
<table border="1">
  <thead>
    <tr>
      <th>댓글 내용</th>
      <th>작성자 이름</th>
      <th>작성일</th>
      <th>댓글 수정</th>
      <th>댓글 삭제</th>
    </tr>
  </thead>
  <tbody>
    <% 
    List<Comment> listComment = ((List<Comment>)request.getAttribute("comment"));
    if(listComment != null && !listComment.isEmpty()){  
    for(Comment comment : listComment) {
    %>
    <tr>
      <td><%= comment.getCommentContent() %></td>
      <td><%= comment.getCommentAuthor() %></td>
      <td><%= comment.getCommentDate() %></td>
      <% if(comment.getCommentAuthor().equals(memberId)) { %>
      <td><a href="updateComment?commentNum=<%= comment.getCommentNum() %>&boardNum=<%= boardNum %>">수정</a></td>
      <td><a href="deleteComment?commentNum=<%= comment.getCommentNum() %>&boardNum=<%= boardNum %>">삭제</a></td>
      <% } else { %>
      <td></td>
      <td></td>
      <% } %>
    </tr>
    <% } 
    } else { %>
      <tr>
        <td colspan="5">작성된 댓글이 없습니다.</td>
      </tr>
    <% } %>
  </tbody>
</table>
<br><br>
<form action="createComment?boardNum=<%= boardNum %>" method="post">
  <textarea style="width:300pt; height:80pt" name="commentContent"></textarea>
  <button type="submit" style="height:80pt">작성하기</button>
</form>