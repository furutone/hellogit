package hoge;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Servlet implementation class getEmployeeJson
 */
@WebServlet(name = "getEmpJson", urlPatterns = "/getEmpJson")
public class getEmployeeJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 4L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		// response.setHeader("Cache-Control", "private");
		request.setCharacterEncoding("UTF-8");

		ObjectMapper mapper = new ObjectMapper();

		// JSON(オブジェクト)
		String json = "{\"a\":1,\"b\":2}";
		// Jackson 生成。
		Map<String, Integer> foobar = mapper.readValue(json, Map.class);
		System.out.println("result1.toString() : " + foobar.toString());

		// response.getOutputStream().write(result.toString().getBytes("UTF-8"));
		response.getOutputStream().write(json.getBytes("UTF-8"));
	}

}
