package bean;

import java.io.Serializable;


public class Student implements Serializable{
	
	/**
	 * 什么叫bean呢：
	 * 1. 所有属性都为private
	 * 2. 提供默认的构造方法
	 * 3. 提供getter和setter
	 * 4. 实现seriliazable接口，
	 * 5. 使用包装类，因为包装类返回值为null， 基本数据类型返回值为0
	 */
//	
	private static final long serialVersionUID = 1L;
	private Integer sid;
	private String name;
	private String gender;
	private String phone;
	private String birth;
	private String hobby;
	private String info;
	/**
	 * @return the sid
	 */
	
//	构造方法, 有参数但参数中无id
	public Student(String name, String gender, String phone, String birth, String hobby, String info) {
		super();
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.birth = birth;
		this.hobby = hobby;
		this.info = info;
	}
	
//	构造方法，全参数
	
	public Student(Integer sid, String name, String gender, String phone, String birth, String hobby, String info) {
		super();
		this.sid = sid;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.birth = birth;
		this.hobby = hobby;
		this.info = info;
	}
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	


	public Integer getSid() {
		return sid;
	}



	/**
	 * @param sid the sid to set
	 */
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the birth
	 */
	public String getBirth() {
		return birth;
	}
	/**
	 * @param birth the birth to set
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}
	/**
	 * @return the hobby
	 */
	public String getHobby() {
		return hobby;
	}
	/**
	 * @param hobby the hobby to set
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", gender=" + gender + ", phone=" + phone + ", birth=" + birth
				+ ", hobby=" + hobby + ", info=" + info + "]";
	}
	
	
	
	

}
