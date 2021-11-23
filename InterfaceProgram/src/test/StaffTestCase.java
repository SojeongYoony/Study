package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.StaffDAO;
import dto.Staff;

class StaffTestCase {

//
//    1) 다음과 같은 JUnit 테스트 코드를 작성하고 JUnit 테스트를 실행한 뒤 테스트 결과를 캡처하여 제출하시오.
//    2) 테스트 실행 전에 다음 사원 정보가 STAFF 테이블에 입력되도록 JUnit 테스트 코드를 작성하시오. assertEquals() 메소드를 활용하시오.
//        -사원번호 : 99999
//        -사원명 : 테스트
//        -부서명 : 테스트부서
//    3) 방금 입력된 사원 정보를 가진 사원이 STAFF 테이블에 존재하는지 검색하는 JUnit 테스트 코드를 작성하시오. assertNotNull() 메소드를 활용하시오.

 
	@BeforeEach
	void 사원입력_테스트() {
		Staff staff = new Staff();
		staff.setsNo("99999");
		staff.setName("테스트");
		staff.setDept("테스트부서");
		
		int result = StaffDAO.getInstance().insertStaff(staff);
		assertEquals(1, result, "등록 오류");
		
	}
	
	@AfterEach
	void 사원삭제_테스트() {
		int result = StaffDAO.getInstance().deleteStaff("99999");
		assertEquals(1, result, "삭제 오류");
	}
	
	
	
	@Test
	void 번호로사원조회테스트() {
		System.out.println("사원가져오기_테스트");
		assertNotNull(StaffDAO.getInstance().selectStaffBybNo("99999"));
	}

}
