package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.StaffDAO;
import dto.Staff;

public class StaffListService implements StaffService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		List<Staff> list = StaffDAO.getInstance().selectStaffList();
		
		JSONArray staffs = new JSONArray();
		for (Staff staff : list) {
			JSONObject obj = new JSONObject();
			obj.put("sNo", staff.getsNo());
			obj.put("name", staff.getName());
			obj.put("dept", staff.getDept());
			obj.put("regDate", staff.getRegDate());
			staffs.put(obj);
		}
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(staffs);
		out.close();
	}

}
