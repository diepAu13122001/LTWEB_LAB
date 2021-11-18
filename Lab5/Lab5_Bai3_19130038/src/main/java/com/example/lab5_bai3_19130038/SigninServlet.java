package com.example.lab5_bai3_19130038;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.validator.routines.EmailValidator;

@WebServlet(name = "SigninServlet", value = "/SigninServlet")
public class SigninServlet extends HttpServlet {
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
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String option = request.getParameter("service");
        String message = request.getParameter("message");

        //check the info
        response.getWriter().println(checkName(name)+"<br/>");
        response.getWriter().println(checkEmail(email)+"<br/>");
        response.getWriter().println(checkPhone(phone)+"<br/>");
        response.getWriter().println(checkOption(option)+"<br/>");
        response.getWriter().println(message);
    }

    public String checkName(String name) {
        if (name == null || name.equals("")) {
            return "Chua nhap ten!";
        } else {
            byte[] bytes = name.getBytes(StandardCharsets.UTF_8);
            return new String(bytes, StandardCharsets.UTF_8);
        }
    }

    public String checkEmail(String email) {
        if (email == null || email.equals("")) {
            return "Chua nhap email!";
        } else {
            boolean valid = EmailValidator.getInstance(true).isValid(email);
            if (!valid) {
                return "Email chua chinh xac!";
            } else {
                return email;
            }
        }
    }

    public String checkPhone(String phone) {
        for (int i = 0; i < phone.toCharArray().length; i++) {
            if (!Character.isDigit(phone.toCharArray()[i])) {
                return "So dien thoai da nhap sai";
            }
        }
        return phone;
    }

    public String checkOption(String option) {
        if(option.equals("Please chooses") || option == ""){
            return "Hay chon 1 dich vu ma ban muon!";
        }else {
            return option;
        }
    }
}
