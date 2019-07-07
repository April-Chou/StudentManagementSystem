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
 * Servlet implementation class StudentServlet
 */
public class StudentListServlet extends HttpServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1673605152642243284L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentService service = new StudentServiceImpl();
		try {
			List<Student> list = service.findAll();
//			不清楚为什么，tostring方法在控制台并没有被打印
			for (Student student : list) {
				System.out.println(student.toString());
			}
//			下面将list加入到session中，让session把数据带到list.jsp页面中去显示
			request.getSession().setAttribute("student_list", list);
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
