package service.impl;

import java.sql.SQLException;
import java.util.List;

import bean.PageBean;
import bean.Student;
import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import service.StudentService;

public class StudentServiceImpl implements StudentService {

//	查询所有学生的方法
	@Override
	public List<Student> findAll() throws SQLException {
		// TODO Auto-generated method stub
		StudentDao student = new StudentDaoImpl();
		return student.findAll();
	}
	
//	Fuzzy search 通过性别与姓名模糊查询
	@Override
	public List<Student> fuzzySearch(String search_name, String search_gender) throws SQLException {
		// TODO Auto-generated method stub
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao.fuzzySearch(search_name, search_gender);
	}
	
//	Pagination Display 分页显示。在serviceImpl中将dao中拿到的数据进行包装，返回。
	@Override
	public PageBean<Student> findStudentByPage(int currentPage) throws SQLException {
		// TODO Auto-generated method stub
		PageBean<Student> pageBean = new PageBean<>();
		StudentDao dao = new StudentDaoImpl();
		
//		封装pageBean 对象 setCurrentPage
		pageBean.setCurrentPage(currentPage);

	
//		封装pageBean 对象 setPageLimit
		int pageLimit = StudentDao.PAGE_LIMIT;
		pageBean.setPageLimit(pageLimit);
		
//		封装pageBean 对象 setTotalNumber
		int totalNumber = dao.findTotalNumber();
		pageBean.setTotalNumber(totalNumber);
		
//		封装pageBean 对象 setTotalPage
		int totalPage = totalNumber % pageLimit == 0 ? totalNumber % pageLimit : ((totalNumber % pageLimit) + 1);
		pageBean.setTotalPage(totalPage);
	
//		封装pageBean 对象 setList
		List<Student> list = dao.findStudentByPage(currentPage);
		pageBean.setList(list);
		
		return pageBean;
	}

//	添加单个学生的方法
	@Override
	public void addStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.addStudent(student);
		
	}

//	删除学生的方法
	@Override
	public void deleteStudent(int sid) throws SQLException {
		// TODO Auto-generated method stub
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.deleteStudent(sid);		
	}

//	查询单个学生的方法---通过sid
	
	@Override
	public Student findStudentByID(Integer sid) throws SQLException {
		// TODO Auto-generated method stub
		StudentDao studentDao = new StudentDaoImpl();	
		return studentDao.findStudentByID(sid);
	}

	@Override
	public void updateStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.updateStudent(student);	
	}





}
