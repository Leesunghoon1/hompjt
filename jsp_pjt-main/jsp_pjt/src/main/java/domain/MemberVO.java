package domain;

public class MemberVO {
	private String id;
	private String pwd;
	private String email;
	int pnum;
	int age;
	private String regdate;
	private String last_login;
	
	public MemberVO() {
	}

	
	
	public MemberVO(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}

	//join, modify

	public MemberVO(String id, String pwd, String email, int pnum, int age) {
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.pnum = pnum;
		this.age = age;
	}

	
	public MemberVO(String id, String pwd, String email, int pnum, int age, String regdate, String lastlogin) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.pnum = pnum;
		this.age = age;
		this.regdate = regdate;
		this.last_login = lastlogin;
	}
	
	

	public int getPnum() {
		return pnum;
	}



	public void setPnum(int pnum) {
		this.pnum = pnum;
	}



	public String getLast_login() {
		return last_login;
	}



	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getLastlogin() {
		return last_login;
	}

	public void setLastlogin(String lastlogin) {
		this.last_login = lastlogin;
	}



	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", email=" + email + ", pnum=" + pnum + ", age=" + age
				+ ", regdate=" + regdate + ", last_login=" + last_login + "]";
	}


	
	
	
}
