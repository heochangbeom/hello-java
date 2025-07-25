package 허창범;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BoardDAO dao = new BoardDAO();
        Member currentUser = null;

        while (true) {
        	System.out.println("=========================================================================");
            System.out.println("1. 로그인 2. 회원가입 3. 조회 4. 검색 5. 등록 6. 수정 7. 삭제 8. 댓글 9. 추천 10. 종료");
            System.out.print("선택> ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("아이디: ");
                    String id = scanner.nextLine();
                    System.out.print("비밀번호: ");
                    String pw = scanner.nextLine();
                    Member m = dao.login(id, pw);
                    if (m != null) {
                        currentUser = m;
                        System.out.println("로그인 성공. 환영합니다, " + m.getUserName() + "님!");
                    } else System.out.println("로그인 실패. 아이디/비밀번호를 확인하세요.");
                    break;

                case 2:
                    System.out.print("새 아이디: ");
                    String newId = scanner.nextLine();
                    System.out.print("이름: ");
                    String newName = scanner.nextLine();
                    System.out.print("비밀번호: ");
                    String newPw = scanner.nextLine();
                    System.out.print("관리자 권한 부여? (y/n): ");
                    boolean isAdmin = scanner.nextLine().equalsIgnoreCase("y");
                    boolean ok = dao.signup(new Member(newId, newName, newPw, isAdmin));
                    System.out.println(ok ? "회원가입 완료." : "회원가입 실패.");
                    break;

                case 3:
                    List<Post> all = dao.listPosts();
                    for (Post p : all) {
                    	System.out.println("===================================");
                        System.out.println(p.getPostId() + ": " + p.getTitle() + " (작성자: " + p.getWriterId() + ", 날짜: " + p.getWriteDate() + ", 추천: " + dao.countLikes(p.getPostId()) + ")");
                    }
                    
                    break;


                case 4:
                    System.out.print("검색어: ");
                    String kw = scanner.nextLine();
                    List<Post> results = dao.searchPosts(kw);
                    for (Post p : results) {
                        System.out.println(p.getPostId() + ": " + p.getTitle() + " (작성자: " + p.getWriterId() + ")");
                    }
                    break;

                case 5:
                    if (currentUser == null) {
                        System.out.println("등록하려면 먼저 로그인하세요.");
                        break;
                    }
                    System.out.print("제목: ");
                    String title = scanner.nextLine();
                    System.out.print("내용: ");
                    String content = scanner.nextLine();
                    Post newPost = new Post(0, title, content, currentUser.getUserId(), null);
                    System.out.println(dao.createPost(newPost) ? "게시글 등록 완료." : "게시글 등록 실패.");
                    break;

                case 6:
                    System.out.print("수정할 게시글 ID: ");
                    int updId = Integer.parseInt(scanner.nextLine());
                    System.out.print("새 제목: ");
                    String updTitle = scanner.nextLine();
                    System.out.print("새 내용: ");
                    String updContent = scanner.nextLine();
                    Post updPost = new Post(updId, updTitle, updContent, null, null);
                    System.out.println(dao.updatePost(updPost) ? "게시글 수정 완료." : "게시글 수정 실패.");
                    break;

                case 7:
                    System.out.print("삭제할 게시글 ID: ");
                    int delId = Integer.parseInt(scanner.nextLine());
                    System.out.println(dao.deletePost(delId) ? "게시글 삭제 완료." : "게시글 삭제 실패.");
                    break;

                case 8:
                    System.out.print("댓글 등록할 게시글 ID: ");
                    int comPostId = Integer.parseInt(scanner.nextLine());
                    System.out.print("댓글 내용: ");
                    String comContent = scanner.nextLine();
                    if (currentUser == null) {
                        System.out.println("댓글 등록하려면 로그인하세요.");
                    } else {
                        System.out.println(dao.addComment(comPostId, currentUser.getUserId(), comContent) ? "댓글 등록 완료." : "댓글 등록 실패.");
                        System.out.println("== 댓글 목록 ==");
                        for (String txt : dao.getComments(comPostId)) {
                            System.out.println(txt);
                        }
                    }
                    break;

                case 9:
                    System.out.print("추천할 게시글 ID: ");
                    int likePostId = Integer.parseInt(scanner.nextLine());
                    if (currentUser == null) {
                        System.out.println("추천하려면 로그인하세요.");
                    } else {
                        System.out.println(dao.addLike(likePostId, currentUser.getUserId()) ? "추천 완료." : "이미 추천했거나 실패.");
                        System.out.println("현재 추천 수: " + dao.countLikes(likePostId));
                    }
                    break;

                case 10:
                    System.out.println("프로그램 종료합니다.");
                    dao.close();
                    scanner.close();
                    return;

                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }
}