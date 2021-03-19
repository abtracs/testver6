package servlet3fragment;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name="FAServlet", urlPatterns={"/faserv"})
public class FAServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setStatus(200);
        out.println("(FAServlet) here is some xss: ");
        out.println(request.getParameter("foo"));       // CWEID 80
        out.flush();
        out.close();
    }
}
