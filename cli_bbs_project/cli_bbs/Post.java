package cli_bbs;

import java.sql.Date;

public class Post {
	private int id;
    private String title;
    private String content;
    private String authorId;
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	public Post(int id, String title, String content, String authorId, Date createdAt, int viewCount) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.authorId = authorId;
		this.createdAt = createdAt;
		this.viewCount = viewCount;
	}
	public Post(int int1, String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}
	private Date createdAt;
    private int viewCount;

	public int getPostId() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getUserId() {
		// TODO Auto-generated method stub
		return null;
	}
}
