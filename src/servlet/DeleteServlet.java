package servlet;

import util.DBUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String b_id = request.getParameter("b_id");
        DBUtils dbutil = new DBUtils();
        boolean ret = dbutil.deleteBlog(b_id);
        System.out.println(b_id);
        if(ret==true)
        {
            System.out.println("删除成功");
            request.getRequestDispatcher("ToIndexServlet").forward(request, response);
        }
        else
        {
            System.out.println("删除失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
