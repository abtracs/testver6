package servlet3fragment;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebFilter(filterName="FAFilter", urlPatterns={"/*"})
public class FAFilter implements Filter {
    public void destroy() {
    }  
    public void doFilter(final ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse newresponse = new HttpServletResponseWrapper((HttpServletResponse)response) {
            private boolean sent = false;
            public ServletOutputStream getOutputStream() throws IOException {
                ServletOutputStream sos = getResponse().getOutputStream();
                if(sent == false) {
                    byte[] buf = ("hello from FAFilter: " + request.getParameter("foo") + "<br/>").getBytes("UTF-8");
                    sos.write(buf, 0, buf.length);  // CWEID 80
                    sent = true;
                }
                return sos;
            }
        };
        chain.doFilter(request, newresponse);
    }
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}
