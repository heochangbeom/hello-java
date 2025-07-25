package cli_bbs;

public class User {
	private String id;
    private String name;
    private String password;
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public User(String id, String name, String password, boolean isAdmin) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	public User(String name2, String pw) {
		// TODO Auto-generated constructor stub
	}
	private boolean isAdmin;

	public String getUserId() {
		// TODO Auto-generated method stub
		return null;
	}
}
