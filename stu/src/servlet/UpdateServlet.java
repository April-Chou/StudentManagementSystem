package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer sid = Integer.parseInt(request.getParameter("sid"));
		
//		打印一下sid id
		System.out.println("The ID of selected student who needs to update is " + sid);
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String birth = request.getParameter("birth");
//		接收hobby数组类型
		String[] hobbyValues = request.getParameterValues("hobby");
//		将数组转为字符串
		String hobby_inter = Arrays.toString(hobbyValues);
		String hobby = hobby_inter.substring(1,hobby_inter.length()-1);
		String info = request.getParameter("info");
		
//		new一个student类把上面数据封装起来
		Student student = new Student(sid,name,gender,phone,birth,hobby, info);
//		此处应该调用一个方法把new出来的student传到数据库。 
		StudentService service = new StudentServiceImpl();
		try {
			service.updateStudent(student);
			response.sendRedirect("StudentListServlet");
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
