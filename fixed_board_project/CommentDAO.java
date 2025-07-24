import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {
    public boolean insertComment(Comment comment) {
        Connection conn = DBUtil.getConnect();
        String sql = "INSERT INTO comments (comment_id, post_id, user_id, comment_content) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, comment.getCommentId());
            pstmt.setInt(2, comment.getPostId());
            pstmt.setString(3, comment.getUserId());
            pstmt.setString(4, comment.getCommentContent());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Comment> getCommentsByPostId(int postId) {
        List<Comment> list = new ArrayList<>();
        Connection conn = DBUtil.getConnect();
        String sql = "SELECT * FROM comments WHERE post_id = ? ORDER BY created_at";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, postId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Comment comment = new Comment();
                comment.setCommentId(rs.getInt("comment_id"));
                comment.setPostId(rs.getInt("post_id"));
                comment.setUserId(rs.getString("user_id"));
                comment.setCommentContent(rs.getString("comment_content"));
                comment.setCreatedAt(rs.getString("created_at"));
                list.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}