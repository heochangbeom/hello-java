package 허창범;

import java.sql.*;
import java.util.*;

public class BoardDAO {
    private Connection conn;

    public BoardDAO() {
        conn = DBUtil.getConnect();
    }

    // 1. 로그인
    public Member login(String userId, String password) {
        String sql = "SELECT user_id, user_name, user_pass, is_admin FROM users WHERE user_id = ? AND user_pass = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, userId);
            pst.setString(2, password);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    boolean isAdmin = "Y".equalsIgnoreCase(rs.getString("is_admin"));
                    return new Member(
                        rs.getString("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_pass"),
                        isAdmin
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 2. 회원가입
    public boolean signup(Member member) {
        String sql = "INSERT INTO users(user_id, user_name, user_pass, is_admin) VALUES(?, ?, ?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, member.getUserId());
            pst.setString(2, member.getUserName());
            pst.setString(3, member.getUserPass());
            pst.setString(4, member.isAdmin() ? "Y" : "N");
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 3. 전체 게시글 조회
    public List<Post> listPosts() {
        List<Post> list = new ArrayList<>();
        String sql = "SELECT post_id, title, content, writer_id, write_date FROM posts ORDER BY write_date DESC";
        try (PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                list.add(new Post(
                    rs.getInt("post_id"),
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getString("writer_id"),
                    rs.getTimestamp("write_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 4. 게시글 검색 (디버그 포함)
    public List<Post> searchPosts(String keyword) {
        List<Post> list = new ArrayList<>();
        System.out.println("[Debug] searchPosts 호출, 키워드: " + keyword);
        String sql = "SELECT post_id, title, content, writer_id, write_date FROM posts " +
                     "WHERE title LIKE ? OR content LIKE ? ORDER BY write_date DESC";
        System.out.println("[Debug] SQL: " + sql);
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            String kw = "%" + keyword + "%";
            pst.setString(1, kw);
            pst.setString(2, kw);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(new Post(
                        rs.getInt("post_id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("writer_id"),
                        rs.getTimestamp("write_date")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 5. 게시글 등록
    public boolean createPost(Post post) {
        String sql = "INSERT INTO posts(post_id, title, content, writer_id, write_date) " +
                     "VALUES(posts_seq.nextval, ?, ?, ?, SYSDATE)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, post.getTitle());
            pst.setString(2, post.getContent());
            pst.setString(3, post.getWriterId());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 6. 게시글 수정
    public boolean updatePost(Post post) {
        String sql = "UPDATE posts SET title = ?, content = ? WHERE post_id = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, post.getTitle());
            pst.setString(2, post.getContent());
            pst.setInt(3, post.getPostId());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 7. 게시글 삭제
    public boolean deletePost(int postId) {
        String sql = "DELETE FROM posts WHERE post_id = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, postId);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 8. 댓글 등록
    public boolean addComment(int postId, String writerId, String content) {
        String sql = "INSERT INTO comments(comment_id, post_id, writer_id, content, write_date) " +
                     "VALUES(comments_seq.nextval, ?, ?, ?, SYSDATE)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, postId);
            pst.setString(2, writerId);
            pst.setString(3, content);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<String> getComments(int postId) {
        List<String> list = new ArrayList<>();
        String sql = "SELECT writer_id || ': ' || content || ' [' || TO_CHAR(write_date, 'YYYY-MM-DD HH24:MI:SS') || ']' AS text " +
                     "FROM comments WHERE post_id = ? ORDER BY write_date";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, postId);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(rs.getString("text"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 9. 추천(좋아요)
    public boolean addLike(int postId, String user_id) {
        String sql = "INSERT INTO likes(like_id, post_id, user_id) VALUES(likes_seq.nextval, ?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, postId);
            pst.setString(2, user_id);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int countLikes(int postId) {
        String sql = "SELECT COUNT(*) cnt FROM likes WHERE post_id = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, postId);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) return rs.getInt("cnt");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 리소스 해제
    public void close() {
        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
}