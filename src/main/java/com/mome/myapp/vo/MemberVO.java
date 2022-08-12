package com.mome.myapp.vo;

public class MemberVO {
	private String username;
	
	private String userpwd;
	private String useremail;
	
	private String usertel;
	
	private String joindate;
	private String nickname;
	@Override
	public String toString() {
		return "MemberVO [username=" + username + ", userpwd=" + userpwd + ", useremail=" + useremail + ", usertel="
				+ usertel + ", joindate=" + joindate + ", nickname=" + nickname + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUsertel() {
		return usertel;
	}
	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	

}
