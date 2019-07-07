package dao.impl;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import bean.Student;
import dao.StudentDao;
import util.JDBCUtil;
import util.StringUtils;

public class StudentDaoImpl implements StudentDao {

//  查询所有学生的方法。 search all student
	@Override
	public List<Student> findAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Student> list = null;
//		直接扔个datasourc就可以连到数据库里了
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from stu";
		list = runner.query(sql, new BeanListHandler<Student>(Student.class));
		
		return list;
	}

//	添加学生的方法。Add student method
	@Override
	public void addStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
	

		int update_status = runner.update("insert into stu values(null, ?, ?, ?, ?, ?, ? )", student.getName(), student.getGender(), student.getPhone(), student.getBirth(), student.getHobby(), student.getInfo());
		if(update_status > 0) {
			System.out.println("Add the student Successfully");
		}else {
			System.out.println("Add the student failed!");
		}
		
	}
	
//	pagination search. 根据给定的页数，分页查询出学生类
	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		// TODO Auto-generated method stub
//		先连接数据库
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from stu limit ? offset ?";
//		在接口中定义limit的值，直接类名.调用 offset = limit * (currentPage-1)
		List<Student> list = runner.query(sql, new BeanListHandler<Student>(Student.class), StudentDao.PAGE_LIMIT, StudentDao.PAGE_LIMIT * (currentPage -1));
		return list;
	}

//	查询所要数据的整体个数 total number account
	@Override
	public int findTotalNumber() throws SQLException {
		// TODO Auto-generated method stub
//		先连接数据库
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
//		long类型貌似不能强制转换为int
        Long result = (Long) runner.query("select count(*) from stu", new ScalarHandler());
		int totalNumber = result.intValue();
//		int totalNumber = Integer.parseInt(result.toString());
		return totalNumber;
	}

	
//	删除单个学生的方法。 Delete selected student method
	@Override
	public void deleteStudent(int sid) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
//		删除方法
		int update_status = runner.update("delete from stu where sid = ?", sid);
		if(update_status > 0) {
			System.out.println("Delete the student Successfully!");
		}else {
			System.out.println("Delete the student failed!");
		}
		
	}

//	查询单个学生的方法
	@Override
	public Student findStudentByID(Integer sid) throws SQLException {
		// TODO Auto-generated method stub
		
//		先连数据库，做查询
//		int int_id = sid.intValue();
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		Student student = runner.query("select * from stu where sid = ?", new BeanHandler<Student>(Student.class), sid);
		
		return student;
	}

//	update method。 更新学生的方法
	@Override
	public void updateStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
//		先连接数据库
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		int update_status = runner.update("update stu set name=?, gender=?, phone=?, birth=?, hobby=?, info=? where sid=?", 
				student.getName(), student.getGender(),student.getPhone(), student.getBirth(), student.getHobby(), student.getInfo()
				, student.getSid());
		if(update_status > 0) {
			System.out.println("Update Successfully! :)");
		}else {
			System.out.println("Update Failed :(");
		}
		
		
		
	}

//	fuzzy search method。 模糊查询
	@Override
	public List<Student> fuzzySearch(String search_name, String search_gender) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("The search name is " + search_name + "; the search gender is " + search_gender);
		
//		拿list收参数，因为可变，后边转为array
		List<String> list = new ArrayList<>();
		
//		还是先连接数据库。
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
//		因为是fuzzy search，所以说应该有4种情况
//		1. 有search_name 无 search_gender的查询
//			应该是 select * from stu where name like %search_name%
//		2. 无search_name 有search_gender的查询
//		3. 既有search_name 也有search_gender的查询
//		4. 既无search_name 也无search_gender的查询
		
//		where 1=1代表永真 的条件， 动态sql中的and连接条件
		String sql = "select * from stu where 1=1";
		
//		条件语句去判断四个条件
//		trick. 判断string要 非空""且不为null。所以我们写一个工具类去判断
////		下面判断条件1
//		if( !StringUtils.isEmpty(search_name) && StringUtils.isEmpty(search_gender)) {
//			sql = sql + " and name like ?";
//			list.add("%" + search_name + "%");
//		}
////		判断条件2
//		else if(StringUtils.isEmpty(search_name) && !StringUtils.isEmpty(search_gender)) {
//			sql = sql + " and gender =?";
//			list.add(search_gender);
//		}
////		判断条件3
//		else if(!StringUtils.isEmpty(search_name) && !StringUtils.isEmpty(search_gender)) {
//			sql = sql + " and name like ? and gender = ?";
//			list.add("%" + search_name +"%");
//			list.add(search_gender);
//		}
////		判断条件4
//		else if(StringUtils.isEmpty(search_name) && StringUtils.isEmpty(search_gender)) {
//			
//		}
		
//		这个if语句更好，更少，效率更高，不需要写四个判断条件
		if(!StringUtils.isEmpty(search_name)) {
			sql = sql + " and name like ?";
			list.add("%" + search_name + "%");
			System.out.println(sql);
		}
		if(!StringUtils.isEmpty(search_gender)) {
			sql = sql + " and gender = ?";
			list.add(search_gender);
			System.out.println(sql);
		}
		System.out.println(sql);
		List<Student> student = runner.query(sql, new BeanListHandler<Student>(Student.class), list.toArray());
		
		return student;
	}




}
