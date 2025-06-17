package com.learning.servlet;

import com.learning.servlet.model.ManagerModel;
import com.learning.servlet.repository.ManagerMapper;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/ViewUser")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String sessionId = session.getId();
        System.out.println("SessionId: " + sessionId);

        String actionQuery = req.getParameter("action");

        if (actionQuery != null) {
            switch (actionQuery) {
                case "click1" -> {
                    System.out.println("click 1");
                    req.getRequestDispatcher("/WEB-INF/views/inner-jsp.jsp").forward(req, resp);
                }
                case "click2" -> {
                    System.out.println("click 2");
                    req.getRequestDispatcher("/WEB-INF/views/inner2-jsp.jsp").forward(req, resp);
                }
                default -> {
                    System.out.println("no redirection made");
                    resp.getWriter().println("no redirection made");
                }
            }
        } else {
            System.out.println("query action parameter is null, redirect back to index.jsp");
            session.invalidate();
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputValue = req.getParameter("inputValue");
        if ((inputValue != null) && (!inputValue.isEmpty())) {
            if (inputValue.equals("administrator")) {
                // validate password, if true, GOTO page admin, else throw error
                HttpSession session = req.getSession(false);
                session.setAttribute("username", inputValue);
                listUser(req, resp, session);
            } else if (inputValue.matches("(\\d{7})")) {
                int id = Integer.parseInt(inputValue);
                HttpSession session = req.getSession(false);
                session.setAttribute("username", id);
                listUser(req, resp, session);
            } else {
                resp.getWriter().println("none page");
            }
        } else {
            System.out.println("input value is empty/null, please insert a correct value");
        }
    }

    private void listUser(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, IOException {
        List<ManagerModel> managerList = ManagerMapper.getAllManagers();
        if (!managerList.isEmpty()) {
            for (ManagerModel manager : managerList) {
                System.out.println("id: " + manager.getId() + "\tname: " + manager.getFullname() + "\trole: " + manager.getRole() + "\tpost: "
                        + manager.getPosition() + "\tdept: " + manager.getDepartment() + "\tphone: " + manager.getPhone() + "\temail: " + manager.getEmail());
            }
            session.setAttribute("viewManager", managerList);
            req.getRequestDispatcher("/WEB-INF/views/viewManager.jsp").forward(req, resp);
        }
    }
}
