package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Staff;
import mybatis.config.DBService;

public class StaffDAO {

	private SqlSessionFactory factory;
	private static StaffDAO instance = new StaffDAO();
	private StaffDAO() {
		factory = DBService.getInstance().getFactory();
	}
	
	public static StaffDAO getInstance() {
		return instance;
	}
	
	
	/* select Staff List */
	public List<Staff> selectStaffList() {
		SqlSession ss = factory.openSession();
		List<Staff> list = ss.selectList("dao.staff.selectStaffList");
		ss.close();
		return list;
	}
	
	/* insert Staff */
	public int insertStaff(Staff staff) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.staff.insertStaff", staff);
		if(result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	/* delete Staff */
	public int deleteStaff(String sNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.staff.deleteStaff", sNo);
		if(result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	
	
	/* select one */
	public Staff selectStaffBybNo(String sNo) {
		SqlSession ss = factory.openSession();
		Staff staff = ss.selectOne("dao.staff.selectStaffBybNo", sNo);
		ss.close();
		return staff;
	}
	
	
	
	
}
