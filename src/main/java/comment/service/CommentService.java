package comment.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import comment.dao.CommentDao;
import comment.vo.Comment;
import common.mybatis.MyBatisConnectionFactory;

public class CommentService {

	SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

	// 댓글 생성
	public int createComment(Comment comment) {
		int result = 0;
		SqlSession sqlSession = factory.openSession();
		CommentDao dao = new CommentDao(sqlSession);
		try {
			result = dao.insert(comment);
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

	// 모든 댓글 조회
	public List<Comment> getAllComments(String boardNum) {
		List<Comment> result = null;
		SqlSession sqlSession = factory.openSession();
		CommentDao dao = new CommentDao(sqlSession);
		try {
			result = dao.selectAll(boardNum);
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

	public int updateComment(Comment comment) {
		int result = 0;
		SqlSession sqlSession = factory.openSession();
		CommentDao dao = new CommentDao(sqlSession);
		try {
			result = dao.update(comment);
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

	public Comment getOneComment(String commentNum) {
		Comment result = null;
		SqlSession sqlSession = factory.openSession();
		CommentDao dao = new CommentDao(sqlSession);
		try {
			result = dao.selectOne(commentNum);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sqlSession.close();
		}
		return result;
	}

	public int deleteComment(Comment comment) {
		int result = 0;
		SqlSession sqlSession = factory.openSession();
		CommentDao dao = new CommentDao(sqlSession);
		try {
			result = dao.delete(comment);
			if(result==1) {
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

}
