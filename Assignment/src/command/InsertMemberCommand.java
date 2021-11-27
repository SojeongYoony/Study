package command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.JSONObject;

import dao.MemberDao;
import dto.Member;

public class InsertMemberCommand implements MemberService {

	public class AgeRangeException extends Exception {
		public AgeRangeException(String message) {
			super(message);
		};
	} // "나이는 0~100사이만 가능 합니다"
	
	public class DuplicateException extends Exception {
		public DuplicateException (String message) {
			super(message);
		};
	} // 중복 체크 exception
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		try {
			
		// no
		String no = request.getParameter("no");
		int selectResult = MemberDao.getInstance().selectOneMember(no);	
		if (selectResult > 0) throw new DuplicateException("동일한 회원 번호는 입력할 수 없습니다.");
		
		// name
		String name = request.getParameter("name");
		if (name.isEmpty()) throw new NullPointerException("회원명을 입력하세요.");
		
		// age
		String strAge = request.getParameter("age");
		if (strAge.isEmpty()) throw new NullPointerException("나이를 입력하세요.");
		int age = Integer.parseInt(strAge);
		if (age < 0 || age > 100) throw new AgeRangeException("나이는 0~100 사이만 입력 가능합니다.");
		
		// birthday
		String birthday = request.getParameter("birthday");
		if (birthday.isEmpty()) throw new NullPointerException("생일을 입력하세요.");
		
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
		
		} catch (NumberFormatException e) {
			response.setContentType("text/plain; charset=UTF-8");
			response.getWriter().println("나이는 정수만 입력 가능합니다.");
			response.setStatus(2001);	

		} catch (AgeRangeException e) {
			response.setContentType("text/plain; charset=UTF-8"); 
			response.getWriter().println(e.getMessage());
			response.setStatus(2002);	
	
		} catch (DuplicateException e) {
			response.setContentType("text/plain; charset=UTF-8"); 
			response.getWriter().println(e.getMessage());	
			response.setStatus(2003);	
			
		} catch (NullPointerException e) {
			response.setContentType("text/plain; charset=UTF-8");
			response.getWriter().println(e.getMessage());
			response.setStatus(2004);
					
		} catch (PersistenceException e) { 
         // Mybatis에서 DB오류나면 발생  : 동일한 데이터를 넘겨도 발생하고, column값에 맞지 않아도 발생함. => DuplicateException 만듦
			response.setContentType("text/plain; charset=UTF-8"); 		
			response.getWriter().println("입력 데이터를 확인하세요.");						
//			e.printStackTrace(); // 예외 콘솔 확인용
			response.setStatus(2005);	
			
		}
		
		
	}

}