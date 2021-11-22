package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.DeleteMemberCommand;
import command.InsertMemberCommand;
import command.MemberService;
import command.SelectMemberListCommand;

@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");	 
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);
		
		MemberService service = null;
		
		switch(command) {
		// select members
		case "selectMemberList.do" :
			service = new SelectMemberListCommand();
			break;
		// insert member
		case "insertMember.do" :
			service = new InsertMemberCommand();
			break;
		// delete member
		case "deleteMember.do" :
			service = new DeleteMemberCommand();
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