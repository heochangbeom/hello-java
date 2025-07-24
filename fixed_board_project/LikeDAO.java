import java.sql.*;

public class LikeDAO {
    public boolean insertLike(int likeId, int postId, String userId) {
        Connection conn = DBUtil.getConnect();
        String sql = "INSERT INTO likes (like_id, post_id, user_id) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, likeId);
            pstmt.setInt(2, postId);
            pstmt.setString(3, userId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            // 중복 추천 등 예외 가능성
            System.out.println("추천 실패: " + e.getMessage());
        }
        return false;
    }

    public int countLikes(int postId) {
        Connection conn = DBUtil.getConnect();
        String sql = "SELECT COUNT(*) FROM likes WHERE post_id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, postId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}