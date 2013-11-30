/**
 * 
 */
package servlet;

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
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher red = null;

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String m = (String) request.getParameter("m");
		System.out.println(m);
		response.getWriter().println("Hello");

		// JSP‚Ö
		red = request.getRequestDispatcher("\\WEB-INF\\hoge.jsp");
		red.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
