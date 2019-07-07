package service;

import java.sql.SQLException;
import java.util.List;

import bean.PageBean;
import bean.Student;

public interface StudentService {
	
//	Service里查询所有学生的方法
	List<Student> findAll() throws SQLException;
	
//	fuzzy search method。模糊查询方法
	List<Student> fuzzySearch(String search_name, String search_gender) throws SQLException;
	
//	分页查询业务。一个dao实现一个事情，事务是将所有dao实现的东西汇总
//  searchbypage实现了查询到当页的学生，但没有查询到总共的数据个数，因此还要写一个dao去实现查询总共个数
//	service 汇总两个查询到的数据，返回出去。
//	建一个pageBean去接收五个对象，把这些要拿的数据封装成一个对象返回到前端
	PageBean<Student> findStudentByPage(int currentPage) throws SQLException;
	
//	Service里添加学生的方法
	void addStudent(Student student) throws SQLException;
	
//	service里删除学生的方法
	void deleteStudent(int sid) throws SQLException;
	
//	查询单个学生的方法
	Student findStudentByID(Integer sid) throws SQLException;
	
//	更新学生的方法
	void updateStudent(Student student) throws SQLException;

}
