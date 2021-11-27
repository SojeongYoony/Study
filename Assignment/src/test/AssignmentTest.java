package test;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.MemberDao;
import dto.Member;

class AssignmentTest {
	

	@Test
	void 목록가져오기() {
		
		List<Member> list =  MemberDao.getInstance().memberList();
		System.out.println(list);
		
		int selectResult = MemberDao.getInstance().selectOneMember("851106");
		System.out.println(selectResult);
	}

}
