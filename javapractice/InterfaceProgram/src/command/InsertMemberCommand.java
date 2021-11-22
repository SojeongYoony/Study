package command;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.MemberDAO;
import dto.Member;

public class InsertMemberCommand implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		try {
			
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String birthday = request.getParameter("birthday");
		
		
		Member member = new Member();
		member.setNo(no);
		member.setName(name);
		member.setAge(age);
		member.setBirthday(birthday);
		
		int result = MemberDAO.getInstance().insertMember(member);
		
		JSONObject obj = new JSONObject();
		obj.put("result", result > 0);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();
		
		// 예외코드 정리
		// 2001 : 동일한 게시글번호 재등록, 필수 칼럼 누락
		// 2002 : 잘못된 데이터 전달
		// 2003 : 알 수 없는 에러	   ex) number format / null pointer ...etc.. exceptions
		
		} catch (SQLIntegrityConstraintViolationException e) {
			response.setContentType("text/plain; charset=UTF-8"); 
			PrintWriter out = response.getWriter();	
			out.println("동일한 게시글번호가 있거나 필수 정보가 누락되었습니다.");		
			response.setStatus(2001);	// 에러 코드 2001 발생 
			
		} catch(SQLException e) {
			response.setContentType("text/plain; charset=UTF-8"); 
			PrintWriter out = response.getWriter();	
			out.println("잘못된 데이터가 전달되었습니다.");		
			response.setStatus(2002);	// 에러 코드 2002발생
			
		} catch (Exception e) {
			response.setContentType("text/plain; charset=UTF-8"); 
			PrintWriter out = response.getWriter();	
			out.println("알 수 없는 예외가 발생했습니다.");		
			response.setStatus(2003);	// 에러 코드 2003발생
		}
		
	}

}