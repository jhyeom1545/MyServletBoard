package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;

public class BoardDao {

	private SqlSession sqlSession;

	public BoardDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 모든 게시글 조회
	public List<Board> selectAll() throws Exception {
		return sqlSession.selectList("MyBoard.allBoards");
	}

	// 게시글 생성
	public int insert(Board board) throws Exception {
		return sqlSession.insert("MyBoard.insert", board);
	}

	// 게시글 1개 조회
	public Board selectOne(String boardNum) throws Exception {
		return sqlSession.selectOne("MyBoard.selectOne", boardNum);
	}

	// 게시글 수정
	public int update(Board board) throws Exception {
		System.out.println("boardDao 찍어보기" + board);
		return sqlSession.update("MyBoard.update", board);
	}

	// 게시글 삭제
	public int delete(Board board) throws Exception {
		return sqlSession.delete("MyBoard.delete", board);
	}
}
