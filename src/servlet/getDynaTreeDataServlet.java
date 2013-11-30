package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import bean.DynaTreeData;

/**
 * Servlet implementation class getEmployeeJson
 */
@WebServlet(name = "getDynaTreeData", urlPatterns = "/getDynaTreeData")
public class getDynaTreeDataServlet extends HttpServlet {
	private static final long serialVersionUID = 5L;

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
		// TODO: dynaTreeを格納できるBeanを用意する.
		// http://d.hatena.ne.jp/momijiame/20120125/1327503353

		// TODO:安全なJSONの使い方を調べる　webセキュリティの小部屋.
		response.setContentType("application/json; charset=UTF-8");
		response.setHeader("Cache-Control", "private");
		request.setCharacterEncoding("UTF-8");

		ObjectMapper mapper = new ObjectMapper();

		/**
		 * How to use Jackson to deserialise an array of objects.
		 * http://stackoverflow.com/questions/6349421/how-to-use-jackson-to-deserialise-an-array-of-objects
		 */
		// final String json =
		// "[{\"title\" : \"Sub-item 3.1.1\",\"key\" : \"id3.1.1\",\"select\" : true,\"children\" : [ {\"title\" : \"Sub-item 4.1.1\",\"key\" : \"id4.1.1\"}]}]";
		// final String json =
		// "[{\"title\" : \"item1 with key and tooltip\", \"tooltip\" : \"Look, a tool tip!\"}, {\"title\" : \"item2: selected on init\",\"select\" : true}]";
		final String json = "[{\"title\" : \"Sub-item 3.1.1\",\"key\" : \"id3.1.1\",\"select\" : true,\"children\" : [ {\"title\" : \"Sub-item 4.1.1\",\"key\" : \"id4.1.1\"}]},{\"title\" : \"item1 with key and tooltip\", \"tooltip\" : \"Look, a tool tip!\"}, {\"title\" : \"item2: selected on init\",\"select\" : true}]";
		System.out.println(json);
		List<DynaTreeData> jsonList = mapper.readValue(json,
				new TypeReference<List<DynaTreeData>>() {
				});
		// DynaTreeData[] jsonList = mapper.readValue(json,
		// DynaTreeData[].class);

		response.getOutputStream().write(mapper.writeValueAsBytes(jsonList));

	}
}
