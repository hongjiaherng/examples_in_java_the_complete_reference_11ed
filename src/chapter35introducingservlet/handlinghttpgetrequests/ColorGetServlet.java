package chapter35introducingservlet.handlinghttpgetrequests; // Don't include this when compiling this file, otherwise some errors occur

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ColorGetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
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
 *  Compile this file with command:
 *      javac -d ~/IdeaProjects/'Examples in Java The Complete Reference'/out/production/'Examples in Java The Complete Reference'
 *      chapter35introducingservlet/handlinghttpgetrequests/ColorGetServlet.java
 *      -classpath "C:\Program Files\Apache Software Foundation\apache-tomcat-8.5.31-windows-x64\apache-tomcat-8.5.31\lib\servlet-api.jar"
 */
