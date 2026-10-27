
public class User {
	String username, password, email;

	public User(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + "]";
	}
	
}
