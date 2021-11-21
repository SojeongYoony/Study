package command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberService {

	public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException;
	// throws IOException only : input, output exception 
}
