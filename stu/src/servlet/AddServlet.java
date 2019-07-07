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
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	
		try {
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String birth_raw = request.getParameter("birth");
//			拿到字符串数组hobbies
			String[] hobbies = request.getParameterValues("hobby");
			String info = request.getParameter("info");
//			打印字符串date
			System.out.println("Raw date is " + birth_raw);
//			用Arrays.toString将数组转化为字符串，用subString切割字符串.
//			String hobby = Arrays.toString(hobbies).substring(1, hobbies.length);
//			上面那行代码错了，会打印出少了很多，因为hobbies是数组，数组的长度取决于你勾选了几个
			String hobby_inter = Arrays.toString(hobbies);
			String hobby = hobby_inter.substring(1, hobby_inter.length()-1);
			
//			change date type 
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			
			
//			String birth = dateFormat.parse(birth_raw);
//			打印newdate
			
			System.out.println("New Date is " + birth_raw);
			Student student = new Student(name, gender, phone, birth_raw, hobby, info);
			StudentService service = new StudentServiceImpl();
			service.addStudent(student);
//			该跳转了
			response.sendRedirect("StudentListServlet");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
//		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
