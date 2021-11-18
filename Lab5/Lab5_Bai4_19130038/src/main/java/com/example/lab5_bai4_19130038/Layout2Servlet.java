package com.example.lab5_bai4_19130038;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.validator.routines.EmailValidator;

@WebServlet(name = "Layout2Servlet", value = "/Layout2Servlet")
public class Layout2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// setting encoding
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        // get name, email, phone and service choosing
        String username = request.getParameter("username");
        String password = request.getParameter("pass");

        //check the info
        response.getWriter().println(checkNameOrEmail(username) + "<br/>");
        response.getWriter().println(checkPassword(password));
    }


    public String checkNameOrEmail(String input) {
        if (input.equals("")) {
            return "Chua nhap username!";
        } else {
            byte[] bytes = input.getBytes(StandardCharsets.UTF_8);
            return new String(bytes, StandardCharsets.UTF_8);
        }
    }

    // password conditions: length >= 8, must have 2 numbers or more
    public String checkPassword(String password) {
        char[] passCharArr = password.toCharArray();
        int digit = 0;
        for (int i = 0; i < passCharArr.length; i++) {
            if (!Character.isDigit(passCharArr[i])) {
                digit++;
            }
        }
        if (digit < 2) {
            return "Mat khau bat buoc phai co 2 chu so.";
        } else if (passCharArr.length < 8 || password.equals("")) {
            return "Mat khau phai co 8 ky tu tro len.";
        } else
            return password;
    }
}
