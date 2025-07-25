
package cli_bbs;

import java.util.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
    private static UserDAO userDAO = new UserDAO();
    private static PostDAO postDAO = new PostDAO();
    private static CommentDAO commentDAO = new CommentDAO();
    private static User loginUser = null;

    public static void main(String[] args) {
        while (true) {
            if (loginUser == null) {
            	System.out.println("----------------------------------------------");
                System.out.println("1. 로그인 | 2. 회원가입 | 0. 종료");
                System.out.print("선택 >> ");
                int choice = sc.nextInt(); sc.nextLine();

                if (choice == 1) login();
                else if (choice == 2) register();
                else break;
            } else {
                System.out.println("\n[" + loginUser.getName() + "]님 환영합니다!");
                System.out.println("1. 게시글 목록 | 2. 게시글 작성 | 3. 로그아웃");
                System.out.print("선택 >> ");
                int choice = sc.nextInt(); sc.nextLine();

                if (choice == 1) listPosts();
                else if (choice == 2) writePost();
                else loginUser = null;
            }
        }
    }

    private static void login() {
        System.out.print("이름 입력: ");
        String name = sc.nextLine();
        System.out.print("비밀번호 입력: ");
        String pw = sc.nextLine();

        User user = userDAO.login(name, pw);
        if (user != null) loginUser = user;
        else System.out.println("로그인 실패!");
    }

    private static void register() {
        System.out.print("ID 입력: ");
        String id = sc.nextLine();
        System.out.print("이름 입력: ");
        String name = sc.nextLine();
        System.out.print("비밀번호 입력: ");
        String pw = sc.nextLine();

        boolean isAdmin = false;
        if (name.equalsIgnoreCase("admin")) isAdmin = true;

        User newUser = new User(id, name, pw, isAdmin);
        if (userDAO.register(newUser)) System.out.println("회원가입 완료!");
        else System.out.println("회원가입 실패!");
    }

    private static void listPosts() {
        List<Post> posts = postDAO.listPosts();
        for (Post p : posts) {
            System.out.println(p.getPostId() + " | " + p.getTitle() + " | 작성자: " + p.getUserId());
        }
    }

    private static void writePost() {
        System.out.print("제목: ");
        String title = sc.nextLine();
        System.out.print("내용: ");
        String content = sc.nextLine();

        int postId = (int)(Math.random() * 10000);
        Post post = new Post(postId, loginUser.getUserId(), title, content);
        if (postDAO.createPost(post)) System.out.println("작성 완료!");
        else System.out.println("작성 실패!");
    }
}
