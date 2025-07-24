
package cli_bbs;

import cli_bbs.dao.CommentDAO;
import cli_bbs.dao.PostDAO;
import cli_bbs.dao.UserDAO;
import cli_bbs.model.Comment;
import cli_bbs.model.Post;
import cli_bbs.model.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static UserDAO userDAO = new UserDAO();
    static PostDAO postDAO = new PostDAO();
    static CommentDAO commentDAO = new CommentDAO();
    static User currentUser;

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. 로그인 | 2. 회원가입");
            System.out.print("선택>> ");
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                login();
            } else if (choice.equals("2")) {
                register();
            }

            if (currentUser != null) {
                menu();
            }
        }
    }

    static void login() {
        System.out.print("이름을 입력하십시오>> ");
        String name = sc.nextLine();
        System.out.print("비밀번호를 입력하십시오>> ");
        String pass = sc.nextLine();
        currentUser = userDAO.login(name, pass);
        if (currentUser != null) {
            System.out.println("로그인 성공");
        } else {
            System.out.println("로그인 실패");
        }
    }

    static void register() {
        System.out.print("이름을 생성하십시오>> ");
        String name = sc.nextLine();
        System.out.print("비밀번호를 생성하십시오>> ");
        String pass1 = sc.nextLine();
        System.out.print("비밀번호 재확인>> ");
        String pass2 = sc.nextLine();
        if (!pass1.equals(pass2)) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return;
        }
        boolean isAdmin = name.equalsIgnoreCase("admin");
        User user = new User(name, pass1, isAdmin);
        if (userDAO.register(user)) {
            System.out.println("회원가입완료");
        }
    }

    static void menu() {
        while (true) {
            System.out.println("====================================");
            System.out.println("1. 게시물 조회 | 2. 게시물 검색 | 3. 게시물 작성 | 4. 종료");
            System.out.println("====================================");
            System.out.print("선택>> ");
            String sel = sc.nextLine();
            switch (sel) {
                case "1": viewPosts(); break;
                case "2": searchPosts(); break;
                case "3": writePost(); break;
                case "4": System.exit(0);
            }
        }
    }

    static void viewPosts() {
        List<Post> posts = postDAO.getAllPosts();
        System.out.println("글번호	제목	작성자	작성일");
        for (Post p : posts) {
            System.out.printf("%d	%s	%s	%s
", p.getId(), p.getTitle(), p.getAuthor(), p.getDate());
        }
        System.out.print("번호 선택>> ");
        int postId = Integer.parseInt(sc.nextLine());
        Post selected = postDAO.getPostById(postId);
        if (selected == null) {
            System.out.println("해당 게시물이 존재하지 않습니다.");
            return;
        }
        postDetail(selected);
    }

    static void postDetail(Post post) {
        while (true) {
            System.out.println("===============================");
            System.out.println("제목: " + post.getTitle());
            System.out.println("작성자: " + post.getAuthor());
            System.out.println("추천: " + post.getLikes() + "건");
            System.out.println();
            System.out.println(post.getContent());
            System.out.println("-------------------------------");
            List<Comment> comments = commentDAO.getCommentsByPostId(post.getId());
            for (int i = 0; i < comments.size(); i++) {
                Comment c = comments.get(i);
                System.out.printf("댓글%d
%s: "%s"
", i + 1, c.getAuthor(), c.getContent());
            }
            System.out.println("===============================");
            System.out.println("1. 댓글 | 2. 추천 | 3. 수정 | 4. 삭제 | 5. 나가기");
            System.out.print("선택>> ");
            String sel = sc.nextLine();
            switch (sel) {
                case "1":
                    System.out.println("1댓글작성 2나가기>> ");
                    String comOpt = sc.nextLine();
                    if (comOpt.equals("1")) {
                        System.out.print("댓글입력>> ");
                        String content = sc.nextLine();
                        commentDAO.addComment(post.getId(), new Comment(currentUser.getName(), content));
                        System.out.println("작성완료");
                    }
                    break;
                case "2":
                    postDAO.likePost(post.getId());
                    post = postDAO.getPostById(post.getId());
                    break;
                case "3":
                    if (currentUser.getName().equals(post.getAuthor()) || currentUser.isAdmin()) {
                        System.out.print("수정할 내용 입력>> ");
                        String newContent = sc.nextLine();
                        postDAO.updatePost(post.getId(), newContent);
                        post = postDAO.getPostById(post.getId());
                    } else {
                        System.out.println("수정 권한이 없습니다.");
                    }
                    break;
                case "4":
                    if (currentUser.getName().equals(post.getAuthor()) || currentUser.isAdmin()) {
                        System.out.print("정말로 삭제하시겠습니까? (예/아니오)>> ");
                        String ans = sc.nextLine();
                        if (ans.equals("예")) {
                            postDAO.deletePost(post.getId());
                            return;
                        }
                    } else {
                        System.out.println("삭제 권한이 없습니다.");
                    }
                    break;
                case "5": return;
            }
        }
    }

    static void searchPosts() {
        System.out.println("---------------------------------");
        System.out.println("1번호 2제목 3작성자 4작성일");
        System.out.println("---------------------------------");
        System.out.print("선택>> ");
        String sel = sc.nextLine();
        List<Post> posts = postDAO.getAllPosts();
        List<Post> result = new java.util.ArrayList<>();
        switch (sel) {
            case "1":
                System.out.print("번호검색>> ");
                int id = Integer.parseInt(sc.nextLine());
                Post p = postDAO.getPostById(id);
                if (p != null) result.add(p);
                break;
            case "2":
                System.out.print("제목검색>> ");
                String keyword = sc.nextLine();
                for (Post post : posts)
                    if (post.getTitle().contains(keyword)) result.add(post);
                break;
            case "3":
                System.out.print("작성자검색>> ");
                String author = sc.nextLine();
                for (Post post : posts)
                    if (post.getAuthor().contains(author)) result.add(post);
                break;
            case "4":
                System.out.print("작성일검색 (예: 2025.07.01-2025.07.10)>> ");
                String[] range = sc.nextLine().split("-");
                for (Post post : posts) {
                    if (post.getDate().compareTo(range[0]) >= 0 && post.getDate().compareTo(range[1]) <= 0)
                        result.add(post);
                }
                break;
        }
        if (result.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            System.out.println("글번호	제목	작성자	작성일");
            for (Post post : result)
                System.out.printf("%d	%s	%s	%s
", post.getId(), post.getTitle(), post.getAuthor(), post.getDate());
        }
    }

    static void writePost() {
        System.out.print("제목입력>> ");
        String title = sc.nextLine();
        System.out.print("글 내용 작성>> ");
        String content = sc.nextLine();
        String date = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
        Post post = new Post(0, title, content, currentUser.getName(), date, 0);
        if (postDAO.createPost(post)) {
            System.out.println("등록완료");
        }
    }
}
