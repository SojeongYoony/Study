package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StaffDeleteService;
import service.StaffInsertService;
import service.StaffListService;
import service.StaffService;

@WebServlet("*.do")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StaffController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");	 
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);
		
		StaffService service = null;
		
		switch(command) {
		/*  select All Staffs list */
		case "selectStaffList.do" :
			service = new StaffListService();
			break;
		/*  insert Staff Service   */
		case "insertStaff.do" :
			service = new StaffInsertService();
			break;
			
		case "deleteStaff.do" :
			service = new StaffDeleteService();
			break;
		}

		/* 실행 코드 */
		if (service != null) {
			service.execute(request, response);  
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
