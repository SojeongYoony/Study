package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.StaffDAO;

public class StaffDeleteService implements StaffService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String sNo = request.getParameter("sNo");
		
		int result = StaffDAO.getInstance().deleteStaff(sNo);
		
		JSONObject obj = new JSONObject();
		obj.put("result", result > 0);
		
		response.setContentType("application/json; charset=UTF-8");	
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();
		
	}

}
