package com.example.lab5_bai4_19130038;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import org.apache.commons.validator.routines.EmailValidator;

@WebServlet(name = "Layout3Servlet", value = "/Layout3Servlet")
public class Layout3Servlet extends HttpServlet {
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
        String password = request.getParameter("password");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String gender = request.getParameter("gender");
        String payMethod = request.getParameter("payment-method");
        String cardNum = request.getParameter("cardNum");
        String cardCVC = request.getParameter("cvc");
        String checkbox = request.getParameter("checkbox");

        //check the info
        response.getWriter().println(checkName(name) + "<br/>");
        response.getWriter().println(checkEmail(email) + "<br/>");
        response.getWriter().println(checkPassword(password) + "<br/>");
        response.getWriter().println(checkBirthDate(day, month, year) + "<br/>");
        response.getWriter().println(checkGender(gender) + "<br/>");
        response.getWriter().println(checkPayMethod(payMethod) + "<br/>");
        response.getWriter().println(checkCardNum(cardNum) + "<br/>");
        response.getWriter().println(checkCVC(cardCVC) + "<br/>");
        response.getWriter().println(checkbox + "<br/>");
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

    public String checkBirthDate(String day, String month, String year) {
        try {
            int dd = Integer.parseInt(day);
            int mm = Integer.parseInt(month);
            int yyyy = Integer.parseInt(year);
            int thisYear = new Date().getYear();
            if (dd < 1 || dd > 31) {
                return "Khong co ngay nay";
            }
            if (mm < 1 || mm > 12) {
                return "Khong co thang nay";
            }
            if (yyyy < 1900 || yyyy > thisYear) {
                return "Vui long nhap nam trong khoang [1900, " + (thisYear + 1900) + "]";
            }
            return dd + "/" + mm + "/" + yyyy;
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    public String checkGender(String gender) {
        if (gender.equals("")) {
            return "Hay chon gioi tinh.";
        } else {
            return gender;
        }
    }

    public String checkPayMethod(String payMethod) {
        return payMethod;
    }

    public String checkCardNum(String cardNum) {
        for (int i = 0; i < cardNum.toCharArray().length; i++) {
            if (!Character.isDigit(cardNum.toCharArray()[i])) {
                return "So the sai dinh dang (chi co the nhap chu so)";
            }
        }
        return cardNum;
    }

    public String checkCVC(String cvc) {
        if (cvc.length() != 3) {
            return "cvc phai gom 3 chu so";
        } else {
            for (int i = 0; i < cvc.toCharArray().length; i++) {
                if (!Character.isDigit(cvc.toCharArray()[i])) {
                    return "cvc chir co the la chu so";
                }
            }
        }
        return cvc;
    }
}
