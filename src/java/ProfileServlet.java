/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nithi
 */
public class ProfileServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html");
          HttpSession session = request.getSession(false); // Don't create a new session

        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            out.println("<h1>Welcome to your Profile, " + username + "!</h1>");
            out.println("  <h1>Add a New Book</h1>\n" +
"    <form action=\"AddBookServlet2\" method=\"post\">\n" +
"        <label>Title:</label>\n" +
"        <input type=\"text\" name=\"title\" required><br><br>\n" +
"        <label>Author:</label>\n" +
"        <input type=\"text\" name=\"author\" required><br><br>\n" +
"        <label>Publisher:</label>\n" +
"        <input type=\"text\" name=\"publisher\" required><br><br>\n" +
"        <label>Year:</label>\n" +
"        <input type=\"number\" name=\"year\" required><br><br>\n" +
"        <input type=\"submit\" value=\"Add Book\">\n" +
"    </form>\n" +
"    <a href=\"ViewBooksServlet\">viewbooks</a>");
            out.println("<br><a href='LogoutServlet'>Logout</a>");
        } else {
            out.println("<h1>You are not logged in!</h1>");
            out.println("<a href='login.html'>Login</a>");
        }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
