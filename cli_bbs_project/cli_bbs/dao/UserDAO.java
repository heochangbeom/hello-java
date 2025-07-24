
package cli_bbs.dao;

import cli_bbs.model.User;
import cli_bbs.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public boolean register(User user) {
        String sql = "INSERT INTO users (user_name, user_pass, is_admin) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.isAdmin() ? "Y" : "N");
            return pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User login(String name, String password) {
        String sql = "SELECT * FROM users WHERE user_name = ? AND user_pass = ?";
        try (Connection conn = DBUtil.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(name, password, "Y".equals(rs.getString("is_admin")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
