package servlet;

import bean.Blog;
import bean.Comments;
import util.DBUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ToAlogServlet", value = "/ToAlogServlet")
public class ToAlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String b_id = request.getParameter("b_id");
        System.out.println(b_id);
        DBUtils dbutil = new DBUtils();
        Blog blog = dbutil.queryABlog(b_id);
        ArrayList<Comments> comments=dbutil.queryAllComments(b_id);
        request.setAttribute("co",comments);
        request.setAttribute("blog", blog);
        request.getRequestDispatcher("ablog.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
