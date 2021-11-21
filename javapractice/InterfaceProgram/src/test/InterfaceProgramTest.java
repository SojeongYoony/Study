package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.MemberDAO;
import dto.Member;

class InterfaceProgramTest {

	@BeforeEach
	void 맴버삽입() {
		Member member = new Member();
		member.setNo("040825");
		member.setName("민재홍");
		member.setAge(8);
		member.setBirthday("040825");
		
		int result = MemberDAO.getInstance().insertMember(member);
		assertEquals(1, result, "등록오류");
	}
	
	@AfterEach
	void 맴버삭제() {
		int result = MemberDAO.getInstance().deleteMember("040825");
		assertEquals(1, result, "삭제오류");
	}
	
	@Test
	void 게시글_리스트가져오기() {
		System.out.println("게시글 목록 가져오기 테스트");
		assertEquals(2, MemberDAO.getInstance().selectAllMember().size());
	}

}
