package servlet3fragment;

import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class FAServletRequestListener implements ServletRequestListener {
    private Logger logger = Logger.getLogger(getClass().getName());
    public void requestInitialized(ServletRequestEvent sre) {
        logger.info("FAServletRequestListener requestInitialized: " + sre.getServletRequest().getParameter("foo"));
        try {
            FileInputStream fis = new FileInputStream(sre.getServletRequest().getParameter("foo"));    // CWEID 73
            byte[] buf = new byte[65536];
            int retval = fis.read(buf, 0, buf.length);
            if(retval > 0) {
                String str = new String(buf, 0, retval);
                logger.info("FAServletRequestListener file data: " + str);
            }
        } catch (Exception ignore) { }
    }
    public void requestDestroyed(ServletRequestEvent sre) {
        logger.info("FAServletRequestListener requestDestroyed: " + sre.toString());
    } 
}
