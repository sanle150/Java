package bean;

public class Comments {
    String comments_blog_id;
    String comments_message;
    String comments_time;

    public Comments(){}

    public Comments(String comments_blog_id, String comments_message,String comments_time) {
        this.comments_blog_id = comments_blog_id;
        this.comments_message = comments_message;
        this.comments_time = comments_time;
    }

    public String getComments_blog_id() {
        return comments_blog_id;
    }

    public void setComments_blog_id(String comments_blog_id) {
        this.comments_blog_id = comments_blog_id;
    }

    public String getComments_message() {
        return comments_message;
    }

    public void setComments_message(String comments_message) {
        this.comments_message = comments_message;
    }

    public String getComments_time() {
        return comments_time;
    }

    public void setComments_time(String comments_time) {
        this.comments_time = comments_time;
    }
}
