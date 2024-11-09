package servlet;

import bean.Blog;
import bean.Comments;
import util.DBUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ToIndexServlet", value = "/ToIndexServlet")
public class ToIndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBUtils dbutil=new DBUtils();
        ArrayList<Blog> blogs=dbutil.queryAllBlog();
        ArrayList<Comments> comments=dbutil.queryAllComments();
        request.setAttribute("bl",blogs);
        request.setAttribute("co",comments);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
