package 허창범;

public class Member {
    private String userId;
    private String userName;
    private String userPass;
    private boolean isAdmin;

    public Member() {}

    public Member(String userId, String userName, String userPass, boolean isAdmin) {
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

    public boolean isAdmin() { return isAdmin; }
    public void setAdmin(boolean admin) { isAdmin = admin; }
}