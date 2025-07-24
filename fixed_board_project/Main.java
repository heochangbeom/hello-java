import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();
        PostDAO postDAO = new PostDAO();
        CommentDAO commentDAO = new CommentDAO();
        LikeDAO likeDAO = new LikeDAO();

        System.out.print("아이디 입력: ");
        String name = sc.nextLine();
        System.out.print("비밀번호 입력: ");
        String pass = sc.nextLine();

        User loginUser = userDAO.login(name, pass);

        if (loginUser != null) {
            System.out.println("로그인 성공: " + loginUser.getUserName());

            List<Post> posts = postDAO.getAllPosts();
            for (Post p : posts) {
                System.out.println("[" + p.getPostId() + "] " + p.getTitle() + " - " + p.getUserId());
            }
        } else {
            System.out.println("로그인 실패");
        }
    }
}