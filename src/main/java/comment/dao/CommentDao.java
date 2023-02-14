package comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import comment.vo.Comment;

public class CommentDao {

	private SqlSession sqlSession;

	public CommentDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 댓글 생성
	public int insert(Comment comment) throws Exception {
		return sqlSession.insert("MyComment.insert", comment);
	}

	// 모든 댓글 조회
	public List<Comment> selectAll(String boardNum) throws Exception {
		return sqlSession.selectList("MyComment.selectAll", boardNum);
	}

	// 댓글 하나 조회
	public Comment selectOne(String commentNum) throws Exception {
		return sqlSession.selectOne("MyComment.selectOne",commentNum);
	}
	
	// 댓글 수정
	public int update(Comment comment) throws Exception {
		return sqlSession.update("MyComment.update", comment);
	}

	// 댓글 삭제 
	public int delete(Comment comment) throws Exception {
		return sqlSession.delete("MyComment.delete", comment);
	}

}
