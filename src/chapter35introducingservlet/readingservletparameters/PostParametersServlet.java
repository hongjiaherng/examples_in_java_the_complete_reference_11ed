package chapter35introducingservlet.readingservletparameters; // This must not contain in the file

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class PostParametersServlet extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {

        // Get print writer.
        PrintWriter pw = servletResponse.getWriter();

        // Get enumeration of parameter names.
        Enumeration<String> e = servletRequest.getParameterNames();

        // Display parameter names and values.
        while (e.hasMoreElements()) {
            String pname = e.nextElement();
            pw.print(pname + " = ");
            String pvalue = servletRequest.getParameter(pname);
            pw.println(pvalue);
        }
        pw.close();
    }
}

/**
 *
 *  ****MAKE SURE THIS FILE DOESN'T INCLUDE THE PACKAGE SYNTAX BEFORE COMPILING, IT MUST BE DELETED OR ELSE SOME ERROR HAPPENS WHEN SUBMIT THE FORM****
 *  Command to compile this file:
 *      javac -d ~/IdeaProjects/'Examples in Java The Complete Reference'/out/production/'Examples in Java The Complete Reference'
 *      chapter35introducingservlet/readingservletparameters/PostParametersServlet.java
 *      -classpath "C:\Program Files\Apache Software Foundation\apache-tomcat-8.5.31-windows-x64\apache-tomcat-8.5.31\lib\servlet-api.jar"
 */
