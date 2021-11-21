package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Member;
import mybatis.config.DBService;

public class MemberDAO {

	private SqlSessionFactory factory;
	private static MemberDAO instance = new MemberDAO();
	private MemberDAO() {
		factory = DBService.getInstance().getFactory();
	}
	public static MemberDAO getInstance() {
		return instance;
	}
	
	/* select all member list */
	public List<Member> selectAllMember() {		// select all == list : dto list 
		SqlSession ss = factory.openSession();
		List<Member> list = ss.selectList("dao.member.selectAllMember");
		ss.close();
		return list;
	}
	
	/* insert member */
	public int insertMember(Member member) {	// insert 1 : dto 1 
		SqlSession ss = factory.openSession(false); // prevent auto commit
		int result = ss.insert("dao.member.insertMember", member);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	/* delete member */
	public int deleteMember(String no) {
		SqlSession ss = factory.openSession(false); // prevent auto commit
		int result = ss.delete("dao.member.deleteMember", no);
		if (result > 0) ss.commit();
		ss.close();
		return result;	
	}
}
