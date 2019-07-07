package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			Integer sid = Integer.valueOf(request.getParameter("sid"));
			System.out.println("The selected id is " + sid);
			StudentService service = new StudentServiceImpl();
			Student student = service.findStudentByID(sid);
			System.out.println("************Below is selected Student************");
			System.out.println( student);
//			拿到学生对象
//			request.setAttribute("student", student);
//			把学生对象转到jsp中
//			重定向拿不到本次request的数据，因为重定向是两个请求，两个响应
//			response.sendRedirect("edit.jsp");
//			采用请求转发传送数据
//			request.getRequestDispatcher("edit.jsp").forward(request, response);
//			可以用getsession装数据
			request.getSession().setAttribute("student", student);
			response.sendRedirect("edit.jsp");
			
			
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
