package org.example.hitcounter;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private int hitCount;
    private Integer pageCount;
    public void init() {
        hitCount=0;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        hitCount++;
        PrintWriter out = response.getWriter();
        out.println("The Total Count is: "+hitCount);
        HttpSession session = request.getSession(true);
        pageCount = (Integer) session.getAttribute("pagecount");
        if(pageCount==null){
            pageCount=1;
            session.setAttribute("pagecount", pageCount);
        }else{
            pageCount++;
            session.setAttribute("pagecount", pageCount);
        }
        out.println("The Page Count is "+ pageCount);
    }

    public void destroy() {
    }
}