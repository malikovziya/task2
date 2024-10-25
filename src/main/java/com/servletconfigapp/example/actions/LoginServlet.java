package com.servletconfigapp.example.actions;

import com.servletconfigapp.example.db.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Connection conn = DB.getCon();
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String privilege = rs.getString("privilege");

                // Set session with user details
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("privilege", privilege);

                if ("admin".equals(privilege)) {
                    response.sendRedirect("admin.jsp"); // Admin page
                } else {
                    response.sendRedirect("user.jsp");  // Regular user page
                }
            } else {
                response.getWriter().println("Invalid username or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Database error: " + e.getMessage());
        }
    }
}
