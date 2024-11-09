package servlet;

import bean.Blog;
import util.DBUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "WriteBlogServlet", value = "/WriteBlogServlet")
public class WriteBlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String b_id = UUID.randomUUID().toString().replace("-", "");
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String b_time = sdf.format(d);
        String b_name = request.getParameter("name");
        String b_message = request.getParameter("message");
        int b_state=1;
        Blog blog=new Blog(b_id,b_time,b_name,b_message,b_state);
        DBUtils dbutil = new DBUtils();
        boolean ret = dbutil.inserBlog(blog);
        if(ret)
        {
            System.out.println("插入成功");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ToIndexServlet");
            dispatcher.forward(request, response);
        }
        else
        {
            System.out.println("插入失败");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/adderror.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
