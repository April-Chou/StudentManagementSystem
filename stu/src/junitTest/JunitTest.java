package junitTest;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import bean.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

public class JunitTest {
	
	@Test
	public void testStudentServiceImpl() {
		StudentService service = new StudentServiceImpl();
		try {
			List<Student> list = service.findAll();
			for (Student student : list) {
				System.out.println(student.toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	测试添加方法
	@Test
	public void testAddStudentImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date_raw = "1991-04-08";
		try {
			Date date = sdf.parse(date_raw);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		service.addStudent(null);
	}
	
//	addStudent JUNIT 测试2
	@Test
	public void testAddImpl02() {
		
//		String name = request.getParameter("name");
//		String gender = request.getParameter("gender");
//		String phone = request.getParameter("phone");
//		String birth_raw = request.getParameter("birth");
//		String hobby = request.getParameter("hobby");
//		String info = request.getParameter("info");
//		
////		change date type 
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//		
//		Date birth = dateFormat.parse(birth_raw);
//		Student student = new Student(name, gender, phone, birth, hobby, info);
//		StudentService service = new StudentServiceImpl();
//		service.addStudent(student);
//		
	}

}
