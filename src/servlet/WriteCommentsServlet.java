package servlet;

import bean.Blog;
import bean.Comments;
import util.DBUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "WriteCommentsServlet", value = "/WriteCommentsServlet")
public class WriteCommentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String comments_time = sdf.format(d);
        String comments_blog_id = request.getParameter("b_id");;
        String comments_message = request.getParameter("message");
        DBUtils dbutil = new DBUtils();
        Comments comments=new Comments(comments_blog_id,comments_message,comments_time);
        boolean ret = dbutil.inserComments(comments);
        if (ret)
        {
            System.out.println("插入评论成功");
            RequestDispatcher dispatcher = request.getRequestDispatcher("ToAlogServlet");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
