package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.JSONObject;

import dao.StaffDAO;
import dto.Staff;

public class StaffInsertService implements StaffService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		try {
			
				
				String sNo = request.getParameter("sNo");
				String name = request.getParameter("name");
				String dept = request.getParameter("dept");
				
				Staff staff = new Staff();
				staff.setsNo(sNo);
				staff.setName(name);
				staff.setDept(dept);
						
				int result = StaffDAO.getInstance().insertStaff(staff);
				
				JSONObject obj = new JSONObject();
				obj.put("result", result > 0);
				
				response.setContentType("application/json; charset=UTF-8");	
				PrintWriter out = response.getWriter();
				out.println(obj);
				out.close();
		
		} catch (PersistenceException e) {
			 // 선생님 피드백, 수정 : 반환은 text/plain이다 !!!!! 복붙하더라도 확인좀 꼼꼼히 하자!
				response.setContentType("text/plain; charset=UTF-8");	
			 // PrintWriter out = response.getWriter();
	 		 // out.println("저장할 수 없는 값이 전달되었습니다.");
				
		// 선생님 답안의 참고 코드
				response.getWriter().println("저장할 수 없는 값이 전달되었습니다.");
				response.setStatus(1001);
			
		}
	}

}
