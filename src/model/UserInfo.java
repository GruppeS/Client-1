package model;

public class UserInfo implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private String overallID = "logIn";
	private String email;
	private String password;

	//Getters and setters for everything
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public String getAuthUserEmail() {
		return email;
	}
	public void setAuthUserEmail(String email) {
		this.email = email;
	}
	public String getAuthUserPassword() {
		return password;
	}
	public void setAuthUserPassword(String password) {
		this.password = password;
	}

}