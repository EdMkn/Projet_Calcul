package beans;

public class User {
	private boolean admin;

	public User(boolean admin) {
		this.admin = admin;
		}
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
