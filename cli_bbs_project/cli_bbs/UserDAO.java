package cli_bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	public User login(String name, String password) {
        String sql = "SELECT * FROM users WHERE name = ? AND password = ?";
        try (Connection conn = DBUtil.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name.trim());
            pstmt.setString(2, password.trim());

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(
                    rs.getString("user_id"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("is_admin").equalsIgnoreCase("Y")
                );
            }

        } catch (Exception e) {
            System.out.println("[오류] 로그인 중 문제 발생");
            e.printStackTrace();
        }
        return null;
    }

    public boolean register(User user) {
        String sql = "INSERT INTO users (user_id, name, password, is_admin) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.isAdmin() ? "Y" : "N");

            return pstmt.executeUpdate() == 1;

        } catch (Exception e) {
            System.out.println("[오류] 회원가입 중 문제 발생");
            e.printStackTrace();
        }
        return false;
    }
}
