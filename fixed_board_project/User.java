public class User {
    private String userId;
    private String userName;
    private String userPass;
    private String isAdmin;

    public User() {}

    public User(String userId, String userName, String userPass, String isAdmin) {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
        this.isAdmin = isAdmin;
    }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getUserPass() { return userPass; }
    public void setUserPass(String userPass) { this.userPass = userPass; }

    public String getIsAdmin() { return isAdmin; }
    public void setIsAdmin(String isAdmin) { this.isAdmin = isAdmin; }
}