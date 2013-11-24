/**
 * 
 */
package hoge;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ˆè–í
 * 
 */
@WebServlet(name = "mysrv", urlPatterns = "/mysrv")
public class MyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher red = null;
		resp.setContentType("text/html;charset=UTF-8");

		req.setCharacterEncoding("UTF-8");

		String m = (String) req.getParameter("m");
		System.out.println(m);
		resp.getWriter().println("Hello");

		// JSP‚Ö
		red = req.getRequestDispatcher("\\WEB-INF\\hoge.jsp");
		red.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
