package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Member;
import mybatis.config.DBService;

public class MemberDao {

	private SqlSessionFactory factory;
	
	/* singleton */
	private static MemberDao instance;
	private MemberDao() {
		/* factory */
		factory = DBService.getInstance().getFactory();
	}
	public static MemberDao getInstance() {
		if(instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	
	// select all members list
	public List<Member> memberList(){
		SqlSession ss = factory.openSession();
		List<Member> list = ss.selectList("dao.member.memberList");
		ss.close();
		return list;
	}
	
	// insert member
	public int insertMember(Member member) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.member.insertMember", member);
		if(result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	// delete member
	public int deleteMember(String no) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.member.deleteMember", no);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	// for checking duplicate
	public int selectOneMember(String no) {
		SqlSession ss = factory.openSession();
		int selectResult = ss.selectOne("dao.member.selectOneMember", no);
		ss.close();
//	    System.out.println(selectResult); //-- select 결과 확인용
		return selectResult;
	}
	
}
