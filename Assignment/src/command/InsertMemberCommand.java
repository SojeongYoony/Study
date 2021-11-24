package command;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.MemberDao;
import dto.Member;

public class InsertMemberCommand implements MemberService {

	public class AgeException extends Exception {
		public AgeException(String message) {
			super(message);
		};
	} // "나이는 0~100사이만 가능 합니다"
	
	public class AgeTypeException extends Exception{
		public AgeTypeException(String message) {
			super(message);
		}
	} // "나이는 정수만 입력 가능합니다"
	
	public class SameDataException extends Exception {
		public SameDataException(String message) {
			super(message);
		}
	} // "동일한 회원번호는 입력할 수 없습니다"
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		try {
			
		// parameter
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String strAge = request.getParameter("age");
		int age = Integer.parseInt(strAge);
		String birthday = request.getParameter("birthday");
		
		if (age < 0 || age > 100) {
			throw new AgeException("나이는 0~100사이만 가능 합니다.");
		}
		
				
		Member member = new Member();
		member.setNo(no);
		member.setName(name);
		member.setAge(age);
		member.setBirthday(birthday);
		
		int result = MemberDao.getInstance().insertMember(member);
		
		JSONObject obj = new JSONObject();
		obj.put("result", result > 0);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();
		
		} catch (AgeException e) {
			response.setContentType("text/plain; charset=UTF-8"); 
			PrintWriter out = response.getWriter();	
			out.println(e.getMessage());		
			response.setStatus(2001);	// 에러 코드 2002발생
			
//		} catch (AgeTypeException e){	
//			response.setContentType("text/plain; charset=UTF-8"); 
//			PrintWriter out = response.getWriter();	
//			out.println(e.getMessage());		
//			response.setStatus(2002);	// 에러 코드 2002발생
//			
//		} catch (SameDataException e) {
//			response.setContentType("text/plain; charset=UTF-8"); 
//			PrintWriter out = response.getWriter();	
//			out.println(e.getMessage());		
//			response.setStatus(2003);	// 에러 코드 2003발생
			
		} catch (Exception e) {
			
		}
	}

}
