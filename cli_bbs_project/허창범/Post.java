package 허창범;

import java.util.Date;

public class Post {
    private int postId;
    private String title;
    private String content;
    private String writerId;
    private Date writeDate;

    public Post() {}

    public Post(int postId, String title, String content, String writerId, Date writeDate) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.writerId = writerId;
        this.writeDate = writeDate;
    }

    public int getPostId() { return postId; }
    public void setPostId(int postId) { this.postId = postId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getWriterId() { return writerId; }
    public void setWriterId(String writerId) { this.writerId = writerId; }

    public Date getWriteDate() { return writeDate; }
    public void setWriteDate(Date writeDate) { this.writeDate = writeDate; }
}