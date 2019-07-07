package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

/**
 * The fuzzy search form will be submitted to this Servlet
 * Servlet implementation class SearchStudentServlet
 */
public class SearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search_name = request.getParameter("sname");
		String search_gender = request.getParameter("sgender");
		
//		打印查询是否拿到
		System.out.println("In servelet Search name is " + search_name + ", Search gender is " + search_gender);
		
//		调用serviceImpl去查询
		StudentService service = new StudentServiceImpl();
		try {
			List<Student> student = service.fuzzySearch(search_name, search_gender);
//			此处setAttribute名字得是student_list才行，因为一会儿跳转是list.jsp页面
			request.getSession().setAttribute("student_list", student);
			response.sendRedirect("list.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
