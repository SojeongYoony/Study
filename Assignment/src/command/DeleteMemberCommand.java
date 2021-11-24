package command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.MemberDao;

public class DeleteMemberCommand implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String no = request.getParameter("no");
		int result = MemberDao.getInstance().deleteMember(no);
		
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();
		
	}

}
