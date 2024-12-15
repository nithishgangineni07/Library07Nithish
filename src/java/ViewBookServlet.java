import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Library Books</h1>");
        out.println("<table border='1'><thead><tr><th>Title</th><th>Author</th><th>Publisher</th><th>Year</th><th>Delete</th></tr></thead><tbody>");

        try (Connection con = DBUtil.getConnection()) {
            String query = "SELECT * FROM library_books";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString(1) + "</td>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("<td>" + rs.getString(3) + "</td>");
                out.println("<td>" + rs.getString(4) + "</td>");
              
                out.println("<td><a href='DeleteBookServlet?book_id=" + rs.getInt("book_id") + "'>Delete</a></td>");
                out.println("</tr>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println("</tbody></table>");
    }
}

