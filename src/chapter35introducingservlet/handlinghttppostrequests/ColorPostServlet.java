package chapter35introducingservlet.handlinghttppostrequests; // must not include this when compiling this file

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ColorPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String color = req.getParameter("color");
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println("<B>The selected color is: ");
        pw.println(color);
        pw.close();

    }
}

/**
 *  Command to compile this file:
 *      javac -d ~/IdeaProjects/'Examples in Java The Complete Reference'/out/production/'Examples in Java The Complete Reference'
 *      chapter35introducingservlet/handlinghttppostrequests/ColorPostServlet.java
 *      -classpath "C:\Program Files\Apache Software Foundation\apache-tomcat-8.5.31-windows-x64\apache-tomcat-8.5.31\lib\servlet-api.jar"
 */
