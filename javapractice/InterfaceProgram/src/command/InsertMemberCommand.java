package command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.MemberDAO;
import dto.Member;

public class InsertMemberCommand implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String strAge = request.getParameter("age");
		int age = Integer.parseInt(strAge);
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
		out.print("DB오류 발생");
		
		response.setStatus(1111);
		
	}

}
