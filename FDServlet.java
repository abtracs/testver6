package servlet3fragment;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FDServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setStatus(200);
        out.println("(FDServlet) here is some xss: ");
        out.println(request.getParameter("foo"));       // CWEID 80
        out.flush();
        out.close();
    }
}
