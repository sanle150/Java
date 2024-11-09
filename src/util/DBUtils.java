package util;

import bean.Blog;
import bean.Comments;

import java.sql.*;
import java.util.ArrayList;

public class DBUtils {

	String url="jdbc:mysql://0.0.0.0:3306/blog?serverTimezone=GMT%2B8";
	String user="root";
	String password="";
	Connection conn =null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	/*
	 * 装载驱动
	 * 建立连接
	 * 
	 * 构造SQL
	 * 执行操作
	 * 处理结果
	 * 关闭资源
	 * */
	public DBUtils(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("装载驱动异常！");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库连接异常！");
			e.printStackTrace();
		}
	}

	public ArrayList<Blog> queryAllBlog() {
		ensureConnection();
		String sql = "SELECT * FROM wblog WHERE b_state=1 ORDER BY b_time DESC";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			ArrayList<Blog> blogs = new ArrayList<Blog>();
			while(rs.next()) {
				Blog b= new Blog();
				b.setB_id(rs.getString("b_id"));
				b.setB_time(rs.getString("b_time"));
				b.setB_name(rs.getString("b_name"));
				b.setB_message(rs.getString("b_message"));
				b.setB_state(rs.getInt("b_state"));
				blogs.add(b);
			}
			return blogs;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return null;
	}

	public ArrayList<Comments> queryAllComments(String b_id) {
		ensureConnection();
		String sql = "SELECT * FROM comments WHERE comments_blog_id = ? ORDER BY comments_time DESC";
		ArrayList<Comments> commentsList = new ArrayList<Comments>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, b_id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Comments comment = new Comments();
				comment.setComments_blog_id(rs.getString("comments_blog_id"));
				comment.setComments_message(rs.getString("comments_message"));
				comment.setComments_time(rs.getString("comments_time")); ;
				commentsList.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return commentsList;
	}

	public ArrayList<Comments> queryAllComments()
	{
		ensureConnection();
		String sql = "SELECT * FROM comments ORDER BY comments_time DESC";
		ArrayList<Comments> commentsList = new ArrayList<Comments>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Comments comment = new Comments();
				comment.setComments_blog_id(rs.getString("comments_blog_id"));
				comment.setComments_message(rs.getString("comments_message"));
				comment.setComments_time(rs.getString("comments_time")); ;
				commentsList.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return commentsList;
	}

	public Blog queryABlog(String b_id) {
		ensureConnection();
		String sql = "SELECT * FROM wblog WHERE b_id = ? AND b_state = 1";
		Blog blog = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, b_id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				blog = new Blog();
				blog.setB_id(rs.getString("b_id"));
				blog.setB_time(rs.getString("b_time"));
				blog.setB_name(rs.getString("b_name"));
				blog.setB_message(rs.getString("b_message"));
				blog.setB_state(rs.getInt("b_state"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return blog;
	}

	public boolean inserBlog(Blog blog) {
		ensureConnection();
		String sql = "INSERT INTO wblog (b_id, b_time, b_name, b_message, b_state) VALUES (?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, blog.getB_id());
			psmt.setString(2, blog.getB_time());
			psmt.setString(3, blog.getB_name());
			psmt.setString(4, blog.getB_message());
			psmt.setInt(5, blog.getB_state());
			int rowsAffected = psmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.out.println("插入博客数据异常！");
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	public boolean inserComments(Comments comments) {
		ensureConnection();
		String sql = "INSERT INTO comments (comments_blog_id,comments_message,comments_time) VALUES (?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, comments.getComments_blog_id());
			psmt.setString(2, comments.getComments_message());
			psmt.setString(3, comments.getComments_time());
			int rowsAffected = psmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.out.println("插入评论数据异常！");
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	public boolean deleteBlog(String b_id) {
		ensureConnection();
		String sql = "DELETE FROM wblog WHERE b_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, b_id);
			int rowsAffected = psmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.out.println("删除博客数据异常！");
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	public void ensureConnection() {
		try {
			if (conn == null || conn.isClosed()) {
				try {
					conn = DriverManager.getConnection(url, user, password);
				} catch (SQLException e) {
					System.out.println("重新连接数据库异常！");
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
