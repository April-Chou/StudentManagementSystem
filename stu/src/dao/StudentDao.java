package dao;

import java.sql.SQLException;
import java.util.List;

import bean.Student;

public interface StudentDao {
	
//	接口中定义的成员变量全部都是public static final类型。可以简写
//	要把变量名都大写，因为定义常量
	public static final int PAGE_LIMIT = 5;
	
//	查询所有学生的方法
	List<Student> findAll() throws SQLException;
	
//	查询数据总共个数 search the totoal number of data
	int findTotalNumber() throws SQLException;
	
//	fuzzy search method。模糊查询方法
	List<Student> fuzzySearch(String search_name, String search_gender) throws SQLException;
	
//	查询单个学生的方法
	Student findStudentByID(Integer sid) throws SQLException;
	
//	pagination search student 分页查询学生
	List<Student> findStudentByPage(int currentPage) throws SQLException;
	
//	添加学生到数据库的方法
	void addStudent(Student student) throws SQLException;
	
//	删除学生的方法
	void deleteStudent(int sid) throws SQLException;
	
//	更新学生的方法
	void updateStudent(Student student) throws SQLException;

}
