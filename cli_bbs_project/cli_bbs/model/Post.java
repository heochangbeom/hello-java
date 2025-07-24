
package cli_bbs.model;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private int id;
    private String title;
    private String content;
    private String author;
    private String date;
    private int likes;
    private List<Comment> comments = new ArrayList<>();

    public Post(int id, String title, String content, String author, String date, int likes) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.likes = likes;
    }

    // Getters and Setters

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getAuthor() { return author; }
    public String getDate() { return date; }
    public int getLikes() { return likes; }
    public List<Comment> getComments() { return comments; }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void like() {
        likes++;
    }
}
