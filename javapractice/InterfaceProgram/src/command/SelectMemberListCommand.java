package command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.MemberDAO;
import dto.Member;

public class SelectMemberListCommand implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		List<Member> list = MemberDAO.getInstance().selectAllMember();
		
		JSONArray members = new JSONArray();
		for (Member member : list) {
			JSONObject obj = new JSONObject();
			obj.put("no", member.getNo());
			obj.put("name", member.getName());
			obj.put("age", member.getAge());
			obj.put("birthday", member.getBirthday());
			obj.put("regDate", member.getRegDate());
			members.put(obj);
		}

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(members);
		out.close();
	}

}
