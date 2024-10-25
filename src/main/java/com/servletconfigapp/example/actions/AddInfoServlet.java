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

@WebServlet("/AddInfoServlet")
public class AddInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Retrieve session

        if (session != null && "admin".equals(session.getAttribute("privilege"))) {
            String info = request.getParameter("info");

            try {
                Connection conn = DB.getCon();
                String sql = "INSERT INTO information (info) VALUES (?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, info);
                pstmt.executeUpdate();

                response.getWriter().println("Information added successfully.");
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println("Database error: " + e.getMessage());
            }
        } else {
            response.getWriter().println("Access denied. Only admins can add information.");
        }
    }
}
