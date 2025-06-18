package com.librarian.elibrarian.controller;

import com.librarian.elibrarian.dao.LibrarianDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class LoginController {

    @GetMapping("MainPage")
    public String homePage(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            System.out.println("error is: " + error);
            model.addAttribute("errorMessage", "wrong username or password");
        }
        return "index";
    }

    @PostMapping("Login")
    public String login(@RequestParam("users") String userType,
                        @RequestParam(name = "admin_email", required = false) String adminEmail,
                        @RequestParam(name = "admin_password", required = false) String adminPassword,
                        @RequestParam(name = "librarian_email", required = false) String librarianEmail,
                        @RequestParam(name = "librarian_password", required = false) String librarianPassword,
                        RedirectAttributes redirectAttributes) {
        System.out.println("user type: " + userType);

        switch (userType) {
            case "admin" -> {
                System.out.println("adminEmail: " + adminEmail + "\tpassword: " + adminPassword);
                if (adminEmail.equals("admin@library.com") && adminPassword.equals("Admin@1234")) {
                    System.out.println("success login");
                    return "admin-dashboard";
                } else {
                    redirectAttributes.addAttribute("error", true);
                    return "redirect:/MainPage";
                }
            }
            case "librarian" -> {
                System.out.println("librarianEmail: " + librarianEmail + "\tpassword: " + librarianPassword);
                if ((librarianEmail != null && librarianPassword != null)
                        && (LibrarianDao.authenticate(librarianEmail, librarianPassword))) {
                    return "librarian-dashboard";
                } else {
                    redirectAttributes.addAttribute("error", true);
                    return "redirect:/MainPage";
                }
            }
            default -> {
                return "redirect:/MainPage";
            }
        }
    }

    @GetMapping("Logout")
    public String logout(HttpServletRequest request, HttpServletResponse response,
                         RedirectAttributes redirectAttributes) throws IOException {
        request.getSession().invalidate();

        return "redirect:/MainPage";
    }

    @GetMapping("UserLogin")
    public String userLoginRedirection(@RequestParam("nav") String navigationFor) {

        String redirection = "";

        switch (navigationFor) {
            case "admin" -> {
                redirection = "form/admin";
            }
            case "librarian" -> {
                redirection = "form/librarian";
            }
            default -> {
                redirection = "redirect:/MainPage";
            }
        }

        return redirection;
    }
}
