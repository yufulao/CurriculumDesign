package pojo;

public class User {
	private Integer id;
	private String userName;
	private String userPassword;
	private Integer userSid;
	private String userEmail;
	private Integer userTel;
	private String userIdentityCard;
	private String userIntroduction;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String password) {
		this.userPassword = password;
	}

	public Integer getUserSid() {
		return userSid;
	}

	public void setUserSid(Integer userSid) {
		this.userSid = userSid;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Integer getUserTel() {
		return userTel;
	}

	public void setUserTel(Integer userTel) {
		this.userTel = userTel;
	}

	public String getUserIdentityCard() {
		return userIdentityCard;
	}

	public void setUserIdentityCard(String userIdentityCard) {
		this.userIdentityCard = userIdentityCard;
	}

	public String getUserIntroduction() {
		return userIntroduction;
	}

	public void setUserIntroduction(String userIntroduction) {
		this.userIntroduction = userIntroduction;
	}
}
