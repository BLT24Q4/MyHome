package himedia.kdt.myhome.controllers;

import java.io.IOException;

import himedia.kdt.myhome.dao.UserDao;
import himedia.kdt.myhome.dao.UserDaoImpl;
import himedia.kdt.myhome.vo.UserVo;
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
		} else if ("joinsuccess".equals(actionName)) {
			RequestDispatcher rd =
				req.getRequestDispatcher("/WEB-INF/views/users/joinsuccess.jsp");
			rd.forward(req, resp);
		} else if ("loginform".equals(actionName)) {
			RequestDispatcher rd =
				req.getRequestDispatcher("/WEB-INF/views/users/loginform.jsp");
			rd.forward(req, resp);
		} else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getParameter("a");
		if ("join".equals(actionName)) {
			//	가입 작업 수행
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String gender = req.getParameter("gender");
			
			UserVo userVo = new UserVo(
					name,
					password,
					email, 
					gender);
			
			UserDao dao = new UserDaoImpl(dbUser, dbPass);
			
			boolean success = dao.insert(userVo);
			
			if (success) {
				resp.sendRedirect(
					req.getContextPath() + "/users?a=joinsuccess" );
			} else {
				resp.getWriter().println("<h1>Error</h1>");
			}	
		}
	}

}
