package himedia.kdt.myhome.controllers;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class UserServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getParameter("a");
		
		if ("joinform".equals(actionName)) {
			//	가입 폼 보여주기
			RequestDispatcher rd =
				req.getRequestDispatcher("/WEB-INF/views/users/joinform.jsp");
			rd.forward(req, resp);
		}
	}

}
