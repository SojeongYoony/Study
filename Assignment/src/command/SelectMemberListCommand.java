package command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import dao.MemberDao;
import dto.Member;

public class SelectMemberListCommand implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		List<Member> list = MemberDao.getInstance().memberList();
		JSONArray members = new JSONArray(list);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(members);
		out.close();
		
	}

}
