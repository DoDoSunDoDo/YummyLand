package com.yummy.onlineOrder;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        //response.setContentType("text/html");
        String customer = request.getParameter("customer");
        // Hello
        //PrintWriter out = response.getWriter();
        //out.println("<html><body>");
        //out.println("<h1>hello "+customer+ "</h1>");
        //out.println("</body></html>");

        ////////////////////////////////////////////////////////////////////
        //这里用的是json格式
        response.setContentType("application/json");//这里可以改成json格式
        JSONObject obj = new JSONObject();
        obj.put("name", "Sun");
        obj.put("age", "50");
        obj.put("gender", "male");
        response.getWriter().print(obj);
    }

    public void destroy() {
    }

    //通过io流来把web里的信息传过来
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Read customer information from request body
        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
        String email = jsonRequest.getString("email");
        String firstName = jsonRequest.getString("first_name");
        String lastName = jsonRequest.getString("last_name");
        int age = jsonRequest.getInt("age");
        // Print customer information to IDE console
        System.out.println("Email is: " + email);
        System.out.println("First name is: " + firstName);
        System.out.println("Last name is: " + lastName);
        System.out.println("Age is: " + age);
        // Return status = ok as response body to the client
        response.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);
    }





    }