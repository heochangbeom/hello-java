package cli_bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
	 public boolean createPost(Post post) {
	        String sql = "INSERT INTO posts (post_id, user_id, title, content) VALUES (?, ?, ?, ?)";
	        try (Connection conn = DBUtil.getConnect();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            pstmt.setInt(1, post.getPostId());
	            pstmt.setString(2, post.getUserId());
	            pstmt.setString(3, post.getTitle());
	            pstmt.setString(4, post.getContent());

	            return pstmt.executeUpdate() == 1;

	        } catch (SQLException e) {
	            System.out.println("[오류] 게시글 작성 실패");
	            e.printStackTrace();
	        }
	        return false;
	    }

	    public List<Post> listPosts() {
	        List<Post> posts = new ArrayList<>();
	        String sql = "SELECT * FROM posts ORDER BY post_id DESC";

	        try (Connection conn = DBUtil.getConnect();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {

	            while (rs.next()) {
	                posts.add(new Post(
	                    rs.getInt("post_id"),
	                    rs.getString("user_id"),
	                    rs.getString("title"),
	                    rs.getString("content")
	                ));
	            }

	        } catch (SQLException e) {
	            System.out.println("[오류] 게시글 목록 조회 실패");
	            e.printStackTrace();
	        }

	        return posts;
	    }

	    public boolean deletePost(int postId) {
	        String sql = "DELETE FROM posts WHERE post_id = ?";
	        try (Connection conn = DBUtil.getConnect();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            pstmt.setInt(1, postId);
	            return pstmt.executeUpdate() == 1;

	        } catch (SQLException e) {
	            System.out.println("[오류] 게시글 삭제 실패");
	            e.printStackTrace();
	        }
	        return false;
	    }
}
