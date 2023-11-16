package com.example.jspbasic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="calcServlet", value = "/calc")
public class CalcServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String result = "";

        switch (op) {
            case "+":
                result = plus(num1, num2);
                break;
            case "-":
                result = minus(num1, num2);
                break;
            case "*":
                result = multiply(num1, num2);
                break;
            case "/":
                result = divide(num1, num2);
                break;
        }

        req.setAttribute("result", result); // result 복사
        // 동적 HTML을 응답 : jsp한테 맡기기
        // jsp 호출 / jsp를 포어드해줘야함 (req.getRequestDispatcher)
        RequestDispatcher rd = req.getRequestDispatcher("calc2.jsp");
        rd.forward(req, resp); // 필수
    }

    private String plus(String num1, String num2) {
        return String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2));
    }
    private String minus(String num1, String num2) {
        return String.valueOf(Integer.parseInt(num1) - Integer.parseInt(num2));
    }
    private String multiply(String num1, String num2) {
        return String.valueOf(Integer.parseInt(num1) * Integer.parseInt(num2));
    }
    private String divide(String num1, String num2) {
        return String.valueOf(Integer.parseInt(num1) / Integer.parseInt(num2));
    }
}
