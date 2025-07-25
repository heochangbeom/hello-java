package cli_bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {
	public boolean addComment(Comment comment) {
        String sql = "INSERT INTO comments (comment_id, post_id, user_id, content) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, comment.getCommentId());
            pstmt.setInt(2, comment.getPostId());
            pstmt.setString(3, comment.getUserId());
            pstmt.setString(4, comment.getContent());

            return pstmt.executeUpdate() == 1;

        } catch (Exception e) {
            System.out.println("[오류] 댓글 추가 실패");
            e.printStackTrace();
        }
        return false;
    }

    public List<Comment> getCommentsByPost(int postId) {
        List<Comment> list = new ArrayList<>();
        String sql = "SELECT * FROM comments WHERE post_id = ? ORDER BY comment_id";

        try (Connection conn = DBUtil.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, postId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(new Comment(
                    rs.getInt("comment_id"),
                    rs.getInt("post_id"),
                    rs.getString("user_id"),
                    rs.getString("content")
                ));
            }

        } catch (Exception e) {
            System.out.println("[오류] 댓글 조회 실패");
            e.printStackTrace();
        }

        return list;
    }
}
