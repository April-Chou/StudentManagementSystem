package util;





import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil {
	

// 静态变量和静态代码块的执行顺序是由编写的先后顺序决定的
//	本例中用静态变量和静态代码块是为了创建一个连接池而不是多个
//    java静态对象到底有什么好处？
//
//A，静态对象的数据在全局是唯一的，一改都改。如果你想要处理的东西是整个程序中唯一的，弄成静态是个好方法。 非静态的东西你修改以后只是修改了他自己的数据，但是不会影响其他同类对象的数据。 
//B，引用方便。直接用 类名.静态方法名  或者  类名.静态变量名就可引用并且直接可以修改其属性值，不用get和set方法。
//C，保持数据的唯一性。此数据全局都是唯一的，修改他的任何一处地方，在程序所有使用到的地方都将会体现到这些数据的修改。有效减少多余的浪费。
//

	static ComboPooledDataSource dataSource = null;
	
	static {
		dataSource = new ComboPooledDataSource();
	}
	
//	返回datasource
	public static DataSource getDataSource() {
		return dataSource;
		
	}

	

	public static Connection getConn() {
//		get connection
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return connection;
	}
	
	
	
//	release method
	public static void release(ResultSet rs, Statement st, Connection conn) {
		closeResultSet(rs);
		closeStatement(st);
		closeConncetion(conn);
	}
	
//	overload the release method
	public static void release(Statement st, Connection conn) {
		closeStatement(st);
		closeConncetion(conn);
	}
	
//	overload the release method using the preparedstatement
	public static void release(ResultSet rs, PreparedStatement ps, Connection conn) {
		closeResultSet(rs);
		closePreparedStatement(ps);
		closeConncetion(conn);
	}
	
//	overload the release method using two parameters, one of them is the preparedstatement
	public static void release(PreparedStatement ps, Connection conn) {
		closePreparedStatement(ps);
		closeConncetion(conn);
	}
	
//	close the ResulSet
	private static void closeResultSet(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			rs = null;
		}
	}
	
//	close the statement
	private static void closeStatement(Statement st) {
		try {
			if(st != null) {
				st.close();
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			st = null;
		}
	}
	
//	close PreparedStatement
	private static void closePreparedStatement(PreparedStatement ps) {
		try {
			if(ps != null) {
				ps.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ps = null;
		}
	}
	
//	close the connection
	private static void closeConncetion(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	
		finally {
			conn = null;
		}
	}
}
