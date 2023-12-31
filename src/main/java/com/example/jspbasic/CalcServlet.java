package com.example.jspbasic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name="calcServlet", value = "/calc")
public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding(("UTF-8"));

        PrintWriter out = resp.getWriter(); // 출력

        int num1 = Integer.parseInt((req.getParameter("num1")));
        int num2 = Integer.parseInt((req.getParameter("num2")));

        switch (req.getParameter("op")) {
            case "+" :
                out.println(num1 + " + " + num2 + " = ");
                out.println(num1+num2);
                break;
            case "-" :
                out.println(num1 + " - " + num2 + " = ");
                out.println(num1-num2);
                break;
            case "*" :
                out.println(num1 + " * " + num2 + " = ");
                out.println(num1*num2);
                break;
            case "/" :
                out.println(num1 + " / " + num2 + " = ");
                out.println(num1/num2);
                break;
        }
    }
}
