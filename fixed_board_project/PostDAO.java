import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    public boolean insertPost(Post post) {
        Connection conn = DBUtil.getConnect();
        String sql = "INSERT INTO posts (post_id, title, post_content, user_id) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, post.getPostId());
            pstmt.setString(2, post.getTitle());
            pstmt.setString(3, post.getPostContent());
            pstmt.setString(4, post.getUserId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Post> getAllPosts() {
        List<Post> list = new ArrayList<>();
        Connection conn = DBUtil.getConnect();
        String sql = "SELECT * FROM posts ORDER BY created_at DESC";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setPostId(rs.getInt("post_id"));
                post.setTitle(rs.getString("title"));
                post.setPostContent(rs.getString("post_content"));
                post.setUserId(rs.getString("user_id"));
                post.setCreatedAt(rs.getString("created_at"));
                list.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}