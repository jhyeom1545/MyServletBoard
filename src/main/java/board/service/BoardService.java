package board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;

import board.dao.BoardDao;
import board.vo.Board;
import common.mybatis.MyBatisConnectionFactory;

public class BoardService {

	SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

	/**
	 * 
	 * */
	public List<Board> getAllBoard() {
		// 로직처리해야 해요
		// 데이터베이스 처리만 해서 모든 글에 대한 글 목록을 가져오면되요!
		// DAO가 있어야 해요!
		List<Board> result = null;
		SqlSession sqlSession = factory.openSession();
		BoardDao dao = new BoardDao(sqlSession);
		try {
			result = dao.selectAll();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sqlSession.close();
		}
		return result;
	}

	// 게시글 생성
	public int createBoard(Board board) {
		int result = 0;
		SqlSession sqlSession = factory.openSession();
		BoardDao dao = new BoardDao(sqlSession);
		try {
			result = dao.insert(board);

			if (result == 1) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sqlSession.close();
		}

		return result;
	}

	// 게시글 하나 생성
	public Board getOneBoard(String boardNum) {
		Board result = null;
		SqlSession sqlSession = factory.openSession();
		BoardDao dao = new BoardDao(sqlSession);
		try {
			result = dao.selectOne(boardNum);
			if (result != null) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sqlSession.close();
		}

		return result;
	}

	// 게시글 수정
	public int updateBoard(Board board) {
		int result = 0;
		SqlSession sqlSession = factory.openSession();
		BoardDao dao = new BoardDao(sqlSession);
		try {
			result = dao.update(board);
			if (result == 1) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public int deleteBoard(Board board) {
		int result = 0;
		SqlSession sqlSession = factory.openSession();
		BoardDao dao = new BoardDao(sqlSession);
		try {
			result = dao.delete(board);
			if (result == 1) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

}
