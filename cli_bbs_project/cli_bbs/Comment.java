package cli_bbs;

import java.sql.Date;

public class Comment {
	 private int id;
	    private int postId;
	    private String authorId;
	    private String content;
	    private Date createdAt;
	    
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getPostId() {
			return postId;
		}

		public void setPostId(int postId) {
			this.postId = postId;
		}

		public String getAuthorId() {
			return authorId;
		}

		public void setAuthorId(String authorId) {
			this.authorId = authorId;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Comment(int id, int postId, String authorId, String content) {
			super();
			this.id = id;
			this.postId = postId;
			this.authorId = authorId;
			this.content = content;
			this.createdAt = createdAt;
		}

		public int getCommentId() {
			// TODO Auto-generated method stub
			return 0;
		}

		public String getUserId() {
			// TODO Auto-generated method stub
			return null;
		}
}
