package chapter35introducingservlet.usingcookies; // This must not contain in the file

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetCookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Get cookies from header of HTTP request.
        Cookie[] cookies = req.getCookies();

        // Display these cookies.
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println("<B>");
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            pw.println("name = " + name + "; value = " + value);
        }
        pw.close();

    }
}
