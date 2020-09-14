package chapter35introducingservlet; // This must not contain in the file

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {

        servletResponse.setContentType("text/html");
        PrintWriter pw = servletResponse.getWriter();
        pw.println("<B>Hello!");
        pw.close();
    }
}

/**
 *  Steps to Compile Servlet Class.
 *      - GenericServlet class is included in javax.servlet.* library which is an api for servlet application
 *          and the standard jdk don't include these class.
 *      - Servlet api is included in Java EE (Enterprise Edition) which differs from the usual Java SE.
 *      - Servlet api is also included in Apache Tomcat or Glassfish which are the open-source product.
 *      - We use servlet-api.jar in Apache Tomcat as the example for this book.
 *
 *  Step 1:
 *      Download the whole Apache Tomcat or the single jar file which support servlet api in Apache Tomcat
 *      (Only servlet-api.jar will be used)
 *
 *  Step 2:
 *      If you download the whole Apache Tomcat just like me, go into this directory and copy the file path.
 *          Example file path (on my machine) - C:\Program Files\Apache Software Foundation\apache-tomcat-8.5.31-windows-x64\apache-tomcat-8.5.31\lib\servlet-api.jars
 *
 *  Step 3 (Optional):
 *      If you are using an IDE or Text Editor, you might want it to recognize the classes in servlet API,
 *      add the servlet-api.jar into the external library for ur IDE/Text Editor (Google for the steps for specific IDE/Text Editor).
 *
 *  Step 4:
 *      When you are compiling the Servlet java file, include the -classpath option and specify the sevlet-api.jar file path.
 *          Here's the command:
 *              javac HelloServlet.java -classpath "C:\Program Files\Apache Software Foundation\apache-tomcat-8.5.31-windows-x64\apache-tomcat-8.5.31\lib\servlet-api.jars"
 *
 *      Additional notes here:
 *          We can specify the the sevlet-api.jar to the path in environment variables as well, then we won't
 *          need to explicitly type the -classpath for every single time.
 *
 *          Here comes the command: (just like that)
 *              javac HelloServlet.java
 *
 *          **But! I can't fix it on my machine I don't know why, and I try it over and over again and it still
 *              doesn't work, so that's it for now.
 *
 *
 *  After compiling the servlet source code:
 *
 *      1. Copy the servlet class file into the directory -
 *          (C:\Program Files\Apache Software Foundation\apache-tomcat-8.5.31-windows-x64\apache-tomcat-8.5.31\webapps\examples\WEB-INF\classes)
 *
 *      2. Add the servlet's name and mappings to the web.xml file which is in this directory
 *          (C:\Program Files\Apache Software Foundation\apache-tomcat-8.5.31-windows-x64\apache-tomcat-8.5.31\webapps\examples\WEB-INF)
 *
 *          In this example, here is the add these codes into the web.xml file
 *
 *              <servlet>
 *                  <servlet-name>HelloServlet</servlet-name>
 *                  <servlet-class>HelloServlet</servlet-class>
 *              </servlet>
 *
 *              <servlet-mapping>
 *                  <servlet-name>HelloServlet</servlet-name>
 *                  <url-pattern>/servlets/servlet/HelloServlet</url-pattern>
 *              </servlet-mapping>
 *
 *    **3. Before starting Tomcat server, we have to set JAVA_HOME in environment variable (required to start server)
 *              a) Add a new variable at either user variable or system variable
 *              b) Variable name: JAVA_HOME
 *              c) Variable value (file path to the jdk): C:\Program Files\Java\jdk-13.0.1
 *              d) We are all set ready to start Tomcat server!
 *
 *      4. Double click on the startup.bat file in apache tomcat/bin directory
 *          (C:\Program Files\Apache Software Foundation\apache-tomcat-8.5.31-windows-x64\apache-tomcat-8.5.31\bin)
 *
 *      5. Server started! Next, we just need to start a web browser and enter the URL shown here:
 *          http://localhost:8080/examples/servlets/servlet/HelloServlet
 *                                      or
 *          http://127.0.0.1:8080/examples/servlets/servlet/HelloServlet
 *          (This can be done because 127.0.0.1 is defined as IP address of the local machine)
 *
 *      6. Done! We will see a string Hello! in bold type on the browser display area.
 *
 */
