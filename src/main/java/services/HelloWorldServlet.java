package services;

import Dao.HelloDao;
import Dao.HelloDaoImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;


/**
 * Created by acangou on 16/11/16.
 */
//@WebServlet(name = "HelloWorldServlet",urlPatterns = {"/hello"})
public class HelloWorldServlet extends HttpServlet {

    HelloService helloService = new HelloServiceImpl();












    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("texte.html");
        PrintWriter out = response.getWriter();

        String fullhello=helloService.sayhello(request.getParameter("nom"));

        out.println("<html> <head> <title></title> </head> <body> Today's date: = "+(new java.util.Date()).toLocaleString()+" <p>  "+fullhello+"</p> </body> </html>");
        // out.println("<html> <head> <title></title> </head> <body> Today's date: = "+(new java.util.Date()).toLocaleString()+" <p> Hello "+request.getParameter("nom")+"</p> </body> </html>");

        out.flush();

    }
}

