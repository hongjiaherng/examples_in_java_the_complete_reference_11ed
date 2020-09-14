package chapter35introducingservlet.usingcookies; // This must not contain in the file

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddCookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Get parameter from HTTP request.
        String data = req.getParameter("data");

        // Create cookie.
        Cookie cookie = new Cookie("MyCookie", data);

        // Add cookie to HTTP response.
        resp.addCookie(cookie);

        // Write output to browser.
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println("<B>MyCookie has been set to</B>");
        pw.println(data);
        pw.close();

    }
}
