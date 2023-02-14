package member.dao;

import org.apache.ibatis.session.SqlSession;

import common.mybatis.MyBatisConnectionFactory;
import member.vo.Member;

public class MemberDao {

	private SqlSession sqlSession;

	public MemberDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 멤버 한명 조회
	public Member select(Member member) throws Exception {
		// 데이터처리를 하면 됩니당!
		// Mybatis를 이용해서 Database처리를 할 꺼에요!

		// SqlSession이라는게 있어야 해요! 이걸 가지고 XML에 있는 Query를 실행할 수 있어요!
		// SqlSession은 SqlSessionFactory가 만들어줘요!
		// SqlSessionFactory가 있어야 해요! 이 공장을 만들려면 데이터베이스 연결정보와 같은 XM정보를 줘서 공장을 만들어야 해요!
		// 이 공장을 짓는 코드는 이미 어느정도 정해져 있어요!
		return sqlSession.selectOne("MyMember.login", member);
	}

	// 회원가입
	public int insert(Member member) throws Exception {
		return sqlSession.insert("MyMember.insert", member);
	}

	// 회원정보 수정
	public int update(Member member) throws Exception {
		return sqlSession.update("MyMember.update", member);

	}

}
