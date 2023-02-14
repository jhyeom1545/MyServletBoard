package member.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import common.mybatis.MyBatisConnectionFactory;
import member.dao.MemberDao;
import member.vo.Member;

public class MemberService {

	SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

	// 멤버 로그인
	public Member login(Member member) {
		// 로그인이라는 Transaction(작업) 처리를 진행해요!
		// 하지만... 로그인이라는 작업은 별다른 로직처리할게 없어요!
		// Database처리가 사실 전부에요!
		// Database처리를 여기서 하나요? 당연히 아니에요! => DAO에서 해요!
		SqlSession sqlSession = factory.openSession();
		Member result = null;
		MemberDao dao = new MemberDao(sqlSession);
		try {
			result = dao.select(member);
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	// 멤버 회원가입
	public int signUp(Member member) {
		SqlSession sqlSession = factory.openSession();
		MemberDao dao = new MemberDao(sqlSession);
		int result = 0;
		try {
			result = dao.insert(member);
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

	// 멤버 정보 수정
	public int updateMember(Member member) {
		SqlSession sqlSession = factory.openSession();
		MemberDao dao = new MemberDao(sqlSession);
		int result = 0;
		try {
			result = dao.update(member);
			if(result ==1) {
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
