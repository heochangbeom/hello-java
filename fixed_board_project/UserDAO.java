import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public User login(String userName, String userPass) {
        Connection conn = DBUtil.getConnect();
        String sql = "SELECT * FROM users WHERE user_name = ? AND user_pass = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName.trim());
            pstmt.setString(2, userPass.trim());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getString("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserPass(rs.getString("user_pass"));
                user.setIsAdmin(rs.getString("is_admin"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean register(User user) {
        Connection conn = DBUtil.getConnect();
        String sql = "INSERT INTO users (user_id, user_name, user_pass, is_admin) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUserName());
            pstmt.setString(3, user.getUserPass());
            pstmt.setString(4, user.getIsAdmin());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}