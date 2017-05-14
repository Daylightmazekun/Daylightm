package com.nukezam.model;

public class UserAdd {
	
	private String school_num;
	private String name;
	private String grade;
	private String school;
	private String major;
	private String email;
	private String password;
	private String role;
	private String sex;
	private String qq;
	private String phone;
	private String adress;
	
	public UserAdd(){}
	
    public UserAdd(String school_num, String name, String grade, String school, String major, String email, String password, String role, String sex, String qq, String phone, String adress) {
        this.school_num = school_num;
        this.name = name;
        this.grade = grade;
        this.school = school;
        this.major = major;
        this.email = email;
        this.password = password;
        this.role = role;
        this.sex = sex;
        this.qq = qq;
        this.phone = phone;
        this.adress = adress;
    }

	public String getSchool_num() {
		return school_num;
	}

	public String getName() {
		return name;
	}

	public String getGrade() {
		return grade;
	}

	public String getSchool() {
		return school;
	}

	public String getMajor() {
		return major;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public String getSex() {
		return sex;
	}

	public String getQq() {
		return qq;
	}

	public String getPhone() {
		return phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setSchool_num(String school_num) {
		this.school_num = school_num;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

}
