package com.xiao.blog.myblog.entity;

public class User {

	private String uid;
	 /**
     * 手机号
     */
    private String phone;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private String sex;
    
    private int role_id;

    /**
     * 真实姓名
     */
    private String trueName;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 个人简介
     */
    private String profile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 最后登录时间
     */
    private String lastLogintime;

    /**
     * 头像地址
     */
    private String headImgUrl;
    
    public User() {};
    
    public User(String phone, String username, String password, String sex) {
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.sex = sex;
    }

	public User(String phone, String username, String password, String sex, String trueName, String birthday,
			String profile, String email, String lastLogintime, String headImgUrl) {
		super();
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.trueName = trueName;
		this.birthday = birthday;
		this.profile = profile;
		this.email = email;
		this.lastLogintime = lastLogintime;
		this.headImgUrl = headImgUrl;
	}

	

	
	

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastLogintime() {
		return lastLogintime;
	}

	public void setLastLogintime(String lastLogintime) {
		this.lastLogintime = lastLogintime;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	
	

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", phone=" + phone + ", username=" + username + ", password=" + password + ", sex="
				+ sex + ", trueName=" + trueName + ", birthday=" + birthday + ", profile=" + profile + ", email="
				+ email + ", lastLogintime=" + lastLogintime + ", headImgUrl=" + headImgUrl + "]";
	}

	
    
}
